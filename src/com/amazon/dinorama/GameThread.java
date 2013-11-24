package com.amazon.dinorama;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

	// desired fps
	private final static int MAX_FPS = 50;
	// maximum number of frames to be skipped
	private final static int MAX_FRAME_SKIPS = 5;
	// the frame period
	private final static int FRAME_PERIOD = 1000 / MAX_FPS;	

	// flag to hold game state
	private boolean running;

	private long beginTime;		// the time when the cycle begun
	private long timeDiff;		// the time it took for the cycle to execute
	private int sleepTime = 0;	// ms to sleep (<0 if we're behind)
	private int framesSkipped;	// number of frames being skipped

	// Surface holder that can access the physical surface
	private SurfaceHolder surfaceHolder;
	// The actual view that handles inputs and draws to the surface
	private GameView gameView;

	private Canvas canvas;

	public GameThread(SurfaceHolder surfaceHolder, GameView gameView) {
		super();
		this.surfaceHolder = surfaceHolder;
		this.gameView = gameView;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		while (!this.isInterrupted()) {
			if (running) {
				canvas = null;
				// try locking the canvas for exclusive pixel editing
				// in the surface
				try {
					canvas = this.surfaceHolder.lockCanvas();
					synchronized (surfaceHolder) {
						beginTime = System.currentTimeMillis();
						framesSkipped = 0;	// resetting the frames skipped
						// update game state
						this.gameView.update();
						// render state to the screen
						// draws the canvas on the panel
						this.gameView.render(canvas);
						// calculate how long did the cycle take
						timeDiff = System.currentTimeMillis() - beginTime;
						// calculate sleep time
						sleepTime = (int)(FRAME_PERIOD - timeDiff);

						// print fps
//						System.out.println(1000.0/timeDiff);

						if (sleepTime > 0) {
							// if sleepTime > 0 we're OK
							try {
								// send the thread to sleep for a short period
								// very useful for battery saving
								Thread.sleep(sleepTime);
							} catch (InterruptedException e) {}
						}

						while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
							// we need to catch up
							// update without rendering
							this.gameView.update();
							// add frame period to check if in next frame
							sleepTime += FRAME_PERIOD;
							framesSkipped++;
						}
					}
				} finally {
					// in case of an exception the surface is not left in
					// an inconsistent state
					if (canvas != null) {
						surfaceHolder.unlockCanvasAndPost(canvas);
					}
				}	// end finally
			} else {
				try {
					Thread.sleep(100);
				} catch (Exception e) {}
			}
		}
	}
}
