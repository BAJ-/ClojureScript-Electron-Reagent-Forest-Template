# Electro-forest
A basic template for making Electron apps using ClojureScript, Reagent, and Forest.

## How to use
First make sure you run
```
npm install
```

Then in one window run:
```
env LEIN_FAST_TRAMPOLINE=y lein trampoline cljsbuild auto dev-electron
```

When the above has compiled, in a separate window, run:
```
env LEIN_FAST_TRAMPOLINE=y lein trampoline figwheel
```

When Figwheel is ready, in a yet a separate window, run:
```
npm start
```

I know it seems like a lot of windows, but I find that Figwheel is most reliable connecting with a REPL using this approach. An alternative way would be to use `lein-cooper` and a `Procfile`.

## How to build
To build for MacOS just run:
```
npm run build
```

Or to build for all platforms:
```
npm run build-all
```
