import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Zgrada } from 'src/app/model/zgrada';
import { ZgradaService } from 'src/app/services/zgrada.service';

@Component({
  selector: 'app-pocetna',
  templateUrl: './pocetna.component.html',
  styleUrls: ['./pocetna.component.css'],
})
export class PocetnaComponent implements OnInit {
  zgradeTri: Zgrada[] | undefined;
  zgrade: Zgrada[] | undefined;

  constructor(private zgradaService: ZgradaService, private router: Router) {}

  ngOnInit(): void {
    this.zgradaService.sveZgrade().subscribe((resp: any) => {
      this.zgrade = resp;
      this.zgradeTri = resp.slice(0, 3);
      console.log(this.zgradeTri);
    });
  }

  sveZgrade() {
    this.router.navigate(['/sveZgrade']);
  }
}
