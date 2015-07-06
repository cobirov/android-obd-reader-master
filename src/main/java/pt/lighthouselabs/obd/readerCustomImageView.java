package pt.lighthouselabs.obd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import pt.lighthouselabs.obd.reader.activity.MainActivity;
//import pt.lighthouselabs.activity.MainActivity;
//private MainActivity gameBoard;

//static int posit = 44;


public class readerCustomImageView extends ImageView {
    private MainActivity gameBoard;
    private boolean drawCustomCanvas = false;
    private Paint mPaint;
    private float posit2;

    //private int m =1;
    //private int m2 ;
    //MainActivity.posit=100;
    public readerCustomImageView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public readerCustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public readerCustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    public void setDrawCustomCanvas(boolean drawCustomCanvas)
    {
        this.drawCustomCanvas = drawCustomCanvas;
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(40);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        //float posit = 4;
        if(!drawCustomCanvas)
        {super.onDraw(canvas);}
        else{
            //posit2= 30;
            //posit2 = MainActivity.posit2;
            //MainActivity.posit=100;
            mPaint.setStrokeWidth(10);
            canvas.drawPoint(20, 20, mPaint);
            canvas.drawRect(2, 2, 2, 2, mPaint);
            canvas.drawText("Oh, no! You killed android!", 40, 40, mPaint);
            canvas.drawText("You Monster!", 40, 80, mPaint);
            mPaint.setColor(Color.GREEN);
            canvas.drawText("You Monster!", 40, 160, mPaint);
            mPaint.setColor(Color.GREEN);
            canvas.drawLine(1,10,MainActivity.posit,10, mPaint);
            int m=1;
            int m3;
            m3=MainActivity.posit4 /104;

                for (int i = 1; i<m3; i++) {
                 // делим на 104 получаем  (48)48 меняем на переменную
                if ( i > 15) {
                    mPaint.setColor(Color.YELLOW);
                }
                if    (i>30) {
                    mPaint.setColor(Color.RED);
                }


                   //int m=1;
                int m2 = m+10;
                  m=m2;
                    //for (cnt = 1; cnt < max; cnt++) {
                canvas.drawRect(m2, 10, m2+8 , 50, mPaint);
                 //int m2 =m+10;
                       // обновляем ProgressBar
                    //posit2++;
                    //posit=1+posit;

                    // }
                }

            //canvas.drawRect(1, 11, 11, 50, mPaint);

            canvas.restore();

            //canvas.drawRect(20, 20, 10, 10, mPaint);
        }
    }
}