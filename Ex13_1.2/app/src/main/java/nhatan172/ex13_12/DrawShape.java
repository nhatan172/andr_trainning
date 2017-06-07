package nhatan172.ex13_12;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by nhata on 31/03/2017.
 */

public class DrawShape extends View {

    private Bitmap[] mIcon = {
            BitmapFactory.decodeResource(getResources(),R.drawable.images),
            BitmapFactory.decodeResource(getResources(),R.drawable.i2),
            BitmapFactory.decodeResource(getResources(),R.drawable.i3),
            BitmapFactory.decodeResource(getResources(),R.drawable.i1),
            BitmapFactory.decodeResource(getResources(),R.drawable.i4)
    };

    public DrawShape(Context context) {
        super(context);
    }
    public DrawShape(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DrawIcon(canvas);
    }
    private void DrawIcon(Canvas canvas){
        int viewHeight = getHeight();
        int viewWidth = getWidth();
        float left, top;
        Bitmap icon;
        for (int i=0; i<4; i++){
            left = randomFloat(viewWidth);
            top = randomFloat(viewHeight);
            icon = randomBitmap(mIcon);
            canvas.drawBitmap(icon, left, top, null);
        }
    }
    private float randomFloat(int position){
        return (float)(Math.random()*position);
    }

    private Bitmap randomBitmap(Bitmap[] mIcon){
        Random random = new Random();
        int r = random.nextInt(5);
        return mIcon[r];
    }
}
