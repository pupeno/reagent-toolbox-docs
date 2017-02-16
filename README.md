# Reagent Toolbox Docs

A mix of documentation and demo of all the [Reagent Toolbox](https://github.com/dashmantech/reagent-toolbox) capabilities. Edit

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Deploying

```bash
lein uberjar
lein heroku deploy
```

by using https://devcenter.heroku.com/articles/deploying-clojure-applications-with-the-heroku-leiningen-plugin

## Sponsors

Sponsored by [Dashman](https://dashman.tech), the ultimate office dashboard manager.

## License

Copyright © 2017 Flexpoint Tech Ltd

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
