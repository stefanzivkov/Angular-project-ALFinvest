import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik';
import { AgentService } from 'src/app/services/agent.service';

@Component({
  selector: 'app-agent-list',
  templateUrl: './agent-list.component.html',
  styleUrls: ['./agent-list.component.css'],
})
export class AgentListComponent implements OnInit {
  agenti: Korisnik[] | undefined;

  constructor(private agentService: AgentService) {}

  ngOnInit(): void {
    this.agentService.prikazSvihAgenata().subscribe((resp) => {
      this.agenti = resp;
    });
  }
}
