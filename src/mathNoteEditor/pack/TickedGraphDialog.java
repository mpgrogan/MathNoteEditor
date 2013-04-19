package mathNoteEditor.pack;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jhotdraw.framework.Tool;
import org.jhotdraw.standard.CreationTool;

public class TickedGraphDialog extends JDialog {

	private JTextField xmax, ymax;
	private JButton createButton;
	private MathNoteEditorGUI gui;
	private TickedGraph tg;

	public TickedGraphDialog(MathNoteEditorGUI gui) {
		this.setTitle("Ticked Graph");
		this.gui = gui;
		this.setSize(300, 300);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setSize(300, 300);
		this.add(panel);

		Container c[] = {new Container(), new Container(), new Container(), new Container()};
		for (Container x: c) {
			x.setLayout(new FlowLayout()); 
			panel.add(x);
		}
		//c[0].add(new JLabel("X Min"));
		c[1].add(new JLabel("X Max"));
		//c[2].add(new JLabel("Y Min"));
		c[3].add(new JLabel("Y Max"));
		//xmin = new JTextField(3); 
		//c[0].add(xmin);
		xmax = new JTextField(3);
		c[1].add(xmax);
		//ymin = new JTextField(3); 
		//c[2].add(ymin);
		ymax = new JTextField(3);
		c[3].add(ymax);
		createButton = new JButton("Create Graph");
		createButton.addActionListener(new Blistener());
		panel.add(createButton);
	}
	
	private void kill() {
		this.setVisible(false);
		this.dispose();
	}
	
	private class Blistener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tg = new TickedGraph();
			if (!xmax.getText().equals(""))
				tg.setXMax(Integer.parseInt(xmax.getText()));
			if (!ymax.getText().equals(""))
				tg.setYMax(Integer.parseInt(ymax.getText()));
//			System.out.println(Integer.parseInt(xmax.getText()) + " " + Integer.parseInt(ymax.getText()));
			Tool t = new CreationTool(gui, tg);
			gui.setTool(t, "Ticked Graph");
			kill();
		}	
	}
}
