package nhatan172.ex10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_message;
    private LinearLayout mLayout;
    private ArrayList<String> ListInput = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (LinearLayout)findViewById(R.id.activity_main);
        et_message = (EditText)findViewById(R.id.et_message);
    }

    public void AddMessage(View clickedButton){
        AddView(et_message.getText().toString());
        ListInput.add(et_message.getText().toString());
    }

    private void AddView(String message){
        TextView textV = new TextView(this);
        textV.setText(message);
        mLayout.addView(textV);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("ListString",ListInput);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> list = (ArrayList<String>)savedInstanceState.getSerializable("ListString");
        if(list != null) {
            ListInput = list;

        }
    }
}

