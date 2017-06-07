package nhatan172.ex5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv_info;
    private String infoTempl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = (TextView)findViewById(R.id.tv_info);
        infoTempl = "You selected %s.";
        Spinner spinner_1 = (Spinner)findViewById(R.id.spinner_1);
        Spinner spinner_2 = (Spinner)findViewById(R.id.spinner_2);
        String color[] = {"Red","Yello","Blue","Green"};
        List<String> colorSet = Arrays.asList(color);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colorSet);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_2.setAdapter(spinnerAdapter);
        spinner_2.setOnItemSelectedListener(new SpinnerSelected());
        spinner_1.setOnItemSelectedListener(new SpinnerSelected());

    }

    private class SpinnerSelected implements  AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String info = String.format(infoTempl,adapterView.getItemAtPosition(i).toString());
            tv_info.setText(info);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

}
