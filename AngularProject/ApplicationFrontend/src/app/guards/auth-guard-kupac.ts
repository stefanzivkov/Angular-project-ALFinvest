import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';

@Injectable()
export class AuthGuardKupac implements CanActivate {
  public idUloga!: number;
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    var x = localStorage.getItem('idUloga');
    if (x != null) {
      this.idUloga = +x;
      if (localStorage.getItem('token') && this.idUloga == 3) {
        return true;
      }
    }
    alert('Niste ulogovani!');
    this.router.navigate(['/pocetna']);
    return false;
  }
}
