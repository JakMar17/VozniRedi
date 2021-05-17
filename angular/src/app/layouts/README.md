
# Layouts directory
The layout directory contains one or more components which act as a layout or are parts of a layout such as a Header, Nav, Footer, etc. and have a:

```html
<router-outlet></router-outlet>
```
in the html for other components to embed within. By convention the `app.component.html` in the app module acts as the top level layout for the entire application. From this top level you may embed other layouts which in turn embed other components.


Components like Nav and Footer are handled the Angular way by importing them into a component template:
```html
<app-nav></app-nav>
```


# Routing

Each module can have its own routing and is often defined in a file separate from the `custom.module.ts` file. 

Within routing layouts are handled in a rather clever way. By using child routes a top level route can define a layout to be used for all child routes. Defined in the app module’s `app-routing.module.ts` file child routes are grouped in a single Route (as defined in `@angular/router`).

It is important to note that when layouts are imported from other modules (for this example the `CustomModule`) that does not cause the top-level app module to load the `CustomModule` from the server into the user’s browser at the time only app level routes are displayed. This is important for performance! The `CustomModule` compiled `.js` file will only load when a route internal to the module is requested. That is, from the below configuration, only when a route beginning with `/custom` is requested.

`app-routing.module.ts`:
```ts
import { CustomLayoutComponent } from './modules/custom/layout/custom-layout.component';

{
  path: 'custom',
  component: CustomLayoutComponent,
  loadChildren: () =>
    import('./modules/custom/custom.module').then(m => m.CustomModule)
}
```

When a route is called at `/custom` the `CustomLayoutComponent` is used as a layout and handling of the routing is handed off to the `CustomModule`. The CustomLayoutComponent has a `<router-outlet></router-outlet>`:

This <router-outlet></router-outlet> is used to display a route and component defined in the routing of the CustomRoutingModule:

So the routes are `/custom`, `/custom/one` and `/custom/two` and they use the `CustomLayoutComponent` for their layout.

**For further explanation on routing, read the README.md in the modules directory.**
