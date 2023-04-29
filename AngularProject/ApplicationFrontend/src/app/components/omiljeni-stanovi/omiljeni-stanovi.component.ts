import { Component, OnInit } from '@angular/core';
import { Stan } from 'src/app/model/stan';
import { StanService } from 'src/app/services/stan.service';

@Component({
  selector: 'app-omiljeni-stanovi',
  templateUrl: './omiljeni-stanovi.component.html',
  styleUrls: ['./omiljeni-stanovi.component.css'],
})
export class OmiljeniStanoviComponent implements OnInit {
  constructor(private stanService: StanService) {}

  omiljeniStanovi: Stan[] | undefined;
  velicinaNiza: number = 0;

  ngOnInit(): void {
    this.stanService
      .omiljeniStanovi(Number(localStorage.getItem('idKorisnika')))
      .subscribe((resp) => {
        this.omiljeniStanovi = resp;
        this.velicinaNiza = this.omiljeniStanovi!.length;
      });
  }
}
