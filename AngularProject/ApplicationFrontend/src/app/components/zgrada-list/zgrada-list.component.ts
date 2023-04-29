import { Component, OnInit } from '@angular/core';
import { Zgrada } from 'src/app/model/zgrada';
import { ZgradaService } from 'src/app/services/zgrada.service';

@Component({
  selector: 'app-zgrada-list',
  templateUrl: './zgrada-list.component.html',
  styleUrls: ['./zgrada-list.component.css'],
})
export class ZgradaListComponent implements OnInit {
  zgrade: Zgrada[] | undefined;

  constructor(private zgradaService: ZgradaService) {}

  ngOnInit(): void {
    this.zgradaService.sveZgrade().subscribe((resp: any) => {
      this.zgrade = resp;
    });
  }
}
