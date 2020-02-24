package com.example.uvcebookmark.Snakey;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

import com.example.uvcebookmark.R;

public class BoardActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_board);
		final BoardView boardView = findViewById(R.id.canvas);
		boardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				boardView.setDirection(Direction.DOWN);
			}
		});
	}
}