package com.example.yuzhuo;

import java.util.Random;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	public String[] colorBg = new String[] { "#f895a4", "#7dccb9",
		"#91c8f6", "#f2ac8c", "#f1c973", "#80c22e", "#ada1e4", "#6d99ea",
				"#f47cad", "#ffdee2", "#ffdcc0", "#d9c8ff", "#c0e79c", "#e9c8a5",
				"#f58e3e", "#faf3d0", "#fccbbe", "#f2a0d1", "#dd6fab", "#27a977",
				"#c9ebdc", "#ffa100", "#f5e4f5", "#4dca9a", "#f3ece2", "#edd7bc",
				"#fbdde7", "#feeaa3", "#e3e2e0", "#86d1cc","#20cbd4"};
	
	private int mCornerSize = 6;//Ô²½Ç
	
	private TextView textView1, textView2, textView3, textView4, TextView5,
			textView6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	public void initView() {
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView4 = (TextView) findViewById(R.id.textView4);
		TextView5 = (TextView) findViewById(R.id.TextView5);
		textView6 = (TextView) findViewById(R.id.TextView6);
		setBackgroundRounded(100,75, textView1, Color.parseColor(colorBg[new Random().nextInt(30)]));
		setBackgroundRounded(100,75, textView2, Color.parseColor(colorBg[new Random().nextInt(30)]));
		setBackgroundRounded(100,75, textView3, Color.parseColor(colorBg[new Random().nextInt(30)]));
		setBackgroundRounded(100,75, textView4, Color.parseColor(colorBg[new Random().nextInt(30)]));
		setBackgroundRounded(100,75, TextView5, Color.parseColor(colorBg[new Random().nextInt(30)]));
		setBackgroundRounded(100,75, textView6, Color.parseColor(colorBg[new Random().nextInt(30)]));
		textView1.setOnClickListener(this);
		textView2.setOnClickListener(this);
		textView3.setOnClickListener(this);
		textView4.setOnClickListener(this);
		TextView5.setOnClickListener(this);
		textView6.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.textView1:
			setBackgroundRounded(100,75, textView1, Color.parseColor(colorBg[new Random().nextInt(30)]));
			break;
		case R.id.textView2:
			setBackgroundRounded(100,75, textView2, Color.parseColor(colorBg[new Random().nextInt(30)]));
			break;
		case R.id.textView3:
			setBackgroundRounded(100,75, textView3, Color.parseColor(colorBg[new Random().nextInt(30)]));
			break;
		case R.id.textView4:
			setBackgroundRounded(100,75, textView4, Color.parseColor(colorBg[new Random().nextInt(30)]));
			break;
		case R.id.TextView5:
			setBackgroundRounded(100,75, TextView5, Color.parseColor(colorBg[new Random().nextInt(30)]));
			break;
		case R.id.TextView6:
			setBackgroundRounded(100,75, textView6, Color.parseColor(colorBg[new Random().nextInt(30)]));
			break;

		}

	}
	
	/**
	 * TextView »­Ô²½Ç±³¾°
	 * Description: ×Ô¼ºÌîÐ´
	 * @param w
	 * @param h
	 * @param v
	 * @param mBgColor
	 */
	public void setBackgroundRounded(int w, int h, View v,int mBgColor)
    {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        double dH = (metrics.heightPixels / 100) * 1.5;
        int iHeight = (int)dH;
        
        iHeight = mCornerSize;
        
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);
        
        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(mBgColor);
        RectF rec = new RectF(0, 0, w, h);
        c.drawRoundRect(rec, iHeight, iHeight, paint);
        v.setBackgroundDrawable(new BitmapDrawable(getResources(), bmp));
    }
}
