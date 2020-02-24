package com.example.uvcebookmark.Snakey;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

import com.example.uvcebookmark.Snakey.game.Snake;


@SuppressLint("DrawAllocation")
public class BoardView extends View {
	private static final int heightNum = 100;
	private static final int widthNum = 50;

	public Snake snake;

	private Paint paint;
	private Handler customHandler;

	private long premium = 0L;

	private int width;
	private int height;
	
	Direction direction;
//	private Node[][] board;
	Collection<Node> board = new LinkedHashSet<Node>();
	boolean boardCreated = false;

	public String location="";

	public void setLocation(String location) {
		this.location = location;
	}

	public BoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		customHandler = new Handler();
		paint = new Paint();
		direction = Direction.RIGHT;
//		board = new Node[widthNum][heightNum];
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		initGame(canvas);
		printSnake(canvas);
		printPremium(canvas);
		printshelves(canvas);
		postDeleyed();
	}

	void printshelves(Canvas canvas){
		int endWidth=canvas.getWidth();
		int endHeight=canvas.getHeight();

		paint.setColor(Color.GRAY);
		paint.setShadowLayer(width,width,0,Color.BLACK);
		canvas.drawRect(new Rect(0,0,width,canvas.getHeight()),paint);
		paint.setShadowLayer(width,-width,0,Color.BLACK);
		canvas.drawRect(new Rect(canvas.getWidth()-width,0,canvas.getWidth(),canvas.getHeight()),paint);
		paint.setShadowLayer(width,0,width,Color.BLACK);
		canvas.drawRect(new Rect(0,0,canvas.getWidth(),height),paint);
		paint.setShadowLayer(width,0,-width,Color.BLACK);
		canvas.drawRect(new Rect(0,canvas.getHeight()-height,canvas.getWidth(),canvas.getHeight()),paint);
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(2.0f);
		paint.setShadowLayer(width/2,-width,0,Color.GRAY);
		for(int i=5*width;i<canvas.getWidth()-canvas.getWidth()/10;i=i+endWidth/10){
			for(int j=3*height;j<canvas.getHeight()/3;j=j+endWidth/8){
				canvas.drawRect(i,j,i+width,j+endWidth/8,paint);
			}
		}
		if (location.equals("lol"))
			canvas.drawRect(0,0,width,height,paint);
		paint.reset();


	}

	private void postDeleyed() {
		customHandler.postDelayed(updateTimerThread, 100);
	}

	private void initGame(Canvas canvas) {
		if (!boardCreated) {
			initBoard(canvas);
			initSnake(widthNum, heightNum);
			boardCreated = true;
		}
	}

	private void printPremium(Canvas canvas) {
		paint.setAntiAlias(true);
		paint.setTextSize(20);
		paint.setColor(Color.RED);
		canvas.drawText(Long.toString(premium++), 15, 15, paint);
	}

	private void printSnake(Canvas canvas) {
		Log.e("Snake", "IN�CIO - size");
		Log.e("Snake", Integer.toString(snake.getBody().size()));
		
//		for (Node node : snake.getBody()) {
//			Log.w("Snake", node.toString());
//		}
		
		try {
			paint.setColor(Color.GREEN);
			paint.setStrokeWidth(10);
			for (Node node : snake.getBody()) {
				
//				Node nodeBoard = board[node.getRow()][node.getColumn()];
//				if (nodeBoard != null) {
//					Rect rect = nodeBoard.getRect();
//					canvas.drawRect(rect, paint);
//				}
				
				if (board.contains(node)) {
					Iterator<Node> iterator = board.iterator();
					while (iterator.hasNext()) {
						Node next = iterator.next();
						if (node.equals(next)) {
							canvas.drawRect(next.getRect(), paint);
						}
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("erro:", e.getMessage());
		}
	}

	private void initBoard(Canvas canvas) {
		
		int endWidth = (canvas.getWidth());
		int endHeight = (canvas.getHeight());

		width = (canvas.getWidth() / widthNum);
		height = (canvas.getHeight() / heightNum);

		int leftX = 5;
		int topY = 5;
		int rightX = width;
		int bottomY = height;

		boolean conditionX = true;
		boolean conditionY = true;

		int x = 0;
		int y = 0;
		while (conditionY) {

			while (conditionX) {
				Rect rect = new Rect(leftX, topY, rightX, bottomY);
				Node node = new Node(x, y, rect);
//				board[x][y] = node;
				
				board.add(node);
				
				leftX = leftX + width + 1;
				rightX = rightX + width + 1;
				conditionX = (leftX < (endWidth - width));
				x++;
			}
			x = 0;
			y++;

			leftX = 5;
			rightX = width;
			conditionX = true;

			topY = topY + height + 1;
			bottomY = bottomY + height + 1;

			conditionY = (topY < (endHeight - height));
		}
	}

	private void initSnake(int x, int y) {
		snake = new Snake(x, y);
		LinkedList<Node> body = new LinkedList<Node>();
		
		for (int i = 0; i < 17; i++) {
			body.add(new Node(0, i, null));
		}
		snake.setBody(body);
	}

	public Direction getDirection(){
		return direction;
	}
	public void setDirection(Direction direction){
		this.direction=direction;
	}








private Runnable updateTimerThread = new Runnable() {
		public void run() {
			/*int rand = (int) (Math.random() * 30);
			
			switch (rand) {
				case 1:
					direction = Direction.RIGHT;
					break;
				case 2:
					direction = Direction.LEFT;
					break;
				case 3:
					direction = Direction.UP;
					break;
				case 4:
					direction = Direction.DOWN;
					break;
				default:
					break;
			}*/
			snake.move(direction);
			invalidate();
		}
	};

}
