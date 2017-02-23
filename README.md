# Reagent Toolbox Docs

A mix of documentation and demo of all the [Reagent Toolbox](https://github.com/dashmantech/reagent-toolbox) 
capabilities. You can visit a live instance of this project at http://reagent-toolbox-docs.dashman.tech/ The goal of 
this project is to be a ClojureScript/Reagent version of the [components page](http://react-toolbox.com/#/components)
for [React Toolbox](http://react-toolbox.com).

This project is far from done and what we are doing is go page by page, building the showcase of each component and in
the process making sure the component works well. Sometimes it's necessary to improve the basic component a little bit
to make it more compatible with Reagent. All of this is being tracked in the [issue tracker](https://github.com/dashmantech/reagent-toolbox-docs/issues).

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
