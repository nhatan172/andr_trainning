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
    private TextView tv_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sum_activity);

        tv_show = (TextView)findViewById(R.id.tv_show);
        tv_status = (TextView)findViewById(R.id.tv_status);
        setInputFromExtras();
        commitSum();
    }

    private void makeRandomNumber(){
        tv_status.setText("No data recived");
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
            tv_status.setText("Recived data from Extras");
            mNumber1 = bundle.getDouble("firstNumber");
            mNumber2 = bundle.getDouble("secondNumber");
        }
        else setInputFromUri();
    }

    private void setInputFromUri(){
        Uri uri = getIntent().getData();

        if(uri != null && (!uri.equals(Uri.parse("sum://example.com"))){
            tv_status.setText("Recived data from Uri");
            String param1 = uri.getQueryParameter("firstnum");
            mNumber1 = Double.parseDouble(param1);
            String param2 = uri.getQueryParameter("secondnum");
            mNumber2 = Double.parseDouble(param2);
        }
        else makeRandomNumber();
    }
}
