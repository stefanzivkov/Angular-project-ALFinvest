import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Korisnik } from '../model/korisnik';

@Injectable({
  providedIn: 'root',
})
export class KorisnikService {
  BACKEND_BASE = 'http://localhost:8080/ALFinvest/korisnik/';
  BACKEND_BASE1 = 'http://localhost:8080/ALFinvest/agent/';

  constructor(private httpClient: HttpClient) {}

  register(registerForm: any): any {
    let params = new HttpParams()
      .set('ime', registerForm.value.ime)
      .set('prezime', registerForm.value.prezime)
      .set('username', registerForm.value.username)
      .set('password', registerForm.value.password)
      .set('email', registerForm.value.email);

    return this.httpClient.post(this.BACKEND_BASE + 'register', params);
  }

  login(username: string, password: string) {
    let params = new HttpParams()
      .set('username', username)
      .set('password', password);

    return this.httpClient.post(this.BACKEND_BASE + 'login', params);
  }

  sviKupci(): Observable<Korisnik[]> {
    return this.httpClient.get<Korisnik[]>(this.BACKEND_BASE1 + 'sviKupci');
  }

  komentarKorisnik(idKomentar: number): Observable<Korisnik> {
    return this.httpClient.get<Korisnik>(
      this.BACKEND_BASE + 'korisnikKomentar/' + idKomentar
    );
  }
}
