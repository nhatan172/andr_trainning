package nhatan172.ex36;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int[] mColorChoices = {Color.RED,Color.BLUE,Color.YELLOW};
    private int countClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btn_click ;
        Button btn_push ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click = (Button)findViewById(R.id.btn_click);
        btn_push = (Button)findViewById(R.id.btn_push);
        tv = (TextView)findViewById(R.id.tv_test);

        btn_click.setOnClickListener(new Toaster());
        btn_push.setOnClickListener(new Toaster());
    }

    private class Toaster implements View.OnClickListener {

        @Override
        public void onClick(View clickedButton) {
            Random generator = new Random();
            int index = generator.nextInt(mColorChoices.length);
            tv.setBackgroundColor(mColorChoices[index]);
            countClick += 1;
            Toast tempMessage =
                    Toast.makeText(MainActivity.this,
                            "I was clicked "+ countClick + " times",
                            Toast.LENGTH_SHORT);
            tempMessage.show();
        }
    }

}
