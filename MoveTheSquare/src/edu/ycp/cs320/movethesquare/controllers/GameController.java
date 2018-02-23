package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			
			if (dx > 0) {
				moveX = Game.MOVE_DIST;
			} else {
				moveX = -Game.MOVE_DIST;
			}
			if (dy > 0) {
				moveY = Game.MOVE_DIST;
			} else {
				moveY = -Game.MOVE_DIST;
			}
			if (moveY == moveX || moveY*-1 == moveX) { 
				if(Math.abs(dy) > Math.abs(dx)) {
					moveX = 0;
				} else {
					moveY = 0;
				}
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		if((square.getX() < model.getWidth()-(square.getWidth()/2) || model.getSquareDx() < 0) && (square.getX() >= 0-square.getWidth()/2 || model.getSquareDx() > 0))
			square.setX(square.getX() + model.getSquareDx());
		if((square.getY() < model.getHeight()-(square.getHeight()/2) || model.getSquareDy() < 0) && (square.getY() >= 0-square.getHeight()/2 || model.getSquareDy() > 0))
			square.setY(square.getY() + model.getSquareDy());
	}
}
