package View;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private int kWidth = 600;
	private int kHeight = 600;
	private static String kWindowTitle = "2048";
	private GameBoard mMainBoard;
	
	public MainFrame() {
		super(kWindowTitle);
		this.setSize(kWidth, kHeight);
		mMainBoard = new GameBoard();
		this.add(mMainBoard);
		
	}

}
