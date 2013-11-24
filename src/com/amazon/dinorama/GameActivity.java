package com.amazon.dinorama;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class GameActivity extends Activity {

	MediaPlayer song;
	
	protected GameView gameView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
        
        song = MediaPlayer.create(GameActivity.this, R.raw.game_mode);
        song.setLooping(true);
        song.start();

    }
    
    public void triggerEnd(int win) {
    	if(win == 1){
    		Intent myIntent = new Intent(GameActivity.this, GameWinActivity.class);
    		GameActivity.this.startActivity(myIntent);
    	}
    	if(win == 2){
    		Intent myIntent = new Intent(GameActivity.this, GameOverActivity.class);
    		GameActivity.this.startActivity(myIntent);
    	}
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	gameView.activate(false);
    	song.stop();
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	gameView.activate(true);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	gameView.activate(true);
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	gameView.activate(true);
    }
}