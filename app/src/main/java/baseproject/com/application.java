package baseproject.com;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.firebase.client.Firebase;

import baseproject.com.activity.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by lin on 7/7/16.
 */

public class application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initializing FireBase
        Firebase.setAndroidContext(this);

        // Initializing Calligraphy
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Chalet-ParisNineteenSixty.otf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        // Initialize facebook
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
