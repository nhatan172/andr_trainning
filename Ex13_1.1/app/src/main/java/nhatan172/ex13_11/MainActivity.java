package nhatan172.ex13_11;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawShape view = (DrawShape)findViewById(R.id.drawing_area);
        view.setBackgroundColor(Color.RED);
    }
}

