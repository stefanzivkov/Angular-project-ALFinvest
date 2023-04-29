import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stan } from '../model/stan';
import { Zgrada } from '../model/zgrada';

@Injectable({
  providedIn: 'root',
})
export class ZgradaService {
  BACKEND_BASE = 'http://localhost:8080/ALFinvest/korisnik/';
  BACKEND_BASE1 = 'http://localhost:8080/ALFinvest/agent/';

  constructor(private httpClient: HttpClient) {}

  public sveZgrade(): Observable<Zgrada[]> {
    return this.httpClient.get<Zgrada[]>(this.BACKEND_BASE + 'sveZgrade');
  }

  public stanoviZgrade(idZgrade: any): Observable<Stan[]> {
    return this.httpClient.get<Stan[]>(
      this.BACKEND_BASE + 'stanoviZgrade/' + idZgrade
    );
  }

  public getZgrada(idZgrada: any): Observable<Zgrada> {
    return this.httpClient.get<Zgrada>(
      this.BACKEND_BASE + 'getZgrada/' + idZgrada
    );
  }

  public dodavanjeZgrade(zgradaForm: any) {
    let params = new HttpParams()
      .set('godina', zgradaForm.value.godina)
      .set('adresa', zgradaForm.value.adresa)
      .set('grad', zgradaForm.value.grad);
    return this.httpClient.post(this.BACKEND_BASE1 + 'dodavanjeZgrade', params);
  }
}
