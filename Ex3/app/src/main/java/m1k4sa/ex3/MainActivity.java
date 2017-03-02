package m1k4sa.ex3;

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

    private int[] mColorChoices = {Color.RED,Color.BLUE,Color.YELLOW};
    private Button btn_click ;
    private Button btn_push ;
    private TextView tv_test ;
    private HashMap<Button,Integer> coupleBtnTimes = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click = (Button)findViewById(R.id.btn_click);
        btn_push = (Button)findViewById(R.id.btn_push);
        tv_test = (TextView)findViewById(R.id.tv_test);

        coupleBtnTimes.put(btn_click,0);
        coupleBtnTimes.put(btn_push,0);

        btn_click.setOnClickListener(new Toaster(btn_click,this));
        btn_push.setOnClickListener(new Toaster(btn_push,this));
    }

    private class Toaster implements View.OnClickListener {

        Button btn_click;
        HashMap<Button,Integer> coupleBtnTimes;

        public Toaster(Button btn,MainActivity mainActivity){
            this.btn_click = btn;
            this.coupleBtnTimes = mainActivity.coupleBtnTimes;
        }

        @Override
        public void onClick(View clickedButton) {
            Random generator = new Random();
            int index = generator.nextInt(mColorChoices.length);
            btn_click.setBackgroundColor(mColorChoices[index]);
            int i = coupleBtnTimes.get(btn_click)+1;
            btn_click.setText("I was clicked "+ i + " times");
            coupleBtnTimes.put(btn_click, coupleBtnTimes.get(btn_click)+1);
        }
    }

}
