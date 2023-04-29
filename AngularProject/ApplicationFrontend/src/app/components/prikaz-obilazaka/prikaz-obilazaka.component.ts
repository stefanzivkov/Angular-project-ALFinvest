import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Obilazak } from 'src/app/model/obilazak';
import { ObilazakService } from 'src/app/services/obilazak.service';

@Component({
  selector: 'app-prikaz-obilazaka',
  templateUrl: './prikaz-obilazaka.component.html',
  styleUrls: ['./prikaz-obilazaka.component.css'],
})
export class PrikazObilazakaComponent implements OnInit {
  obilasci: Obilazak[] | undefined;

  constructor(private obilazakService: ObilazakService) {}

  ngOnInit(): void {
    this.obilazakService
      .obilasci(Number(localStorage.getItem('idKorisnika')))
      .subscribe((resp) => {
        this.obilasci = resp;
      });
  }
}
