import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AgentService } from 'src/app/services/agent.service';

@Component({
  selector: 'app-dodavanje-agenta',
  templateUrl: './dodavanje-agenta.component.html',
  styleUrls: ['./dodavanje-agenta.component.css'],
})
export class DodavanjeAgentaComponent implements OnInit {
  constructor(private agentService: AgentService, private router: Router) {}

  ngOnInit(): void {}

  dodajAgenta(agentForm: any) {
    this.agentService.dodavanjeAgenta(agentForm).subscribe((resp: any) => {
      if (resp == true) {
        this.router.navigate(['/agenti']);
      } else {
        alert('Doslo je do greske, pokusajte ponovo. Username vec postoji.');
      }
    });
  }
}
