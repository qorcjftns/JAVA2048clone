package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.management.MXBean;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Utilities.NumberPanelUtility;

public class GameBoard extends JPanel {
	
	private static int kXnum = 4;
	private static int kYnum = 4;
	
	private Vector<NumberPanel> mPanels;
	
	
	public GameBoard() {
		super(new GridLayout(kYnum, kXnum));
		this.setBackground(Color.WHITE);
		
		mPanels = new Vector<NumberPanel>();
		
		initializePanels();
		initializeKeyboardListener();
		
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		this.setFocusable(true);
		this.requestFocusInWindow();
		
	}
	
	private void initializePanels() {
		for(int i = 0 ; i < kYnum ; i++) {
			for(int j = 0 ; j < kXnum ; j++) {
				NumberPanel newPanel = new NumberPanel(0);
				mPanels.add(newPanel);
				this.add(newPanel);
			}
		}
		createNewPanel();
	}
	
	private void movePanels(int direction) {
		switch(direction) {
			case KeyEvent.VK_UP:
				NumberPanelUtility.panelsMoveUp(mPanels, kXnum, kYnum); break;
			case KeyEvent.VK_DOWN:
				NumberPanelUtility.panelsMoveDown(mPanels, kXnum, kYnum); break;
			case KeyEvent.VK_LEFT:
				NumberPanelUtility.panelsMoveLeft(mPanels, kXnum, kYnum); break;
			case KeyEvent.VK_RIGHT:
				NumberPanelUtility.panelsMoveRight(mPanels, kXnum, kYnum); break;
		}
		createNewPanel();
	}
	
	private void removePanels() {
		this.removeAll();
	}
	
	private void initializeKeyboardListener() {
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_UP:
					case KeyEvent.VK_DOWN:
					case KeyEvent.VK_LEFT:
					case KeyEvent.VK_RIGHT:
						movePanels(e.getKeyCode());
						break;
					default:
						break;
				}
			}
			
		});
		
	}
	
	private void createNewPanel() {
		int place = NumberPanelUtility.getNewPlace(mPanels);
		mPanels.get(place).setNumber(2);
	}
	
	
}
