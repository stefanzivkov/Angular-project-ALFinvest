import { Component, OnInit } from '@angular/core';
import { Stan } from 'src/app/model/stan';
import { StanService } from 'src/app/services/stan.service';

@Component({
  selector: 'app-stan-list',
  templateUrl: './stan-list.component.html',
  styleUrls: ['./stan-list.component.css'],
})
export class StanListComponent implements OnInit {
  public stanovi: Stan[] | undefined;

  constructor(private stanService: StanService) {}

  ngOnInit(): void {
    this.stanService.getStanovi().subscribe((resp) => {
      this.stanovi = resp;
    });
  }

  pretragaStana(searchFrom: any) {
    this.stanService
      .pretragaStanova(searchFrom.value.grad)
      .subscribe((resp) => {
        this.stanovi = resp;
      });
  }
}
