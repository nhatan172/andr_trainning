package nhatan172.ex8_1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToActivity1(View clickedButton){
        Intent newActivity = new Intent(this, SumActivity.class);
        startActivity(newActivity);
    }
    public void goToActivity2(View clickedButton){
        Intent newActivity = new Intent(this, SumActivity.class);
        newActivity.putExtras(makeBundler());
        startActivity(newActivity);
    }

    private Bundle makeBundler(){
        Bundle randomNumbers = new Bundle();
        randomNumbers.putDouble("firstNumber",Math.random());
        randomNumbers.putDouble("secondNumber",Math.random());
        return randomNumbers;
    }
}
