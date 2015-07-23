package org.deverse.summer_program.deversesummerprogram;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by kevinmannix on 7/16/15.
 */
public class ParseInit extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "desix70wZe5C7gUcwzxmXDnHmawq0oVfDGp01cx7",
                               "0GLXqrsmtpznsVm0Vxukvcg2kydKjlAHPmtdaY6O");
    }
}