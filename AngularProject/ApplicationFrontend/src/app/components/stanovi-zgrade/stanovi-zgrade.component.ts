import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Stan } from 'src/app/model/stan';
import { Zgrada } from 'src/app/model/zgrada';
import { ZgradaService } from 'src/app/services/zgrada.service';

@Component({
  selector: 'app-stanovi-zgrade',
  templateUrl: './stanovi-zgrade.component.html',
  styleUrls: ['./stanovi-zgrade.component.css'],
})
export class StanoviZgradeComponent implements OnInit {
  @Input() public stanovi: Stan[] | undefined;
  public zgrada!: Zgrada;
  velicinaNiza: number = 0;

  constructor(
    private route: ActivatedRoute,
    private zgradaService: ZgradaService
  ) {}

  ngOnInit(): void {
    const idZgrade = this.route.snapshot.params['id'];
    this.zgradaService.getZgrada(idZgrade).subscribe((resp: any) => {
      this.zgrada = resp;
    });
    this.zgradaService.stanoviZgrade(idZgrade).subscribe((resp: any) => {
      this.stanovi = resp;
      this.velicinaNiza = this.stanovi!.length;
    });
  }
}
