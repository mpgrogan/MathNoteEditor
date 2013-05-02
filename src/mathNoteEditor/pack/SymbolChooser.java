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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

	private JButton[] sym;
	private MathNoteEditorGUI gui;
	private String filePath = "/resources/";
	private String[] sArray = {
			"sqrt.png", "lt.png", "gt.png", "ltet.png", "gtet.png", 
			"integral.png", "sigma.png", "porm.png", "summation.png", "delta.png", 
			"null.png", "contains.png", "ncontains.png", "union.png", "intersection.png",
			"nset.png", "qset.png", "realset.png", "pset.png", "zset.png",
			"partial.png", "sintegral.png", "mu.png", "and.png", "or.png", 
			"inf.png", "dintergral.png", "tintegral.png", "bigpi.png", "be.png"
			};

	public SymbolChooser(MathNoteEditorGUI gui) {
		this.gui = gui;
		this.setSize(300, 400);
		JTabbedPane tabPane = new JTabbedPane();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.setLayout(new GridLayout(5, 2));
		panel2.setLayout(new GridLayout(5, 2));
		panel3.setLayout(new GridLayout(5, 2));
		this.add(tabPane);
		tabPane.addTab("Common", panel1);
		tabPane.addTab("Sets", panel2);
		tabPane.addTab("Other", panel3);

		for (int i=0; i<sArray.length; i++) {
			sArray[i] = filePath + sArray[i];
		}
		sym = new JButton[30];

		for (int i=0; i<10; i++) {
			sym[i] = new JButton();
			Container c = new Container();
			c.setLayout(new FlowLayout());
			sym[i].addActionListener(new Listener());
			sym[i].setActionCommand(""+i);

			Image img = null;
			try {
				//				System.out.println(sArray[i]);
				img = ImageIO.read(getClass().getResource(sArray[i]));
			} catch (Exception e) {}
			if (img != null) {
				sym[i].setIcon(new ImageIcon(img));
			}
			c.add(sym[i]);
			panel1.add(c);
		}

		for (int i=10; i<20; i++) {
			sym[i] = new JButton();
			Container c = new Container();
			c.setLayout(new FlowLayout());
			sym[i].addActionListener(new Listener());
			sym[i].setActionCommand(""+i);

			Image img = null;
			try {
				//				System.out.println(sArray[i]);
				img = ImageIO.read(getClass().getResource(sArray[i]));
			} catch (Exception e) {}
			if (img != null) {
				sym[i].setIcon(new ImageIcon(img));
			}
			c.add(sym[i]);
			panel2.add(c);	
		}

		for (int i=20; i<30; i++) {
			sym[i] = new JButton();
			Container c = new Container();
			c.setLayout(new FlowLayout());
			sym[i].addActionListener(new Listener());
			sym[i].setActionCommand(""+i);

			Image img = null;
			try {
				//				System.out.println(sArray[i]);
				img = ImageIO.read(getClass().getResource(sArray[i]));
			} catch (Exception e) {}
			if (img != null) {
				sym[i].setIcon(new ImageIcon(img));
			}
			c.add(sym[i]);
			panel3.add(c);	
			}
	}

	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Image img = null;
			int bCommand = Integer.parseInt(e.getActionCommand());
			String imgStr = sArray[bCommand];

			try {
				img = ImageIO.read(getClass().getResource(imgStr));
			} catch (IOException e1) {}

			if (img != null)
				gui.setTool(new UndoableTool(
					new CreationTool(gui, new ImageFigure(img, imgStr, 
							new Point(0,0)))), "symbol");	
		}
	}
}

