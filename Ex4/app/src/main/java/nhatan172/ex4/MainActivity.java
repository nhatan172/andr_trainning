package nhatan172.ex4;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_hello = (Button)findViewById(R.id.btn_hello);
        Button btn_bye = (Button)findViewById(R.id.btn_bye);
        TextView tv_message = (TextView)findViewById(R.id.tv_message);

        btn_hello.setOnClickListener(new ChangeText(btn_hello,tv_message));
        btn_bye.setOnClickListener(new ChangeText(btn_bye,tv_message));
    }

    private class ChangeText implements View.OnClickListener{

        private Button btn_Clicked;
        private TextView tv_message;

        public ChangeText(Button btn, TextView tv){
            this.btn_Clicked = btn;
            this.tv_message = tv;
        }

        @Override
        public void onClick(View view) {
            tv_message.setText(btn_Clicked.getText());
        }
    }
}
