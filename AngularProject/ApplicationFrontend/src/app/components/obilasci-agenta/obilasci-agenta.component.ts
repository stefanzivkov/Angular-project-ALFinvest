import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { throttleTime } from 'rxjs';
import { Obilazak } from 'src/app/model/obilazak';
import { ObilazakService } from 'src/app/services/obilazak.service';

@Component({
  selector: 'app-obilasci-agenta',
  templateUrl: './obilasci-agenta.component.html',
  styleUrls: ['./obilasci-agenta.component.css'],
})
export class ObilasciAgentaComponent implements OnInit {
  obilasci: Obilazak[] | undefined;

  constructor(
    private obilazakService: ObilazakService,
    private route: ActivatedRoute
  ) {
    console.log('test');
  }

  ngOnInit(): void {
    console.log('obilasci agenta ' + this.route.snapshot.params['id']);
    if (localStorage.getItem('idUloga') == '1') {
      this.obilazakService
        .obilasciAgenta(Number(this.route.snapshot.params['id']))
        .subscribe((resp) => {
          this.obilasci = resp;
        });
    } else {
      this.obilazakService
        .obilasciAgenta(Number(localStorage.getItem('idKorisnika')))
        .subscribe((resp) => {
          this.obilasci = resp;
        });
    }
  }
}
