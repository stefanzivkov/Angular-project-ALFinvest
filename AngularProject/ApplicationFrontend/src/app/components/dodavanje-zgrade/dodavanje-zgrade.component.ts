import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ZgradaService } from 'src/app/services/zgrada.service';

@Component({
  selector: 'app-dodavanje-zgrade',
  templateUrl: './dodavanje-zgrade.component.html',
  styleUrls: ['./dodavanje-zgrade.component.css'],
})
export class DodavanjeZgradeComponent implements OnInit {
  constructor(private router: Router, private zgradaService: ZgradaService) {}

  ngOnInit(): void {}

  dodajZgradu(zgradaForm: any) {
    if (!zgradaForm.invalid) {
      this.zgradaService.dodavanjeZgrade(zgradaForm).subscribe((resp) => {
        if (resp) {
          this.router.navigate(['/pocetna']);
        } else {
          alert('Doslo je do greske.');
        }
      });
    } else {
      alert('Popunite sva polja.');
    }
  }
}
