package Utilities;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

import View.NumberPanel;


/**
 * NumberPanelUtility Class.
 * Contains all methods handling NumberPanel.
 * @author CSBaek
 *
 */
public class NumberPanelUtility {

	public static Color getColorForNumber(int i) {
		switch(i) {
			case 2:			return new Color(255,250,200);
			case 4:			return new Color(255,240,100);
			case 8:			return new Color(255,230,0);
			case 16:		return new Color(255,200,100);
			case 32:		return new Color(245,150,50);
			case 64:		return new Color(255,250,200);
			case 128:		return new Color(255,250,200);
			case 256:		return new Color(255,250,200);
			case 512:		return new Color(255,250,200);
			case 1024:		return new Color(255,250,200);
			case 2048:		return new Color(255,250,200);
			case 4096:		return new Color(255,250,200);
			case 8192:		return new Color(255,250,200);
			default:		return Color.WHITE;
		}
	}
	
	public static int getNewPlace(Vector<NumberPanel> numVec) {
		Random r = new Random(System.currentTimeMillis());
		int place;
		do {
			 place = r.nextInt(numVec.size());
		} while(numVec.get(place).getNumber() != 0);
		return place;
	}
	
	public static int getIndexFromXY(int x, int y, int xNum) {
		return x + (y * xNum);
	}
	private static void panelMove(Vector<NumberPanel> board, int xNum, int yNum, int x, int y, int dir) {
		int posInVector = getIndexFromXY(x, y, xNum);
		int newX, newY;
		if(dir == KeyEvent.VK_UP) {
			newX = x;
			newY = Math.max(y-1, 0);
			if(newY == y || (board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0 && 
					board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != board.get(posInVector).getNumber())) {
				return;
			} else {
				if(board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0) {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber() * 2);
				} else {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber());
				}
				board.get(posInVector).setNumber(0);
				panelMove(board,xNum,yNum,newX,newY,dir);
			}
		} else if (dir == KeyEvent.VK_DOWN) {
			newX = x;
			newY = Math.min(y+1, yNum-1);
			if(newY == y || (board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0 && 
					board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != board.get(posInVector).getNumber())) {
				return;
			} else {
				if(board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0) {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber() * 2);
				} else {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber());
				}
				board.get(posInVector).setNumber(0);
				panelMove(board,xNum,yNum,newX,newY,dir);
			}
		} else if (dir == KeyEvent.VK_LEFT) {
			newX = Math.max(x-1, 0);
			newY = y;
			System.err.println("newX: " + newX + "\n newY: " + newY);
			if(newX == x || (board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0 && 
							board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != board.get(posInVector).getNumber())) {
				System.err.println(board.get(posInVector).getNumber());
				return;
			} else {
				if(board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0) {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber() * 2);
				} else {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber());
				}
				board.get(posInVector).setNumber(0);
				panelMove(board,xNum,yNum,newX,newY,dir);
			}
		} else {
			newX = Math.min(x+1, xNum-1);
			newY = y;
			if(newX == x || (board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0 && 
					board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != board.get(posInVector).getNumber())) {
				return;
			} else {
				if(board.get(getIndexFromXY(newX, newY, xNum)).getNumber() != 0) {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber() * 2);
				} else {
					board.get(getIndexFromXY(newX, newY, xNum)).setNumber(board.get(posInVector).getNumber());
				}
				board.get(posInVector).setNumber(0);
				panelMove(board,xNum,yNum,newX,newY,dir);
			}
		}
		
	}
	
	/**
	 * move to left.
	 * start from left.
	 * @param board
	 * @param xNum
	 * @param yNum
	 */
	public static void panelsMoveLeft(Vector<NumberPanel> board, int xNum, int yNum) {
		for(int y = 0 ; y < yNum ; y++) {
			for(int x = 0 ; x < xNum ; x++) {
				if(board.get(getIndexFromXY(x, y, xNum)).getNumber() != 0) {
					panelMove(board,xNum,yNum,x,y,KeyEvent.VK_LEFT);
				}
			}
		}
	}
	public static void panelsMoveRight(Vector<NumberPanel> board, int xNum, int yNum) {
		for(int y = 0 ; y < yNum ; y++) {
			for(int x = xNum-1 ; x >=0 ; x--) {
				if(board.get(getIndexFromXY(x, y, xNum)).getNumber() != 0) {
					panelMove(board,xNum,yNum,x,y,KeyEvent.VK_RIGHT);
			
				}
			}
		}
	}
	public static void panelsMoveUp(Vector<NumberPanel> board, int xNum, int yNum) {
		for(int x = 0 ; x < xNum ; x++) {
			for(int y = 0 ; y < yNum ; y++) {
				if(board.get(getIndexFromXY(x, y, xNum)).getNumber() != 0) {
					panelMove(board,xNum,yNum,x,y,KeyEvent.VK_UP);
				}
			}
		}
	}
	public static void panelsMoveDown(Vector<NumberPanel> board, int xNum, int yNum) {
		for(int x = 0 ; x < xNum ; x++) {
			for(int y = yNum-1 ; y >= 0 ; y--) {
				if(board.get(getIndexFromXY(x, y, xNum)).getNumber() != 0) {
					panelMove(board,xNum,yNum,x,y,KeyEvent.VK_DOWN);
				}
			}
		}
	}
	
	
}
