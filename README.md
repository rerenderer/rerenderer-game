# rerenderer-game

Template for [rerenderer](https://github.com/rerenderer/rerenderer) based games.

## Usage

For starting new project:

```bash
lein new rerenderer-game com.my.super-game
```

For running project:

```bash
lein figwheel
```

For using figwheel on android please change `url` in your `MainActivity`, like:

```kotlin
class MainActivity: RerendererActivity() {
    override val url = "http://192.168.2.100:3449"

    override fun registerPrimitives() {
        super.registerPrimitives()
        // Register your primitives here
    }
}
```

For building android version for figwheel use:

```bash
cd android
chmod +x gradlew
./gradlew installDebug
```

If you want to build standalone version for android, change `getUrl` to 
`"file:///android_asset/index.html"` and:

```bash
lein cljsbuild once
cd android 
./gradlew copyAssets installDebug
```

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
