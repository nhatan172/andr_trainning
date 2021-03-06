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
    private HashMap<Button,Integer> coupleBtnTimes = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button btn_click ;
        Button btn_push ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click = (Button)findViewById(R.id.btn_click);
        btn_push = (Button)findViewById(R.id.btn_push);

        coupleBtnTimes.put(btn_click,0);
        coupleBtnTimes.put(btn_push,0);

        btn_click.setOnClickListener(new Toaster(btn_click));
        btn_push.setOnClickListener(new Toaster(btn_push));
    }

    private class Toaster implements View.OnClickListener {

        Button btn_click;

        public Toaster(Button btn){
            this.btn_click = btn;
        }

        @Override
        public void onClick(View clickedButton) {
            Random generator = new Random();
            int index = generator.nextInt(mColorChoices.length);
            btn_click.setBackgroundColor(mColorChoices[index]);
            int i = coupleBtnTimes.get(btn_click)+1;
            coupleBtnTimes.put(btn_click, i);
            Toast tempMessage =
                    Toast.makeText(MainActivity.this,
                            "I was clicked "+ i + " times",
                            Toast.LENGTH_SHORT);
            tempMessage.show();
        }
    }

}
