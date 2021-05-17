# Shared Module (path alias: @shared)

The shared module contains classes and resources which are used in more than one dynamically loaded module. By always loading with the application the shared components are ready whenever a module requests them.

The shared module is a good place to import and export the `FormsModule`, the `ReactiveFormsModule` and the `MaterialModule`. It is also good for any other resource used by some modules some of the time but not all modules all of the time.


As you know, you can use the component if it is registered in the module. But to use a `shared component`, you will not import it in `AppModule`. First you need to export the `shared component` from the `SharedModule`:

```ts
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { SharedComponent } from "./components/shared/shared.component";

@NgModule({
  declarations: [SharedComponent],
  imports: [CommonModule],
  exports: [SharedComponent]
})
export class SharedModule {}
```

# Subdirectories
There are two subdirectories:
```
~/src/app/shared
/component
/service
```
which should be self-explanatory.