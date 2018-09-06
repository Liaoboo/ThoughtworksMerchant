package thoughtworks.merchant.program.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by liaobo on 2018/6/12 0012.
 */

public class MyApp extends Application {
    public static Context AppContent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContent = this;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
