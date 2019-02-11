# **20180602**

A dot diagram:

```{dot !}

digraph {
        a -> b[label="0.2",weight="0.2"];
        a -> c[label="0.4",weight="0.4"];
        c -> b[label="0.6",weight="0.6"];
        c -> e[label="0.6",weight="0.6"];
        e -> e[label="0.1",weight="0.1"];
        e -> b[label="0.7",weight="0.7"];
    }
```

**20180821**

I am going to try and make exemd work again.

## Warnings while installing

```bash
 !  I  ~/g/a/playground    exemd_experimenting  npm install exemd -g             Tue 21 Aug 22:35:42 2018
npm WARN deprecated line-numbers@0.2.0: Copy its ~20 LOC directly into your code instead.
npm WARN deprecated graceful-fs@2.0.3: please upgrade to graceful-fs 4 for compatibility with current and future versions of Node.js
npm WARN deprecated minimatch@0.2.14: Please update to minimatch 3.0.2 or higher to avoid a RegExp DoS issue
npm WARN deprecated CSSselect@0.4.1: the module is now available as 'css-select'
npm WARN deprecated CSSwhat@0.4.7: the module is now available as 'css-what'
npm WARN deprecated ejs@1.0.0: Critical security bugs fixed in 2.5.5
npm WARN deprecated coffee-script@1.12.7: CoffeeScript on NPM has moved to "coffeescript" (no hyphen)
npm WARN deprecated to-iso-string@0.0.2: to-iso-string has been deprecated, use @segment/to-iso-string instead.
npm WARN deprecated jade@0.26.3: Jade has been renamed to pug, please install the latest version of pug instead of jade
npm WARN deprecated minimatch@0.3.0: Please update to minimatch 3.0.2 or higher to avoid a RegExp DoS issue
npm WARN deprecated formidable@1.0.17: Old versions of Formidable are not compatible with the current Node.js; Upgrade to 1.2.0 or later
npm WARN deprecated gulp-util@3.0.8: gulp-util is deprecated - replace it, following the guidelines at https://medium.com/gulpjs/gulp-util-ca3b1f9f9ac5
npm WARN deprecated look-up@0.8.3: Deprecated in favor of findup-sync, please use that library instead.
npm WARN deprecated graceful-fs@3.0.11: please upgrade to graceful-fs 4 for compatibility with current and future versions of Node.js
npm WARN deprecated minimatch@2.0.10: Please update to minimatch 3.0.2 or higher to avoid a RegExp DoS issue
npm WARN deprecated graceful-fs@1.2.3: please upgrade to graceful-fs 4 for compatibility with current and future versions of Node.js
/Users/amartins/.nvm/versions/node/v8.11.3/bin/exemd -> /Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/cli.js

> fsevents@1.2.4 install /Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/composer/node_modules/fsevents
> node install

[fsevents] Success: "/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/composer/node_modules/fsevents/lib/binding/Release/node-v57-darwin-x64/fse.node" already installed
Pass --update-binary to reinstall or --build-from-source to recompile

> fsevents@0.3.8 install /Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/fsevents
> node-gyp rebuild

2018-08-21 22:38:17.603 xcodebuild[57901:14668395] [MT] PluginLoading: Required plug-in compatibility UUID B395D63E-9166-4CD6-9287-6889D507AD6A for plug-in at path '~/Library/Application Support/Developer/Shared/Xcode/Plug-ins/WakaTime.xcplugin' not present in DVTPlugInCompatibilityUUIDs
2018-08-21 22:38:17.604 xcodebuild[57901:14668395] [MT] PluginLoading: Required plug-in compatibility UUID B395D63E-9166-4CD6-9287-6889D507AD6A for plug-in at path '~/Library/Application Support/Developer/Shared/Xcode/Plug-ins/Alcatraz.xcplugin' not present in DVTPlugInCompatibilityUUIDs
  SOLINK_MODULE(target) Release/.node
  CXX(target) Release/obj.target/fse/fsevents.o
In file included from ../fsevents.cc:85:
../src/methods.cc:14:12: warning: 'Call' is deprecated [-Wdeprecated-declarations]
  handler->Call(3, argv);
           ^
../../nan/nan.h:1617:3: note: 'Call' has been explicitly marked deprecated here
  NAN_DEPRECATED inline v8::Local<v8::Value>
  ^
../../nan/nan.h:98:40: note: expanded from macro 'NAN_DEPRECATED'
# define NAN_DEPRECATED __attribute__((deprecated))
                                       ^
1 warning generated.
  SOLINK_MODULE(target) Release/fse.node
+ exemd@0.1.10
added 1286 packages in 142.069s
```

## Failed when run

When running `exemd README.md` on this file,
```log
Possibly unhandled TypeError: it.to is not a function
    at convert (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/index.js:183:16)
    at tryCatch1 (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/util.js:45:21)
    at Promise$_callHandler [as _callHandler] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:660:13)
    at Promise$_settlePromiseFromHandler [as _settlePromiseFromHandler] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:675:18)
    at Promise$_settlePromiseAt [as _settlePromiseAt] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:845:14)
    at Promise$_settlePromises [as _settlePromises] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:988:14)
    at Async$_consumeFunctionBuffer [as _consumeFunctionBuffer] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/async.js:77:12)
    at Async$consumeFunctionBuffer (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/async.js:40:14)
    at _combinedTickCallback (internal/process/next_tick.js:131:7)
    at process._tickCallback (internal/process/next_tick.js:180:9)
```

Before anything else, I am going to install the [`exemd-dot`](https://www.npmjs.com/package/exemd-dot)
plugin to run the minimum example at the top of this file.

And, by running 
```bash
exemd README.md > README.html
```
I got it to work.

## Running plantuml (or other stuff with no plugins)

What would be awesome is if `exemd` could actually call the command after the `{` in the shell.

The test case as a sequence diagram 
```{plantuml !}
@startuml
Alice -> Bob: Authentication Request
Bob --> Alice: Authentication Response

Alice -> Bob: Another authentication Request
Alice <-- Bob: another authentication Response
@enduml
```

The previous error appears again.

```fish
 I  ~/g/a/playground   *  exemd_experimenting  exemd README.md > README_with_plantuml.html
Possibly unhandled TypeError: it.to is not a function
    at convert (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/index.js:183:16)
    at tryCatch1 (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/util.js:45:21)
    at Promise$_callHandler [as _callHandler] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:660:13)
    at Promise$_settlePromiseFromHandler [as _settlePromiseFromHandler] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:675:18)
    at Promise$_settlePromiseAt [as _settlePromiseAt] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:845:14)
    at Promise$_settlePromises [as _settlePromises] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/promise.js:988:14)
    at Async$_consumeFunctionBuffer [as _consumeFunctionBuffer] (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/async.js:77:12)
    at Async$consumeFunctionBuffer (/Users/amartins/.nvm/versions/node/v8.11.3/lib/node_modules/exemd/node_modules/bluebird/js/main/async.js:40:14)
    at _combinedTickCallback (internal/process/next_tick.js:131:7)
    at process._tickCallback (internal/process/next_tick.js:180:9)
```

## How does `exemd-dot` work?


