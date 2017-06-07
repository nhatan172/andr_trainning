package nhatan172.ex5;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nhata on 07/03/2017.
 */

public class IBAction implements View.OnClickListener {

    private  TextView tv_message;
    private int clr;

    public IBAction(TextView tv, int color){
        this.tv_message = tv;
        this.clr = color;
    }

    @Override
    public void onClick(View view) {
        tv_message.setBackgroundColor(clr);
    }
}
