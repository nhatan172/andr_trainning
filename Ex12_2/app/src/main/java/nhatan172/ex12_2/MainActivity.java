package nhatan172.ex12_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = (TextView)findViewById(R.id.tv_result);
    }


    public void Start(View clickedButton){
        ExecutorService task = Executors.newFixedThreadPool(1);
        task.execute(new FlipCoin());
        maxStreak = 0;
        try {
            task.shutdown();
            task.awaitTermination(200, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tv_result.setText(String.format("Max consecutive heads: %s",Integer.toString(maxStreak)));

    }
    private class FlipCoin implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 1000; i++) {
                result = rd.nextBoolean();
                if (i == 0)
                    current = result;
                else {
                    if (current == result) {
                        currentStreak++;
                    } else {
                        maxStreak = maxStreak > currentStreak ? maxStreak : currentStreak;
                        currentStreak = 0;
                    }
                }

            }
        }
    }

}
