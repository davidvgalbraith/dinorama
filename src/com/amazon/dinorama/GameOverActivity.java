package com.amazon.dinorama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameOverActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over_screen);
	}
	
	public void initiateReplay(View view){
		Intent myIntent = new Intent(GameOverActivity.this, GameActivity.class);
    	GameOverActivity.this.startActivity(myIntent);
	}
	
	public void initiateCharacterSelect(View view){
		Intent myIntent = new Intent(GameOverActivity.this, CharacterSelectActivity.class);
    	GameOverActivity.this.startActivity(myIntent);
	}
	
	public void initiateLevelSelect(View view){
		Intent myIntent = new Intent(GameOverActivity.this, LevelSelectActivity.class);
    	GameOverActivity.this.startActivity(myIntent);
	}
	
	public void initiateMainMenu(View view){
		Intent myIntent = new Intent(GameOverActivity.this, DinoramaActivity.class);
    	GameOverActivity.this.startActivity(myIntent);
	}
	
}
