package viewPackage;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;

public class FileChooserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public FileChooserPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblSelectAFile = new JLabel("Select a file");
		lblSelectAFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblSelectAFile);

	}

}
