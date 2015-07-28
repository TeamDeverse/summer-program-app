package org.deverse.summer_program.deversesummerprogram;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HomeView_Activity extends Activity {

    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view_);

        logout = (TextView) findViewById(R.id.log_out);

        String logout_Text = new String("Logout");
        SpannableString content = new SpannableString(logout_Text);
        content.setSpan(new UnderlineSpan(), 0, logout_Text.length(), 0);
        logout.setText(content);
    }
}
