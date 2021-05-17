# Data module
The data module is a top level directory and holds the types (models/entities) and services (repositories) for data consumed by the application.

By default there are two subdirectories:
```
~/src/app/data
/types
/service
```


If your application consumes data from more than one source then the data directory should be restructured to contain subdirectories for each data source:
 
```
~/src/app/data
  /data-source-one
    /types
    /service
  /data-source-two
    /types
    /service
  /data.module.ts
```


**Do not create multiple modules for each data source!**