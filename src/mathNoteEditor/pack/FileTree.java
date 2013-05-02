package mathNoteEditor.pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.jhotdraw.util.StorageFormat;
	

	public class FileTree extends JPanel {
		
		private JTree tree;
		private String file;
		private MathNoteEditorGUI gui;
		
	
	  public FileTree(File dir, MathNoteEditorGUI gui) {
		  
		this.gui = gui;
	    setLayout(new BorderLayout());

	    // JTree with directories for nodes
	    tree = new JTree(addNodes(null, dir));
	    

	    // Add a listener
	    tree.addTreeSelectionListener(new TreeSelectionListener() {
	      public void valueChanged(TreeSelectionEvent e) {
	        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
	            .getPath().getLastPathComponent();
	      }
	    });

	    // Put the JTree into a JScrollPane.
	    JScrollPane scrollpane = new JScrollPane();
	    scrollpane.getViewport().add(tree);
	    add(BorderLayout.CENTER, scrollpane);
	    
	    tree.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		        doMouseClicked(me);
		      }
		  });
	   
	  }

	  /** Add nodes from under "dir" into curTop. Highly recursive. */
	  DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {
	    String curPath = dir.getPath();
	    DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(curPath);
	    if (curTop != null) { // should only be null at root
	      curTop.add(curDir);
	    }
	    Vector ol = new Vector();
	    String[] tmp = dir.list();
	    for (int i = 0; i < tmp.length; i++)
	      ol.addElement(tmp[i]);
	    Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
	    File f;
	    Vector files = new Vector();
	    // Make two passes, one for Dirs and one for Files. This is #1.
	    for (int i = 0; i < ol.size(); i++) {
	      String thisObject = (String) ol.elementAt(i);
	      String newPath;
	      if (curPath.equals("."))
	        newPath = thisObject;
	      else
	        newPath = curPath + File.separator + thisObject;
	      if ((f = new File(newPath)).isDirectory())
	        addNodes(curDir, f);
	      else
	        files.addElement(thisObject);
	    }
	    // Pass two: for files.
	    for (int fnum = 0; fnum < files.size(); fnum++)
	      curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
	    return curDir;
	  }

	  public Dimension getMinimumSize() {
	    return new Dimension(200, 400);
	  }

	  public Dimension getPreferredSize() {
	    return new Dimension(400, 600);
	  }
	

	  void doMouseClicked(MouseEvent me) {
	    TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
	    System.out.println(tp.toString());
	    int n = tp.getPathCount();
	    String path = tp.getPathComponent(n-2).toString();
	    String name = tp.getLastPathComponent().toString();
	    file = path + "/" + name;
	    File realFile = new File(file);
//	    StorageFormat foundFormat;
//	    foundFormat = gui.getStorageFormatManager().findStorageFormat(realFile);
//	    gui.loadDrawing(foundFormat, file);
	  }
	  
	
	  
	  /** Main: make a Frame, add a FileTree */
	  public void newTree(String[] av) {
	
		
	    JFrame frame = new JFrame("Classes");
	    frame.setForeground(Color.black);
	    frame.setBackground(Color.lightGray);
	    Container cp = frame.getContentPane();

	    if (av.length == 0) {
	      String dirName = (String)JOptionPane.showInputDialog(null);
	      cp.add(new FileTree(new File(dirName), gui));
	    } else {
	      cp.setLayout(new BoxLayout(cp, BoxLayout.X_AXIS));
	      for (int i = 0; i < av.length; i++)
	        cp.add(new FileTree(new File(av[i]), gui));
	    }

	    frame.pack();
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	}