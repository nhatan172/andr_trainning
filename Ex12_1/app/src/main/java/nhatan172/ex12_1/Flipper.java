package nhatan172.ex12_1;

import android.util.Log;

import java.util.Random;

/**
 * Created by nhata on 17/03/2017.
 */

public class Flipper implements Runnable {
    private Random rd = new Random();
    Boolean result;
    Boolean current;
    int count = 0;

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
}