package nhatan172.ex4;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by nhata on 03/03/2017.
 */

// Class for separate class
public class Toaster implements View.OnClickListener {
    private Button btn_Clicked;
    private MainActivity mainAct;

    public Toaster(Button btn, MainActivity mainActivity){
        this.btn_Clicked = btn;
        this.mainAct = mainActivity;
    }

    @Override
    public void onClick(View view) {
        CharSequence message = btn_Clicked.getText();
        Toast tempMessage = Toast.makeText(mainAct,message,Toast.LENGTH_SHORT);
        tempMessage.show();
    }
}

