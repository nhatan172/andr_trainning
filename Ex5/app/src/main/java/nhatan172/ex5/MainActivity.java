package nhatan172.ex5;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.HashMap;
import java.util.zip.CheckedInputStream;

public class MainActivity extends AppCompatActivity {
    private TextView tv_message ;
    private ToggleButton tb_red;
    private ToggleButton tb_blue ;
    private ToggleButton tb_yellow ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_message = (TextView)findViewById(R.id.tv_message);

        ImageButton ibtn_blue = (ImageButton)findViewById(R.id.ibtn_blue);
        ImageButton ibtn_red = (ImageButton)findViewById(R.id.ibtn_red);
        ibtn_blue.setOnClickListener(new IBAction(tv_message,Color.BLUE));
        ibtn_red.setOnClickListener(new IBAction(tv_message,Color.RED));

        RadioGroup rg_color = (RadioGroup)findViewById(R.id.rg_color);
        rg_color.setOnCheckedChangeListener(new RGAction(tv_message));

        Button btn_setColor = (Button)findViewById(R.id.btn_setColor);
        btn_setColor.setOnClickListener(new setColorBtn());

    }


    public void ChangeCheckedTB (View clickedTB){
        ToggleButton tb_clicked = (ToggleButton)clickedTB;

        if(tb_clicked.isChecked())
            setColorOn(tb_clicked);
        else setColorOff();
    }

    private void setColorOff(){
        if(tb_red.isChecked())
            tv_message.setBackgroundColor(Color.RED);
        else if(tb_yellow.isChecked())
            tv_message.setBackgroundColor(Color.YELLOW);
        else if(tb_blue.isChecked())
            tv_message.setBackgroundColor(Color.BLUE);
        else tv_message.setBackgroundColor(Color.BLACK);

    }

    private void setColorOn(ToggleButton tb){
        if(tb == tb_red)
            tv_message.setBackgroundColor(Color.RED);
        else if(tb == tb_blue)
            tv_message.setBackgroundColor(Color.BLUE);
        else tv_message.setBackgroundColor(Color.YELLOW);
    }

    private class setColorBtn implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            RadioGroup rg = (RadioGroup)findViewById(R.id.rg_color2);
            int id = rg.getCheckedRadioButtonId();
            if(id == 1)
                tv_message.setBackgroundColor(Color.RED);
            else if (id == 2)
                tv_message.setBackgroundColor(Color.BLUE);
        }
    }

}
