import { Component, Input, OnInit } from '@angular/core';
import { Komentar } from 'src/app/model/komentar';
import { Korisnik } from 'src/app/model/korisnik';
import { KorisnikService } from 'src/app/services/korisnik.service';

@Component({
  selector: 'app-komentar',
  templateUrl: './komentar.component.html',
  styleUrls: ['./komentar.component.css'],
})
export class KomentarComponent implements OnInit {
  @Input() komentar!: Komentar;
  korisnik!: Korisnik;

  constructor(private korisnikService: KorisnikService) {}

  ngOnInit(): void {
    this.korisnikService
      .komentarKorisnik(this.komentar.idKomentar)
      .subscribe((resp) => {
        this.korisnik = resp;
      });
  }
}
