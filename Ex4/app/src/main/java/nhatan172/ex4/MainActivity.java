package nhatan172.ex4;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Named inner class
        Button btn_hello1 = (Button)findViewById(R.id.btn_hello1);
        Button btn_bye1 = (Button)findViewById(R.id.btn_bye1);

        btn_hello1.setOnClickListener(new ChangeText(btn_hello1));
        btn_bye1.setOnClickListener(new ChangeText(btn_bye1));

        //Separate class
        Button btn_hello2 = (Button)findViewById(R.id.btn_hello2);
        Button btn_bye2 = (Button)findViewById(R.id.btn_bye2);

        btn_hello2.setOnClickListener(new Toaster(btn_hello2,this));
        btn_bye2.setOnClickListener(new Toaster(btn_bye2,this));
    }


    //Class for Named inner class
    private class ChangeText implements View.OnClickListener{
        private Button btn_Clicked;

        public ChangeText(Button btn){
            this.btn_Clicked = btn;
        }

        @Override
        public void onClick(View view) {
            CharSequence message = btn_Clicked.getText();
            Toast tempMessage = Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT);
            tempMessage.show();
        }
    }

    //Specifying the Event Handler Method
    public void showBye(View v){
        Toast tempMessage = Toast.makeText(MainActivity.this,"Bye",Toast.LENGTH_SHORT);
        tempMessage.show();
    }
    public void showHi(View v){
        Toast tempMessage = Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT);
        tempMessage.show();
    }
}
