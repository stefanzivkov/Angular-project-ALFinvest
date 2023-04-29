import { Component, Input, OnInit } from '@angular/core';
import { Stan } from 'src/app/model/stan';
import { Zgrada } from 'src/app/model/zgrada';
import { StanService } from 'src/app/services/stan.service';

@Component({
  selector: 'app-stan-item',
  templateUrl: './stan-item.component.html',
  styleUrls: ['./stan-item.component.css'],
})
export class StanItemComponent implements OnInit {
  @Input() stan!: Stan;

  constructor(private stanService: StanService) {}

  ngOnInit(): void {}
}
