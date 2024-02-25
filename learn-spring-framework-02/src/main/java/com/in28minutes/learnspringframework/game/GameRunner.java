package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class GameRunner {
	private GamingConsole game;
	
	public GameRunner(@Qualifier("SuperContraGameQualifier")GamingConsole game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game:" + game);
		//좋은 사례는 아님, 로깅 프레임워크를 사용하는 것이 좋음 
		game.up();
		game.down();
		game.left();
		game.right();
	}

}
