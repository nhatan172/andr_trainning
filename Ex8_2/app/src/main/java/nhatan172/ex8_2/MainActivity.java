package nhatan172.ex8_2;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowIntent(){
        Uri uri = Uri.parse("sum://example.com");
        Intent intent = new Intent(Intent.ACTION_SEND, uri);
        startActivity(intent);
    }
}
