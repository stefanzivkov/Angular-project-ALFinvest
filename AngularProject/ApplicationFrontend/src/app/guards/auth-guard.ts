import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {
  public idUloga!: number;
  constructor(private router: Router) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    var x = localStorage.getItem('idUloga');
    if (x != null) {
      alert('Vec ste ulogovani!');
      this.router.navigate(['/pocetna']);
      return false;
    }
    return true;
  }
}
