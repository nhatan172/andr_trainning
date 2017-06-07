package nhatan172.ex13_11;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by nhata on 31/03/2017.
 */

public class DrawShape extends View {

    public DrawShape(Context context) {
        super(context);
    }
    public DrawShape(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        canvas.drawLine(0,0,viewWidth,viewHeight,paint);
        canvas.drawLine(viewWidth,0,0,viewHeight,paint);
        canvas.drawLine(viewWidth/2,0,viewWidth/2,viewHeight,paint);
        canvas.drawLine(0,viewHeight/2,viewWidth,viewHeight/2,paint);

    }

}
