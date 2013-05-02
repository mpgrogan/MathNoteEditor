package mathNoteEditor.pack;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import org.jhotdraw.application.DrawApplication;
import org.jhotdraw.contrib.MDI_DrawApplication;
import org.jhotdraw.contrib.TextAreaFigure;
import org.jhotdraw.contrib.TriangleFigure;
import org.jhotdraw.contrib.html.HTMLTextAreaFigure;
import org.jhotdraw.contrib.html.HTMLTextAreaTool;
import org.jhotdraw.contrib.zoom.ZoomDrawingView;
import org.jhotdraw.figures.AbstractLineDecoration;
import org.jhotdraw.figures.ArrowTip;
import org.jhotdraw.figures.ConnectedTextTool;
import org.jhotdraw.figures.EllipseFigure;
import org.jhotdraw.figures.ImageFigure;
import org.jhotdraw.figures.LineFigure;
import org.jhotdraw.figures.NumberTextFigure;
import org.jhotdraw.figures.PolyLineFigure;
import org.jhotdraw.figures.RectangleFigure;
import org.jhotdraw.figures.ScribbleTool;
import org.jhotdraw.figures.TextFigure;
import org.jhotdraw.figures.TextTool;
import org.jhotdraw.framework.Drawing;
import org.jhotdraw.framework.DrawingView;
import org.jhotdraw.framework.FigureAttributeConstant;
import org.jhotdraw.framework.Tool;
import org.jhotdraw.samples.javadraw.JavaDrawApp;
import org.jhotdraw.standard.CreationTool;
import org.jhotdraw.test.util.CommandButtonTest;
import org.jhotdraw.util.CommandButton;
import org.jhotdraw.util.FloatingTextField;
import org.jhotdraw.util.PaletteButton;
import org.jhotdraw.util.UndoableTool;

public class MathNoteEditorGUI extends MDI_DrawApplication {

	/**
	 * @param args
	 */
	static Color DEFAULT_SHAPE_COLOR = new Color(255, 255, 255, 0);
	//private GraphChooser graphchooser;
	
	public MathNoteEditorGUI() {
		super("MNE");
	}
	
	public Color getDefaultShapeColor() {
		return DEFAULT_SHAPE_COLOR;
	}
	
	@Override
	protected void createTools(JToolBar palette) {
		super.createTools(palette);
		
		Tool triangleTool = new CreationTool(this, makeTriangle());
		Tool ellipseTool = new CreationTool(this, makeEllipse());
		Tool rectTool = new CreationTool(this, makeRectangle());
		Tool lineTool = new CreationTool(this, new LineFigure());
		
		palette.add(createToolButton(IMAGES + "TRIANGLE", "Triangle Tool", triangleTool));
		palette.add(createToolButton(IMAGES + "ELLIPSE", "Ellipse Tool", ellipseTool));
		palette.add(createToolButton(IMAGES + "RECT", "Rectangle Tool", rectTool));
		palette.add(createToolButton(IMAGES + "LINE", "Line Tool", lineTool));
		
		Tool tool = new TextTool(this, new Text());
		palette.add(createToolButton(IMAGES + "TEXT", "Text Tool", tool));
		
		tool = new TextTool(this, makeNumber());
		palette.add(createToolButton(IMAGES + "NUMBER", "Number Tool", tool));
		
		tool = new UndoableTool(new ScribbleTool(this));
		palette.add(createToolButton(IMAGES + "SCRIBBL", "Scribble Tool", tool));
				
		//tool = new CreationTool(this, new DashedLine());
		//palette.add(createToolButton(IMAGES + "LINE", "Line Tool", tool));

		JButton graphChoose = new JButton("G");
		graphChoose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewGraphChooser();
			}
		});
		palette.add(graphChoose);
		
		JButton symbolChoose = new JButton("S");
		symbolChoose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewSymbolChooser();
			}
		});
		palette.add(symbolChoose);
	}
	
	
	public void NewGraphChooser() {
		JDialog graphchooser = new GraphChooser(this);
		graphchooser.setLocation(this.getLocation().x + this.getSize().width, this.getLocation().y);
		graphchooser.setVisible(true);
	}
	
	public void NewSymbolChooser() {
		JDialog symbolChooser = new SymbolChooser(this);
		symbolChooser.setLocation(this.getLocation().x + this.getSize().width, this.getLocation().y);
		symbolChooser.setVisible(true);
	}
	
	public TriangleFigure makeTriangle() {
		TriangleFigure t = new TriangleFigure();
		t.setAttribute(FigureAttributeConstant.FILL_COLOR, DEFAULT_SHAPE_COLOR);
		return t;
	}
	
	public EllipseFigure makeEllipse() {
		EllipseFigure e = new EllipseFigure();
		e.setAttribute(FigureAttributeConstant.FILL_COLOR, DEFAULT_SHAPE_COLOR);
		return e;
	}
	
	public RectangleFigure makeRectangle() {
		RectangleFigure r = new RectangleFigure();
		r.setAttribute(FigureAttributeConstant.FILL_COLOR, DEFAULT_SHAPE_COLOR);
		return r;
	}
	
	public static NumberTextFigure makeNumber() {		
		NumberTextFigure.setCurrentFontSize(20);
		NumberTextFigure n = new NumberTextFigure();
		return n;
	}
	
	@Override
	protected void createMenus(JMenuBar mb) {
		addMenuIfPossible(mb, createFileMenu());
		addMenuIfPossible(mb, createEditMenu());
	}
	
	public static void main(String[] args) {
		DrawApplication window = new MathNoteEditorGUI();
		window.open();
		window.resize(1200, 700);
		window.promptNew();
		//window.get
	}
}
