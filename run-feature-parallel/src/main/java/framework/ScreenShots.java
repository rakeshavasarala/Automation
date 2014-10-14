package framework;

import java.util.HashMap;
import java.util.Map;

public class ScreenShots {


    private static final ThreadLocal<Map<String, Object>> SCREEN_SHOTS = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    public static void add(String name, byte[] image) {
        SCREEN_SHOTS.get().put(name, image.clone());
    }

    public static Map<String, Object> getScreenShotsForCurrentTest() {
        return SCREEN_SHOTS.get();
    }

    public static void tidyUpAfterTestRun() {
        SCREEN_SHOTS.remove();
    }


}
