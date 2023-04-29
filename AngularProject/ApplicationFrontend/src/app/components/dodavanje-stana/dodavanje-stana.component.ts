import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Korisnik } from 'src/app/model/korisnik';
import { Zgrada } from 'src/app/model/zgrada';
import { KorisnikService } from 'src/app/services/korisnik.service';
import { StanService } from 'src/app/services/stan.service';
import { ZgradaService } from 'src/app/services/zgrada.service';

@Component({
  selector: 'app-dodavanje-stana',
  templateUrl: './dodavanje-stana.component.html',
  styleUrls: ['./dodavanje-stana.component.css'],
})
export class DodavanjeStanaComponent implements OnInit {
  zgrade: Zgrada[] | undefined;
  kupci: Korisnik[] | undefined;

  constructor(
    private stanService: StanService,
    private router: Router,
    private zgradaService: ZgradaService,
    private korisnikService: KorisnikService
  ) {}

  ngOnInit(): void {
    this.zgradaService.sveZgrade().subscribe((resp) => {
      this.zgrade = resp;
    });
    this.korisnikService.sviKupci().subscribe((resp) => {
      this.kupci = resp;
    });
  }

  dodajStan(stanForm: any) {
    console.log(stanForm);
    if (!stanForm.invalid) {
      this.stanService
        .dodavanjeStana(
          stanForm,
          Number(stanForm.value.idZgrada),
          Number(localStorage.getItem('idKorisnika'))
        )
        .subscribe((resp) => {
          if (resp) {
            this.router.navigate(['stanovi']);
          } else {
            alert('Greska prilikom unosa, pokusaj ponovo.');
          }
        });
    } else {
      alert('Popunite polja.');
    }
  }
}
