package mathNoteEditor.pack;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jhotdraw.figures.ImageFigure;
import org.jhotdraw.standard.CreationTool;
import org.jhotdraw.util.UndoableTool;

public class SymbolChooser extends JDialog {

	private JButton s1, s2, s3, s4, s5, s6, s7, s8;
	private MathNoteEditorGUI gui;
	private String s = "/resources/";
	private String[] sArray = {s+"sqrt.png", s+"lt.png", s+"gt.png", 
			s+"ltet.png", s+"gtet.png", s+"integral.png",
			s+"prime.png", s+"porm.png"};

	public SymbolChooser(MathNoteEditorGUI gui) {
		this.gui = gui;
		this.setSize(300, 300);
		JTabbedPane tabPane = new JTabbedPane();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.setLayout(new GridLayout(4, 2));
		panel1.setSize(300, 300);
		this.add(tabPane);
		tabPane.addTab("Common", panel1);
		tabPane.addTab("Logic", panel2);
		tabPane.addTab("Other", panel3);

		JButton[] bArray = {s1, s2, s3, s4, s5, s6, s7, s8};

		for (int i=0; i<bArray.length; i++) {
			Container c = new Container();
			c.setLayout(new FlowLayout());
			bArray[i] = new JButton();
			bArray[i].addActionListener(new Listener());
			bArray[i].setActionCommand(""+i);

			Image img = null;
			try {
//				System.out.println(sArray[i]);
				img = ImageIO.read(getClass().getResource(sArray[i]));
			} catch (Exception e) {}
			bArray[i].setIcon(new ImageIcon(img));
			bArray[i].setActionCommand("" + i);
			c.add(bArray[i]);
			panel1.add(c);
		}
	}
	
	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Image img = null;
			int bCommand = Integer.parseInt(e.getActionCommand());
			String imgStr = null;
			
			switch(bCommand) {
			case 0:
				imgStr = sArray[0];
				break;
			case 1:
				imgStr = sArray[1];
				break;
			case 2:
				imgStr = sArray[2];
				break;
			case 3:
				imgStr = sArray[3];
				break;
			case 4:
				imgStr = sArray[4];
				break;
			case 5:
				imgStr = sArray[5];
				break;
			case 6:
				imgStr = sArray[6];
				break;
			case 7:
				imgStr = sArray[7];
				break;
			}
			
			try {
				img = ImageIO.read(getClass().getResource(imgStr));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 	
			gui.setTool(new UndoableTool(
					new CreationTool(gui, new ImageFigure(img, imgStr, 
							new Point(0,0)))), "symbol");	
		}
	}
}

