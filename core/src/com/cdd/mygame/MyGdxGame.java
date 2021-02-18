package com.cdd.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	Rectangle imgO;
	
	@Override
	public void create () {
		//initialization
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		imgO = new Rectangle();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, imgO.x, imgO.y);
		batch.end();


		//touch mechanism
		if(Gdx.input.isTouched()){
			Vector2 touch = new Vector2();
			touch.set(Gdx.input.getX(),Gdx.input.getY());
			imgO.x = touch.x -110;
			imgO.y = -touch.y + 940;
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
