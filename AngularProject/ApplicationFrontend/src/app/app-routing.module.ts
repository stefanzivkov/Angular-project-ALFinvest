import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgentListComponent } from './components/agent-list/agent-list.component';
import { AzuriranjeStanaComponent } from './components/azuriranje-stana/azuriranje-stana.component';
import { DodavanjeAgentaComponent } from './components/dodavanje-agenta/dodavanje-agenta.component';
import { DodavanjeProdajeComponent } from './components/dodavanje-prodaje/dodavanje-prodaje.component';
import { DodavanjeStanaComponent } from './components/dodavanje-stana/dodavanje-stana.component';
import { DodavanjeZgradeComponent } from './components/dodavanje-zgrade/dodavanje-zgrade.component';
import { InformationsComponent } from './components/informations/informations.component';
import { LoginComponent } from './components/login/login.component';
import { ObilasciAgentaComponent } from './components/obilasci-agenta/obilasci-agenta.component';
import { OmiljeniStanoviComponent } from './components/omiljeni-stanovi/omiljeni-stanovi.component';
import { PocetnaComponent } from './components/pocetna/pocetna.component';
import { PrikazObilazakaComponent } from './components/prikaz-obilazaka/prikaz-obilazaka.component';
import { RegisterComponent } from './components/register/register.component';
import { StanListComponent } from './components/stan-list/stan-list.component';
import { StanViewComponent } from './components/stan-view/stan-view.component';
import { StanoviZgradeComponent } from './components/stanovi-zgrade/stanovi-zgrade.component';
import { ZakazivanjeObilaskaComponent } from './components/zakazivanje-obilaska/zakazivanje-obilaska.component';
import { ZgradaListComponent } from './components/zgrada-list/zgrada-list.component';
import { AuthGuard } from './guards/auth-guard';
import { AuthGuardAdmin } from './guards/auth-guard-admin';
import { AuthGuardAgent } from './guards/auth-guard-agent';
import { AuthGuardKupac } from './guards/auth-guard-kupac';
import { OmiljeniStanovi } from './model/omiljenistanovi';

const routes: Routes = [
  { path: '', redirectTo: 'pocetna', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, canActivate: [AuthGuard] },
  {
    path: 'registracija',
    component: RegisterComponent,
  },
  { path: 'informacije', component: InformationsComponent },
  { path: 'pocetna', component: PocetnaComponent },
  { path: 'sveZgrade', component: ZgradaListComponent },
  { path: 'stanoviZgrade/:id', component: StanoviZgradeComponent },
  { path: 'prikazStana/:id', component: StanViewComponent },
  { path: 'stanovi', component: StanListComponent },
  {
    path: 'zakazivanjeObilaska/:id',
    component: ZakazivanjeObilaskaComponent,
    canActivate: [AuthGuardKupac],
  },
  { path: 'obilasci', component: PrikazObilazakaComponent },
  { path: 'obilasciAgenta/:id', component: ObilasciAgentaComponent },
  {
    path: 'omiljeniStanovi',
    component: OmiljeniStanoviComponent,
    canActivate: [AuthGuardKupac],
  },
  {
    path: 'agenti',
    component: AgentListComponent,
    canActivate: [AuthGuardAdmin],
  },
  {
    path: 'dodajAgenta',
    component: DodavanjeAgentaComponent,
    canActivate: [AuthGuardAdmin],
  },
  {
    path: 'dodajStan',
    component: DodavanjeStanaComponent,
    canActivate: [AuthGuardAgent],
  },
  {
    path: 'dodajZgradu',
    component: DodavanjeZgradeComponent,
    canActivate: [AuthGuardAgent],
  },
  {
    path: 'dodajProdaju',
    component: DodavanjeProdajeComponent,
    canActivate: [AuthGuardAgent],
  },
  {
    path: 'azuriranjeStana/:id',
    component: AzuriranjeStanaComponent,
    canActivate: [AuthGuardAgent],
  },
  { path: '**', component: PocetnaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
