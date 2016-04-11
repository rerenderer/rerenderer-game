package {{sanitized}};

import org.rerenderer.android.RerendererActivity;

public class MainActivity extends RerendererActivity {
    @Override
    public String getUrl() {
        return "file:///android_asset/index.html";
    }
}
