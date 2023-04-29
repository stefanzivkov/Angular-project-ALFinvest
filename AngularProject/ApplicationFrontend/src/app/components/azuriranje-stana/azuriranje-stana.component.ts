import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Stan } from 'src/app/model/stan';
import { Zgrada } from 'src/app/model/zgrada';
import { StanService } from 'src/app/services/stan.service';
import { ZgradaService } from 'src/app/services/zgrada.service';

@Component({
  selector: 'app-azuriranje-stana',
  templateUrl: './azuriranje-stana.component.html',
  styleUrls: ['./azuriranje-stana.component.css'],
})
export class AzuriranjeStanaComponent implements OnInit {
  @Input() stan!: Stan;
  zgrada!: Zgrada;

  constructor(
    private route: ActivatedRoute,
    private stanService: StanService,
    private zgradaService: ZgradaService
  ) {}

  ngOnInit(): void {
    const idStan = this.route.snapshot.params['id'];
    this.stanService.prikazStana(idStan).subscribe((resp) => {
      this.stan = resp;
      this.stanService.getZgradaStan(this.stan.idStan).subscribe((resp) => {
        this.zgrada = resp;
      });
    });
  }

  azuriranjeStana(stanForm: any) {
    this.stanService
      .azuriranjeStana(this.stan.idStan, stanForm.value.cena)
      .subscribe((resp) => {
        if (resp) {
          window.location.reload();
        }
      });
  }
}
