# Modules directory (path alias: @modules)
The modules directory contains a collection of modules which are each independent of each other. This allows Angular to load only the module it requires to display the request thereby saving bandwidth and speeding the entire application.

In order to accomplish this each module must have its own routing which is a loadChildren route resource defined in the `AppRoutingModule`. 

A route can have children and each child can have a `loadChildren` property. `app-routing.module.ts`:

```ts
{
  path: '',
  component: ContentLayoutComponent,
  children: [
  {
    path: 'dashboard',
    loadChildren: () =>
      import('./modules/home/home.module').then(m => m.HomeModule)
  },
  {
    path: 'about',
    loadChildren: () =>
      import('./modules/about/about.module').then(m => m.AboutModule)
  },
  {
    path: 'contact',
    loadChildren: () =>
      import('./modules/contact/contact.module').then(m => m.ContactModule)
  }
  ]
},
```
Each child must have its own base path from which it can load children from a module in the modules directory. Example:

`example-routing.module`:
```ts
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ExampleComponent } from './example/example.component';

const routes: Routes = [
  {
    path: '',
    component: ExampleComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AboutRoutingModule { }
```

Or if you need multiple routes using the same layout:

`example-routing.module`:
```ts
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExamplePageOneComponent } from './example-page-one/example-page-one.component';
import { ExamplePageTwoComponent } from './example-page-two/example-page-two.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/custom/one',
    pathMatch: 'full',
  },
  {
    path: '',
    children: [
      {
        path: 'one',
        component: ExamplePageOneComponent,
      },
       {
        path: 'two',
        component: ExamplePageTwoComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ExampleModuleRoutingModule {}
```


**It is necessary to add the child routes to the RouterModule through `forChild`.**

