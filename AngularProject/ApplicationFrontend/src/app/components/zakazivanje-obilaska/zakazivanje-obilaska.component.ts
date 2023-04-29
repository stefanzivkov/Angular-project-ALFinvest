import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Stan } from 'src/app/model/stan';
import { ObilazakService } from 'src/app/services/obilazak.service';

@Component({
  selector: 'app-zakazivanje-obilaska',
  templateUrl: './zakazivanje-obilaska.component.html',
  styleUrls: ['./zakazivanje-obilaska.component.css'],
})
export class ZakazivanjeObilaskaComponent implements OnInit {
  constructor(
    private obilazakService: ObilazakService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {}

  zakazivanjeObilaska(obilazakForm: any) {
    const idStana = this.route.snapshot.params['id'];
    console.log('zakazivanje ' + idStana);
    this.obilazakService
      .zakazivanjeObilaska(
        idStana,
        obilazakForm.value.vreme,
        obilazakForm.value.datum,
        obilazakForm.value.napomena,
        Number(localStorage.getItem('idKorisnika'))!
      )
      .subscribe((resp) => {
        if (resp) {
          alert('Uspesno zakazan obilazak.');
        } else {
          alert('Vec postoji zakazan obilazak sa tim datumom i vremenom.');
        }
      });
  }
}
