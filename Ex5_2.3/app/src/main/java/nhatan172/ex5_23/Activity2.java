package nhatan172.ex5_23;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nhata on 09/03/2017.
 */

public class Activity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    private void goToActivity
            (Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
    public void showActivity(View clickedButton) {
        goToActivity(Activity1.class);
    }
}
