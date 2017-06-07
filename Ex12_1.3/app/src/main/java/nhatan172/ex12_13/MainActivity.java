package nhatan172.ex12_13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartThreads();
    }


    private void StartThreads(){
        ExecutorService taskList =
                Executors.newFixedThreadPool(5);
        for(int i=0; i<5; i++) {
            taskList.execute(new Runnable() {
                Random rd = new Random();
                Boolean result;
                Boolean current;
                int count = 0;

                @Override
                public void run() {
                    result = rd.nextBoolean();
                    if(count ==0)
                        current = result;
                    else {
                        if(current == result)
                            System.out.println(Thread.currentThread().getName());
                    }
                    current = result;
                    if(count == 1000)
                        return;
                    count ++;
                }
            });
        }
    }
}
