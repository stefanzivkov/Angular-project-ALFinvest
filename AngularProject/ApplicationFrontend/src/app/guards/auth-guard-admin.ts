import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';

@Injectable()
export class AuthGuardAdmin implements CanActivate {
  public idUloga!: number;
  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    var x = localStorage.getItem('idUloga');
    if (x != null) {
      this.idUloga = +x;
      if (localStorage.getItem('token') && this.idUloga == 1) {
        return true;
      }
    }
    alert('Niste ulogovani kao admin!');
    this.router.navigate(['/pocetna']);
    return false;
  }
}
