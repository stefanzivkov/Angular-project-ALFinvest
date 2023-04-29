import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { KorisnikService } from 'src/app/services/korisnik.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  constructor(
    private korisnikService: KorisnikService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  public register(registerForm: NgForm) {
    if (!registerForm.invalid) {
      this.korisnikService.register(registerForm).subscribe((resp: any) => {
        if (resp == true) {
          this.router.navigate(['/login']);
        } else {
          alert('Pokusajte ponovo! Vec postoji korisnik sa ovim username-om.');
        }
      });
    } else {
      alert('Unesite sve podatke.');
    }
  }
}
