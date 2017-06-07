package nhatan172.ex11_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    private EditText et_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = (TextView)findViewById(R.id.tv_result);
        et_url = (EditText)findViewById(R.id.et_url);
    }

    public void CalLine (View clickedButton){
        HttpURLConnection urlConnection = null;
        String urlStr = et_url.getText().toString();

        try {
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection)url.openConnection();
            BufferedReader in =
                    new BufferedReader
                            (new InputStreamReader(urlConnection.getInputStream()));
            int sumLine = 0;
            String line = "";
            while ((line = in.readLine()) != null){
                sumLine ++;
            }
            tv_result.setText(sumLine);
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            tv_result.setText("Wrong URL?");
        } catch (IOException e) {
            tv_result.setText("Check connection");
        }
    }
}
