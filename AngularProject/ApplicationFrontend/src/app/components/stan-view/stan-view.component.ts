import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Komentar } from 'src/app/model/komentar';
import { Stan } from 'src/app/model/stan';
import { Zgrada } from 'src/app/model/zgrada';
import { StanService } from 'src/app/services/stan.service';

@Component({
  selector: 'app-stan-view',
  templateUrl: './stan-view.component.html',
  styleUrls: ['./stan-view.component.css'],
})
export class StanViewComponent implements OnInit {
  @Input() stan!: Stan;
  zgrada!: Zgrada;
  komentari: Komentar[] | undefined;

  constructor(
    private route: ActivatedRoute,
    private stanService: StanService,
    private router: Router
  ) {
    const idStan = this.route.snapshot.params['id'];
    this.stanService.prikazStana(idStan).subscribe((resp) => {
      this.stan = resp;
      this.stanService.getZgradaStan(this.stan.idStan).subscribe((resp) => {
        this.zgrada = resp;
      });
      this.stanService.prikazKomentara(this.stan.idStan).subscribe((resp) => {
        this.komentari = resp;
      });
    });
  }

  ngOnInit(): void {}

  proveriUlogovanost(): boolean {
    if (localStorage.getItem('idUloga') == '3') {
      return true;
    } else {
      return false;
    }
  }

  proveriUlogovanostAgent(): boolean {
    if (localStorage.getItem('idUloga') == '2') {
      return true;
    } else {
      return false;
    }
  }

  dodajUOmiljene() {
    this.stanService
      .dodajUOmiljene(
        this.stan.idStan,
        Number(localStorage.getItem('idKorisnika'))
      )
      .subscribe((resp) => {
        console.log('Resp ' + resp);
        if (resp == false) {
          alert('Stan je vec dodat u omiljene.');
          window.location.reload();
        } else {
          alert('Stan je dodat u omiljene.');
          window.location.reload();
          console.log('dodat u omiljene');
        }
      });
  }

  dodajKomentar(komentarForm: any) {
    console.log('komentar' + komentarForm.value.komentar);
    this.stanService
      .dodajKomentar(
        Number(localStorage.getItem('idKorisnika')),
        this.stan.idStan,
        komentarForm.value.komentar
      )
      .subscribe((resp) => {
        window.location.reload();
      });
  }
}
