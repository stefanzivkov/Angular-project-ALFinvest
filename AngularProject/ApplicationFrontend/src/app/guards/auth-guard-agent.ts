import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';

@Injectable()
export class AuthGuardAgent implements CanActivate {
  public idUloga!: number;
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    var x = localStorage.getItem('idUloga');
    if (x != null) {
      this.idUloga = +x;
      if (localStorage.getItem('token') && this.idUloga == 2) {
        return true;
      }
    }
    alert('Niste ulogovani kao agent!');
    this.router.navigate(['/pocetna']);
    return false;
  }
}
