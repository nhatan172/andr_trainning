package nhatan172.ex5_23;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    private void goToActivity
            (Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
    public void showActivity(View clickedButton) {
        goToActivity(Activity2.class);
    }
}
