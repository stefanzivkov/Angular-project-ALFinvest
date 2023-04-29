import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { InformationsComponent } from './components/informations/informations.component';
import { StanoviZgradeComponent } from './components/stanovi-zgrade/stanovi-zgrade.component';
import { PocetnaComponent } from './components/pocetna/pocetna.component';
import { ZgradaListComponent } from './components/zgrada-list/zgrada-list.component';
import { StanListComponent } from './components/stan-list/stan-list.component';
import { StanItemComponent } from './components/stan-item/stan-item.component';
import { StanViewComponent } from './components/stan-view/stan-view.component';
import { KorisnikService } from './services/korisnik.service';
import { StanService } from './services/stan.service';
import { ZgradaService } from './services/zgrada.service';
import { AuthGuard } from './guards/auth-guard';
import { AuthGuardAdmin } from './guards/auth-guard-admin';
import { AuthGuardKupac } from './guards/auth-guard-kupac';
import { AuthGuardAgent } from './guards/auth-guard-agent';
import { TokenInterceptor } from './services/token-interceptor';
import { ZakazivanjeObilaskaComponent } from './components/zakazivanje-obilaska/zakazivanje-obilaska.component';
import { PrikazObilazakaComponent } from './components/prikaz-obilazaka/prikaz-obilazaka.component';
import { OmiljeniStanoviComponent } from './components/omiljeni-stanovi/omiljeni-stanovi.component';
import { ObilazakItemComponent } from './components/obilazak-item/obilazak-item.component';
import { MatBadgeModule } from '@angular/material/badge';
import { DodavanjeAgentaComponent } from './components/dodavanje-agenta/dodavanje-agenta.component';
import { AgentListComponent } from './components/agent-list/agent-list.component';
import { AgentItemComponent } from './components/agent-item/agent-item.component';
import { ObilasciAgentaComponent } from './components/obilasci-agenta/obilasci-agenta.component';
import { DodavanjeStanaComponent } from './components/dodavanje-stana/dodavanje-stana.component';
import { DodavanjeZgradeComponent } from './components/dodavanje-zgrade/dodavanje-zgrade.component';
import { DodavanjeProdajeComponent } from './components/dodavanje-prodaje/dodavanje-prodaje.component';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { AzuriranjeStanaComponent } from './components/azuriranje-stana/azuriranje-stana.component';
import { KomentarComponent } from './components/komentar/komentar.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    InformationsComponent,
    StanoviZgradeComponent,
    PocetnaComponent,
    ZgradaListComponent,
    StanListComponent,
    StanItemComponent,
    StanViewComponent,
    ZakazivanjeObilaskaComponent,
    PrikazObilazakaComponent,
    OmiljeniStanoviComponent,
    ObilazakItemComponent,
    DodavanjeAgentaComponent,
    AgentListComponent,
    AgentItemComponent,
    ObilasciAgentaComponent,
    DodavanjeStanaComponent,
    DodavanjeZgradeComponent,
    DodavanjeProdajeComponent,
    AzuriranjeStanaComponent,
    KomentarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatBadgeModule,
    MatMenuModule,
    MatSelectModule,
    FormsModule,
  ],
  providers: [
    KorisnikService,
    StanService,
    ZgradaService,
    AuthGuard,
    AuthGuardAdmin,
    AuthGuardKupac,
    AuthGuardAgent,
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
  ],
  bootstrap: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    InformationsComponent,
    StanViewComponent,
  ],
})
export class AppModule {}
