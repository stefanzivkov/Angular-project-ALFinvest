import { i18nMetaToJSDoc } from '@angular/compiler/src/render3/view/i18n/meta';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from 'src/app/model/korisnik';
import { Stan } from 'src/app/model/stan';
import { Zgrada } from 'src/app/model/zgrada';
import { KorisnikService } from 'src/app/services/korisnik.service';
import { ProdajaService } from 'src/app/services/prodaja.service';
import { StanService } from 'src/app/services/stan.service';

@Component({
  selector: 'app-dodavanje-prodaje',
  templateUrl: './dodavanje-prodaje.component.html',
  styleUrls: ['./dodavanje-prodaje.component.css'],
})
export class DodavanjeProdajeComponent implements OnInit {
  stanovi: Stan[] | undefined;
  kupci: Korisnik[] | undefined;

  constructor(
    private prodajaService: ProdajaService,
    private korisnikService: KorisnikService,
    private stanService: StanService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.stanService.sviStanovi().subscribe((resp) => {
      this.stanovi = resp;
    });
    this.korisnikService.sviKupci().subscribe((resp) => {
      this.kupci = resp;
    });
  }

  dodajProdaju(prodajaForm: any) {
    if (!prodajaForm.invalid) {
      this.prodajaService
        .dodavanjeProdaje(
          prodajaForm.value.idKorisnik,
          prodajaForm.value.idStan,
          prodajaForm.value.datum
        )
        .subscribe((resp) => {
          if (resp) {
            this.router.navigate(['/pocetna']);
          }
        });
    } else {
      alert('Popunite sva polja.');
    }
  }
}
