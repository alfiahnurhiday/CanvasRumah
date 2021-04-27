package android.alfiah.canvasrumah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint=new Paint ();
    private Paint mPaintText=new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.myimageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.black, null));
        mPaintText.setTextSize(60);
    }

    public void drawSomething(View view) {

        int vWidth=view.getWidth();
        int vHeight=view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas=new Canvas(mBitmap);
        mCanvas.drawColor(Color.GRAY);
        mCanvas.drawText("Alfiah Nur Hidayati",250,700,mPaintText);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mCanvas.drawLine(200, 300, 300, 100, mPaint); //pinggir kiri
        mCanvas.drawLine(300, 100, 700, 100, mPaint); //atas
        mCanvas.drawLine(200, 300, 800, 300, mPaint); //bawah
        mCanvas.drawLine(700, 100, 800, 300, mPaint); //pinggir kanan

        mPaint.setColor(Color.RED);
        Rect mRect=new Rect();
        mRect.set(200,300,800,550);
        mCanvas.drawRect(mRect,mPaint);

        mPaint.setColor(Color.YELLOW);
        mRect.set(275,350,375,550);
        mCanvas.drawRect(mRect,mPaint);

        mPaint.setColor(Color.YELLOW);
        mRect.set(385,350,485,550);
        mCanvas.drawRect(mRect,mPaint);

        mPaint.setColor(Color.BLUE);
        mRect.set(600,375,700,475);
        mCanvas.drawRect(mRect,mPaint);

        view.invalidate();
    }
}