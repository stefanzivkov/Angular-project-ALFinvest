import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ApplicationFrontend';
  idKorisnika!: number;

  logout() {
    localStorage.clear();
  }

  proveriUlogovanost(): boolean {
    if (localStorage.getItem('idUloga') == null) {
      return true;
    } else {
      return false;
    }
  }

  proveriUlogovanost1(): boolean {
    if (localStorage.getItem('idUloga') == null) {
      return false;
    } else {
      return true;
    }
  }

  kupacUlogovanost(): boolean {
    if (localStorage.getItem('idUloga') == null) {
      return false;
    } else {
      if (localStorage.getItem('idUloga') == '3') {
        return true;
      } else {
        return false;
      }
    }
  }

  adminUlogovanost(): boolean {
    if (localStorage.getItem('idUloga') == null) {
      return false;
    } else {
      if (localStorage.getItem('idUloga') == '1') {
        return true;
      } else {
        return false;
      }
    }
  }

  agentUlogovanost(): boolean {
    if (localStorage.getItem('idUloga') == null) {
      return false;
    } else {
      if (localStorage.getItem('idUloga') == '2') {
        this.idKorisnika = Number(localStorage.getItem('idKorisnika'));
        return true;
      } else {
        return false;
      }
    }
  }
}
