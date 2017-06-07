package nhatan172.ex12_2;

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

    private TextView tv_result;
    private boolean result;
    private boolean current;
    private Random rd = new Random();
    private int maxStreak ;
    private int currentStreak = 0;
    private LinearLayout ll_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = (TextView)findViewById(R.id.tv_result);
        ll_main = (LinearLayout)findViewById(R.id.activity_main);
    }


    public void Start(View clickedButton){
        ExecutorService task = Executors.newFixedThreadPool(1);
        maxStreak = 0;
        task.execute(new FlipCoin());
        try {
            task.shutdown();
            task.awaitTermination(200, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private class FlipCoin implements Runnable {

        @Override
        public void run() {
            synchronized(this){
                for (int i = 0; i < 10000; i++) {
                    result = rd.nextBoolean();
                    if (i == 0)
                        current = result;
                    else if (current == result) {
                        currentStreak++;

                    } else {
                        current = result;
                        if (currentStreak > maxStreak) {
                            maxStreak = currentStreak;
                            ll_main.post(new DisplayResult());
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        currentStreak = 0;
                    }

                }

            }
        }
    }

    private class DisplayResult implements Runnable {
        @Override
        public void run() {
            tv_result.setText(String.format("Max consecutive heads: %d",maxStreak));
        }
    }

}
