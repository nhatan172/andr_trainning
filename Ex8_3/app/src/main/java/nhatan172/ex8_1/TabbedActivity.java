package nhatan172.ex8_1;

import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by nhata on 16/03/2017.
 */

public class TabbedActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost tabHost = getTabHost();
        Intent intent1 = new Intent(this, SumActivity.class);

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab 1").setIndicator("First Tab").setContent(intent1);
        tabHost.addTab(tabSpec1);

        Intent intent2 = new Intent(this, SumActivity.class);
        Bundle numBundle = makeBundler();
        intent2.putExtras(numBundle);
        TabHost.TabSpec tabSpec2 =  tabHost.newTabSpec("Tab 2").setIndicator("Second Tab").setContent(intent2);
        tabHost.addTab(tabSpec2);

        Uri uri = Uri.parse("sum://example.com");
        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri);
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab 3").setIndicator("Third Tab").setContent(intent3);
        tabHost.addTab(tabSpec3);

        Uri uri2 = Uri.parse(makeInputUri());
        Intent intent4 = new Intent(Intent.ACTION_VIEW, uri2);
        TabHost.TabSpec tabSpec4 = tabHost.newTabSpec("Tab 4").setIndicator("Fourth Tab").setContent(intent4);
        tabHost.addTab(tabSpec4);
    }

    private Bundle makeBundler(){
        Bundle randomNumbers = new Bundle();
        randomNumbers.putDouble("firstNumber",Math.random());
        randomNumbers.putDouble("secondNumber",Math.random());
        return randomNumbers;
    }

    private String makeInputUri(){
        String baseAdd = "sum://example.com/sum";
        String number1param = String.format("firstnum=%s",Math.random());
        String number2param = String.format("secondnum=%s",Math.random());
        String inputUri = String.format("%s?%s&%s",baseAdd,number1param,number2param);
        return inputUri;
    }
}
