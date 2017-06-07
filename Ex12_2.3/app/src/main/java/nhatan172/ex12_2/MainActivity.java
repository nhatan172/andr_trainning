package nhatan172.ex12_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.Format;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_main = (LinearLayout)findViewById(R.id.group_tv);
    }


    public void Start(View clickedButton){
        ExecutorService task = Executors.newFixedThreadPool(1);
        for(int i = 0; i<5; i++){
            FlipCoin fc = new FlipCoin();
            fc.execute(i);
        }

    }
    private class FlipCoin extends AsyncTask<Integer, Void, Void> {
        private boolean result;
        private boolean current;
        private Random rd = new Random();
        private int maxStreak = 0 ;
        private int currentStreak = 0;
        private int id;

        @Override
        protected Void doInBackground(Integer... indent) {
            this.id = indent[0];
            for (int i = 0; i < 10000; i++) {
                result = rd.nextBoolean();
                if (i == 0)
                    current = result;
                else if (current == result) {
                    currentStreak++;

                } else {
                    current = result;
                    if (currentStreak > maxStreak)
                        maxStreak = currentStreak;
                    currentStreak = 0;
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            TextView tv_result = new TextView(MainActivity.this);
            tv_result.setText(String.format("FlipCoin %d, Max consecutive heads: %d",this.id +1 , this.maxStreak));
            ll_main.addView(tv_result);
        }
    }

}
