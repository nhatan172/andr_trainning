package nhatan172.ex5;

import android.graphics.Color;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by nhata on 08/03/2017.
 */

public class RGAction implements RadioGroup.OnCheckedChangeListener {
    private TextView tv_message;

    public RGAction(TextView tv){
        this.tv_message = tv;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(i == 1 )
            tv_message.setBackgroundColor(Color.RED);
        else tv_message.setBackgroundColor(Color.BLUE);
    }
}
