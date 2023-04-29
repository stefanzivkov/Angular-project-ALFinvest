import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Korisnik } from '../model/korisnik';

@Injectable({
  providedIn: 'root',
})
export class AgentService {
  BACKEND_BASE = 'http://localhost:8080/ALFinvest/vlasnik/';
  constructor(private httpClient: HttpClient) {}

  dodavanjeAgenta(agentForm: any): any {
    console.log('dodavanje');
    let params = new HttpParams()
      .set('ime', agentForm.value.ime)
      .set('prezime', agentForm.value.prezime)
      .set('username', agentForm.value.username)
      .set('password', agentForm.value.password)
      .set('email', agentForm.value.email);

    return this.httpClient.post(this.BACKEND_BASE + 'unosAgenta', params);
  }

  prikazSvihAgenata(): Observable<Korisnik[]> {
    return this.httpClient.get<Korisnik[]>(
      this.BACKEND_BASE + 'prikazSvihAgenata'
    );
  }
}
