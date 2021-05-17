# Styles directory

```
~/src/styles
```

The `~/src/styles` directory is used to store `scss style sheets` for the application. It can contain themes, Bootstrap, Angular Material, and any other styles.

`~/src/styles.scss` is installed in the default Angular skeleton. It should contain `@import statments` for all your global application `scss` files. For instance it can import theme files stored in the `~/src/styles` directory.

# Themes

The `~/src/styles/themes` directory should contain the application-wide themes. For this example, we'll have two theme-files, `dark-theme.scss` and `light-theme.scss`.

A theme file generates the color-palette that composes the final theme and is constructed of three main palettes: `primary`, `accent` and `warn`. These palettes are defined using the `mat-palette mixin`, which accepts a `mat-color` and a `hue-number` that represents different shades of the chosen color. In terms of code, this is what you'll write:

```scss
$my-dark-primary: mat-palette($mat-grey, 700, 300, 900);
$my-dark-accent: mat-palette($mat-blue-grey, 400);
$my-dark-warn: mat-palette($mat-red, 500);

$my-dark-theme: mat-dark-theme(
  $my-dark-primary,
  $my-dark-accent,
  $my-dark-warn
);
```

The themes should be included in the `styles.scss` file along with the `mat-core mixin`, which adds the base styles to material components.

```ts
@import '~@angular/material/theming';

@import './styles/themes/dark-theme.scss';
@import './styles/themes/light-theme.scss';

@include mat-core();

.my-light-theme {
  @include angular-material-theme($my-light-theme);
}

.my-dark-theme {
  @include angular-material-theme($my-dark-theme);
}
```

The downside here is that the approach above only will style material components and not custom ones.

To achieve this, you’ll need to add a file called `project-container.component.scss-theme.scss`. This file imports the material theme and defines a mixin that styles the content with the appropriate color values - pulling color-palettes from the theme. For our example, it's going to look like this:

```scss
@import '~@angular/material/theming';

@mixin my-project-container-component-theme($theme) {
  $accent: map-get($theme, accent);

  .active {
    color: mat-color($accent, default-contrast);
    background-color: mat-color($accent);

    &:hover {
      color: mat-color($accent, default-contrast);
      background-color: mat-color($accent);
    }
  }
}
```

Then those files are referred to in the `styles.scss` file:

```scss
@import './styles/project-container.component.scss-theme.scss';

@mixin custom-components-theme($theme) {
  @include my-project-container-component-theme($theme);
}

.my-light-theme {
  //...
  @include custom-components-theme($my-light-theme);
}

.my-dark-theme {
  //...
  @include custom-components-theme($my-black-theme);
}
```

The application content needs to have the mat-app-background class applied to work. This is done by appending this class to the div that wraps the app-content in the `src/app/layout/{name}-layout/{name}-layout.component.html` file:

```html
<div class="my-dark-theme">
  <div class="mat-app-background">

      <div class="container">
        <router-outlet></router-outlet>
      </div>
  </div>
</div>
```

The height of the viewport the theme should affects is also defined:

```scss
.mat-app-background {
  height: 100%;
}
```

