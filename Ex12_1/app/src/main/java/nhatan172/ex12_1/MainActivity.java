package nhatan172.ex12_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
            taskList.execute(new Flipper());
        }
    }
}

