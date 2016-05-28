package {{sanitized}}

import org.rerenderer.android.RerendererActivity

class MainActivity: RerendererActivity() {
    override val url = "file:///android_asset/index.html"

    override fun registerPrimitives() {
        super.registerPrimitives()
        // Register your primitives here
    }
}
