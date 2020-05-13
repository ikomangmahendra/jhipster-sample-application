import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { XtraReferralManagerSharedModule } from 'app/shared/shared.module';
import { XtraReferralManagerCoreModule } from 'app/core/core.module';
import { XtraReferralManagerAppRoutingModule } from './app-routing.module';
import { XtraReferralManagerHomeModule } from './home/home.module';
import { XtraReferralManagerEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    XtraReferralManagerSharedModule,
    XtraReferralManagerCoreModule,
    XtraReferralManagerHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    XtraReferralManagerEntityModule,
    XtraReferralManagerAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class XtraReferralManagerAppModule {}
