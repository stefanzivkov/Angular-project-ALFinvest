import { Component, Input, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik';
import { Prodaja } from 'src/app/model/prodaja';
import { ProdajaService } from 'src/app/services/prodaja.service';

@Component({
  selector: 'app-agent-item',
  templateUrl: './agent-item.component.html',
  styleUrls: ['./agent-item.component.css'],
})
export class AgentItemComponent implements OnInit {
  @Input() agent!: Korisnik;
  prodaje: Prodaja[] | undefined;
  brojProdaja!: number;

  constructor(private prodajaService: ProdajaService) {
    // console.log(this.agent.idKorisnik);
  }

  ngOnInit(): void {
    this.prodajaService
      .prodajeAgenta(this.agent.idKorisnik)
      .subscribe((resp) => {
        this.prodaje = resp;
        this.brojProdaja = this.prodaje.length;
      });
  }
}
