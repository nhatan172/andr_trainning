package nhatan172.ex11_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String hostname = "whois.verisign-grs.com";
        int portNum = 43;
        TextView tv_info1 = (TextView)findViewById(R.id.tv_info1);
        TextView tv_info2 = (TextView)findViewById(R.id.tv_info2);
        TextView tv_info3 = (TextView)findViewById(R.id.tv_info3);
        try {
            Socket client = new Socket(hostname,portNum);
            BufferedReader in =
                    new BufferedReader
                            (new InputStreamReader(client.getInputStream()));
            tv_info1.setText(in.readLine());
            tv_info2.setText(in.readLine());
            tv_info3.setText(in.readLine());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            tv_info1.setText("Have some error");
        }

    }
}
