import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Prodaja } from '../model/prodaja';

@Injectable({
  providedIn: 'root',
})
export class ProdajaService {
  BACKEND_BASE = 'http://localhost:8080/ALFinvest/agent/';
  BACKEND_BASE1 = 'http://localhost:8080/ALFinvest/vlasnik/';
  constructor(private httpClient: HttpClient) {}

  prodajeAgenta(idKorisnik: any): Observable<Prodaja[]> {
    return this.httpClient.get<Prodaja[]>(
      this.BACKEND_BASE1 + 'prodajeAgenta/' + idKorisnik
    );
  }

  dodavanjeProdaje(idKorisnik: number, idStan: number, datum: Date) {
    let params = new HttpParams()
      .set('idKorisnik', idKorisnik)
      .set('idStan', idStan)
      .set('datum', datum.toString());
    return this.httpClient.post(this.BACKEND_BASE + 'dodavanjeProdaje', params);
  }
}
