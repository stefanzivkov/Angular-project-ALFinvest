import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Obilazak } from '../model/obilazak';
import { Zgrada } from '../model/zgrada';

@Injectable({
  providedIn: 'root',
})
export class ObilazakService {
  BACKEND_BASE = 'http://localhost:8080/ALFinvest/kupac/';
  BACKEND_BASE1 = 'http://localhost:8080/ALFinvest/vlasnik/';
  BACKEND_BASE2 = 'http://localhost:8080/ALFinvest/agent/';
  constructor(private httpClient: HttpClient) {}

  zakazivanjeObilaska(
    idStan: number,
    vreme: string,
    datum: Date,
    napomena: string,
    idKorisnik: number
  ) {
    let params = new HttpParams()
      .set('idStan', idStan)
      .set('vreme', vreme)
      .set('datum', datum.toString())
      .set('idKorisnik', idKorisnik)
      .set('napomena', napomena);
    console.log('zakazivanje servis');

    return this.httpClient.post(
      this.BACKEND_BASE + 'dodavanjeObilaska',
      params
    );
  }

  obilasci(idKorisnik: any): Observable<Obilazak[]> {
    return this.httpClient.get<Obilazak[]>(
      this.BACKEND_BASE + 'getObilasci/' + idKorisnik
    );
  }

  obilasciAgenta(idKorisnik: any): Observable<Obilazak[]> {
    return this.httpClient.get<Obilazak[]>(
      this.BACKEND_BASE1 + 'obilasciAgenta/' + idKorisnik
    );
  }

  zgradaObilazak(idObilazak: any): Observable<Zgrada> {
    return this.httpClient.get<Zgrada>(
      this.BACKEND_BASE + 'getZgrada/' + idObilazak
    );
  }

  azuriranjeObilaska(idObilazak: number) {
    return this.httpClient.get(
      this.BACKEND_BASE2 + 'azuriranjeObilaska/' + idObilazak
    );
  }
}
