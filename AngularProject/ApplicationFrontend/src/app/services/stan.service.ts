import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Komentar } from '../model/komentar';
import { Stan } from '../model/stan';
import { Zgrada } from '../model/zgrada';

@Injectable({
  providedIn: 'root',
})
export class StanService {
  BACKEND_BASE = 'http://localhost:8080/ALFinvest/korisnik/';
  BACKEND_BASE1 = 'http://localhost:8080/ALFinvest/kupac/';
  BACKEND_BASE2 = 'http://localhost:8080/ALFinvest/agent/';

  constructor(private httpClient: HttpClient) {}

  public getStanovi(): Observable<Stan[]> {
    if (localStorage.getItem('uloga') == 'agent') {
      this.httpClient.get<Stan[]>(this.BACKEND_BASE + 'sviStanovi');
    }
    return this.httpClient.get<Stan[]>(this.BACKEND_BASE + 'slobodniStanovi');
  }

  public pretragaStanova(grad: string): Observable<Stan[]> {
    return this.httpClient.get<Stan[]>(
      this.BACKEND_BASE + 'pretragaStanovaGrad/' + grad
    );
  }

  public getZgradaStan(idStana: number): Observable<Zgrada> {
    return this.httpClient.get<Zgrada>(
      this.BACKEND_BASE + 'getZgradaStan/' + idStana
    );
  }

  public prikazStana(idStan: number): Observable<Stan> {
    return this.httpClient.get<Stan>(
      this.BACKEND_BASE + 'prikazStana/' + idStan
    );
  }

  public omiljeniStanovi(idKorisnik: number): Observable<Stan[]> {
    console.log('korisnik ' + idKorisnik);
    return this.httpClient.get<Stan[]>(
      this.BACKEND_BASE1 + 'omiljeniStanovi/' + idKorisnik
    );
  }

  public dodajUOmiljene(idStan: any, idKorisnik: any) {
    let params = new HttpParams()
      .set('idStan', idStan)
      .set('idKorisnik', idKorisnik);
    return this.httpClient.post(this.BACKEND_BASE1 + 'dodajUOmiljene', params);
  }

  public dodajKomentar(idKorisnik: number, idStan: number, komentar: string) {
    let params = new HttpParams()
      .set('idStan', idStan)
      .set('idKorisnik', idKorisnik)
      .set('komentar', komentar);
    return this.httpClient.post(
      this.BACKEND_BASE1 + 'dodavanjeKomentara',
      params
    );
  }

  dodavanjeStana(stanForm: any, idZgrada: number, idKorisnik: number) {
    let params = new HttpParams()
      .set('idZgrada', idZgrada)
      .set('idKorisnik', idKorisnik)
      .set('cena', stanForm.value.cena)
      .set('kvadratura', stanForm.value.kvadratura)
      .set('opis', stanForm.value.opis)
      .set('broj', stanForm.value.broj)
      .set('sprat', stanForm.value.sprat);

    return this.httpClient.post(this.BACKEND_BASE2 + 'dodavanjeStana', params);
  }

  public prikazKomentara(idStan: number): Observable<Komentar[]> {
    return this.httpClient.get<Komentar[]>(
      this.BACKEND_BASE1 + 'prikazKomentara/' + idStan
    );
  }

  sviStanovi(): Observable<Stan[]> {
    return this.httpClient.get<Stan[]>(this.BACKEND_BASE2 + 'sviStanovi');
  }

  azuriranjeStana(idStan: number, cena: number) {
    let params = new HttpParams().set('idStan', idStan).set('cena', cena);
    return this.httpClient.post(this.BACKEND_BASE2 + 'azuriranjeStana', params);
  }
}
