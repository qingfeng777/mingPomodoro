package com.mingbbai.javautil;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgressBar extends View {
	private int maxProgress = 10;//������
	private int progress = 0;//��ǰ����
	private int progressStrokeWidth = 6;//�߿�
	// ��Բ���ڵľ�������
	RectF oval;
	Paint paint;

	public CircleProgressBar(Context context) {
		super(context);
		// TODO �Զ����ɵĹ��캯�����
	}

	public CircleProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO �Զ����ɵĹ��캯�����
		oval = new RectF();
		paint = new Paint();
	}

	public CircleProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		/**
		 * �������Ĵ�Բ��
		 */
		int centre = getWidth()/2; //��ȡԲ�ĵ�x����
		int radius = (int) (centre - progressStrokeWidth/2); //Բ���İ뾶
		paint.setColor(Color.WHITE);//(roundColor); //����Բ������ɫ
		paint.setStyle(Paint.Style.STROKE); //���ÿ���
		paint.setStrokeWidth(progressStrokeWidth); //����Բ���Ŀ��
		paint.setAntiAlias(true);  //������� 
		canvas.drawCircle(centre, centre, radius, paint); //����Բ��
		
		/**
		 * ��Բ�� ����Բ���Ľ���
		 */
		
		//���ý�����ʵ�Ļ��ǿ���
		paint.setStrokeWidth(progressStrokeWidth); //����Բ���Ŀ��
		paint.setColor(Color.rgb(0x57, 0x87, 0xb6));  //���ý��ȵ���ɫ 
		RectF oval = new RectF(centre - radius, centre - radius, centre
				+ radius, centre + radius);  //���ڶ����Բ������״�ʹ�С�Ľ���

			paint.setStyle(Paint.Style.STROKE);
			canvas.drawArc(oval, -90, 360 * progress / maxProgress, false, paint);  //���ݽ��Ȼ�Բ��  ���ư�ɫԲȦ��������������
	}
	
	public int getMaxProgress(){
		return maxProgress;
	}
	
	public void setMaxProgress(int maxProgress){
		this.maxProgress = maxProgress;
	}
	
	public void setProgress(int progress){
		this.progress = progress;
		this.invalidate();
	}
	
	public void setProgressNotInUiThread(int progress){
		this.progress = progress;
		this.postInvalidate();
	}

}




























