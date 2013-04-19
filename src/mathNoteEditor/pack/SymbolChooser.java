package mathNoteEditor.pack;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class SymbolChooser extends JDialog {
	
	private JButton s1, s2, s3, s4, s5, s6, s7, s8;
	private MathNoteEditorGUI gui;
	
	public SymbolChooser(MathNoteEditorGUI gui) {
		this.gui = gui;
		this.setSize(300, 300);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		panel.setSize(300, 300);
		this.add(panel);
		List <JButton> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
		
		for (JButton b : list) {
			b = new JButton("button");
			panel.add(b);
		}
	}
}

