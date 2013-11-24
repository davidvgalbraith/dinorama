package com.amazon.dinorama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameWinActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_win_screen);
	}
	
	public void initiateReplay(View view){
		Intent myIntent = new Intent(GameWinActivity.this, GameActivity.class);
		GameWinActivity.this.startActivity(myIntent);
	}
	
	public void initiateCharacterSelect(View view){
		Intent myIntent = new Intent(GameWinActivity.this, CharacterSelectActivity.class);
		GameWinActivity.this.startActivity(myIntent);
	}
	
	public void initiateLevelSelect(View view){
		Intent myIntent = new Intent(GameWinActivity.this, LevelSelectActivity.class);
		GameWinActivity.this.startActivity(myIntent);
	}
	
	public void initiateMainMenu(View view){
		Intent myIntent = new Intent(GameWinActivity.this, DinoramaActivity.class);
		GameWinActivity.this.startActivity(myIntent);
	}
	
}
