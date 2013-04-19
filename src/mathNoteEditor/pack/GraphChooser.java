package mathNoteEditor.pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jhotdraw.figures.LineFigure;
import org.jhotdraw.framework.Tool;
import org.jhotdraw.standard.CreationTool;

public class GraphChooser extends JDialog {
	
	private MathNoteEditorGUI gui;
	private JButton sgraph = new JButton("Simple");
	private JButton fourgraph = new JButton("4 Quadrant");
	private JButton tgraph = new JButton("ticked");
	private JButton fourtgraph = new JButton("4 Q ticked");
	
	public GraphChooser(MathNoteEditorGUI gui) {
		this.gui = gui;
		this.setSize(300, 300);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		panel.setSize(300, 300);
		this.add(panel);
		
		List<JButton> list = Arrays.asList(sgraph, fourgraph, tgraph, fourtgraph);
		 
		for (JButton b: list) {
			panel.add(b);
			b.addActionListener(new Listener());
		}
	}
	
	private void kill() {
		this.setVisible(false);
		this.dispose();
	}
	
	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Simple":
				Tool t = new CreationTool(gui, new SimpleGraph());
				gui.setTool(t, "Simple Graph");
				kill();
				break;
			case "4 Quadrant":
				t = new CreationTool(gui, new FourQuadGraph());
				gui.setTool(t, "Simple Graph");
				kill();
				break;
			case "ticked":
				t = new CreationTool(gui, new TickedGraph());
				gui.setTool(t, "TickedGraph");
				kill();
				break;
			case "4 Q ticked":
				t = new CreationTool(gui, new TickedFourQuad());
				gui.setTool(t, "TickedFourGraph");
				kill();
				break;
				
				default: break;
			}
		}
	}
}
