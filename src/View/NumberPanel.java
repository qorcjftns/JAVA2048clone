package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Utilities.NumberPanelUtility;

/**
 * Number Panel Class.
 * Contains full information of each number panel.
 * @author CSBaek
 *
 */
public class NumberPanel extends JPanel {
	
	private int mNumber;
	private JLabel mLabel;
	
	public NumberPanel(int i) {
		super(new GridBagLayout());
		mNumber = i;
		mLabel = new JLabel();
		mLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		this.add(mLabel);
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));
		
		refreshPanelColor();
		updateNumber();
	}
	
	// initialize helpers.
	private void refreshPanelColor() {
		this.setBackground(NumberPanelUtility.getColorForNumber(mNumber));
	}
	
	private void updateNumber() {
		if(mNumber != 0) 
			mLabel.setText(Integer.toString(mNumber));
		else
			mLabel.setText("");
	}
	
	// Setter and Getters
	/**
	 * Set number of panel.
	 * @param i
	 */
	public void setNumber(int i) {
		mNumber = i;
		refreshPanelColor();
		updateNumber();
		this.repaint();
	}
	
	/**
	 * Returns panel number
	 * @return
	 */
	public int getNumber() {
		return mNumber;
	}
	
}
