import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BEEP_INVADERS_LAUNCHER implements ActionListener {
	String[] Options = { "Select How Many Windows You Want!", "1", "2", "3", "4", "5" };
	JComboBox numboxes = new JComboBox(Options);
	JFrame pm = new JFrame("BEEP INVADERS!");
	JPanel p = new JPanel();
	JLabel ins = new JLabel("Samuel Sharp's BEEP INVADERS!");
	JLabel ins2 = new JLabel("Please select a number of games below. \n The game windows will have to share the keyboard, however. \n It's as close as you can get to separate profiles in this game! \n There is no limit to how many you can launch, as long as you do it 5 at a time!");
	JLabel ins3 = new JLabel("- Samuel");
	JLabel bl = new JLabel(" ");
	
	public static void main(String[] args) {
				BEEP_INVADERS_LAUNCHER bil = new BEEP_INVADERS_LAUNCHER();
				bil.setup();
	}
	void setup() {
		p.add(ins);
		p.add(ins2);
		p.add(ins3);
		p.add(bl);
		p.add(numboxes);
		pm.add(p);
		pm.setVisible(true);
		pm.pack();
		pm.setSize(1737, 94);
		numboxes.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
	    String optsel = (String)cb.getSelectedItem();
	    int opsel = Integer.parseInt(optsel);
	    for(int i = 0; i<opsel; i++) {
	    	BEEPInvadersPLAYER player = new BEEPInvadersPLAYER();
			player.main(Options);
	    }
		
	}
}
