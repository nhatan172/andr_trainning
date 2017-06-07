package nhatan172.ex8_1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Formatter;
import java.util.Random;

/**
 * Created by nhata on 10/03/2017.
 */

public class SumActivity extends Activity {

    private double mNumber1;
    private double mNumber2;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sum_activity);

        tv_show = (TextView)findViewById(R.id.tv_show);
        //setInputFromExtras();
        setInputFromUri();
        commitSum();
    }

    private void makeRandomNumber(){
        Random randomizer = new Random();
        mNumber1 = randomizer.nextDouble();
        mNumber2 = randomizer.nextDouble();
    }

    private void commitSum(){
        String message = "The sum of %f and %f is %f";
        tv_show.setText(String.format(message,mNumber1,mNumber2,mNumber1+mNumber2));
    }

    private void setInputFromExtras(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            mNumber1 = bundle.getDouble("firstNumber");
            mNumber2 = bundle.getDouble("secondNumber");
        }
        else makeRandomNumber();
    }

    private void setInputFromUri(){
        Uri uri = getIntent().getData();

        if(uri != null){
            mNumber1 = 10;
            mNumber2 = 20;
        }
        else {
            mNumber1 = 20;
            mNumber2 = 30;
        }
    }
}
