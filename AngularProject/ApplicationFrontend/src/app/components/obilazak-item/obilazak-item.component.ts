import { Component, Input, OnInit } from '@angular/core';
import { Obilazak } from 'src/app/model/obilazak';
import { Zgrada } from 'src/app/model/zgrada';
import { ObilazakService } from 'src/app/services/obilazak.service';

@Component({
  selector: 'app-obilazak-item',
  templateUrl: './obilazak-item.component.html',
  styleUrls: ['./obilazak-item.component.css'],
})
export class ObilazakItemComponent implements OnInit {
  @Input() obilazak!: Obilazak;
  zgrada!: Zgrada;

  constructor(private obilazakService: ObilazakService) {}

  ngOnInit(): void {
    this.obilazakService
      .zgradaObilazak(this.obilazak.idObilazak)
      .subscribe((resp) => {
        this.zgrada = resp;
      });
  }

  proveriUlogovanost(): boolean {
    if (localStorage.getItem('idUloga') == '2') {
      return true;
    } else {
      return false;
    }
  }

  potvrdiObilazak() {
    console.log('obilazak azuriranje');
    this.obilazakService
      .azuriranjeObilaska(this.obilazak.idObilazak)
      .subscribe((resp) => {
        if (resp) {
          window.location.reload();
        }
      });
  }
}
