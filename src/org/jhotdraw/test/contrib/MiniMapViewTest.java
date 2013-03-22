/*
 * @(#)Test.java
 *
 * Project:		JHotdraw - a GUI framework for technical drawings
 *				http://www.jhotdraw.org
 *				http://jhotdraw.sourceforge.net
 * Copyright:	� by the original author(s) and all contributors
 * License:		Lesser GNU Public License (LGPL)
 *				http://www.opensource.org/licenses/lgpl-license.html
 */
package org.jhotdraw.test.contrib;
import java.awt.Component;

import javax.swing.JScrollPane;

// JUnitDoclet begin import
import org.jhotdraw.contrib.MiniMapView;
import org.jhotdraw.test.JHDTestCase;
// JUnitDoclet end import

/*
 * Generated by JUnitDoclet, a tool provided by
 * ObjectFab GmbH under LGPL.
 * Please see www.junitdoclet.org, www.gnu.org
 * and www.objectfab.de for informations about
 * the tool, the licence and the authors.
 */

// JUnitDoclet begin javadoc_class
/**
 * TestCase MiniMapViewTest is generated by
 * JUnitDoclet to hold the tests for MiniMapView.
 * @see org.jhotdraw.contrib.MiniMapView
 */
// JUnitDoclet end javadoc_class
public class MiniMapViewTest
// JUnitDoclet begin extends_implements
extends JHDTestCase
// JUnitDoclet end extends_implements
{
	// JUnitDoclet begin class
	// instance variables, helper methods, ... put them in this marker
	private MiniMapView minimapview;
	// JUnitDoclet end class

	/**
	 * Constructor MiniMapViewTest is
	 * basically calling the inherited constructor to
	 * initiate the TestCase for use by the Framework.
	 */
	public MiniMapViewTest(String name) {
		// JUnitDoclet begin method MiniMapViewTest
		super(name);
		// JUnitDoclet end method MiniMapViewTest
	}

	/**
	 * Factory method for instances of the class to be tested.
	 */
	public MiniMapView createInstance() throws Exception {
		// JUnitDoclet begin method testcase.createInstance
		JScrollPane sp = new JScrollPane((Component)getDrawingEditor().view());
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setAlignmentX(Component.LEFT_ALIGNMENT);
		return new MiniMapView(getDrawingEditor().view(), sp);
		// JUnitDoclet end method testcase.createInstance
	}

	/**
	 * Method setUp is overwriting the framework method to
	 * prepare an instance of this TestCase for a single test.
	 * It's called from the JUnit framework only.
	 */
	protected void setUp() throws Exception {
		// JUnitDoclet begin method testcase.setUp
		super.setUp();
		getDrawingEditor().open();
		minimapview = createInstance();
		// JUnitDoclet end method testcase.setUp
	}

	/**
	 * Method tearDown is overwriting the framework method to
	 * clean up after each single test of this TestCase.
	 * It's called from the JUnit framework only.
	 */
	protected void tearDown() throws Exception {
		// JUnitDoclet begin method testcase.tearDown
		minimapview = null;
		super.tearDown();
		// JUnitDoclet end method testcase.tearDown
	}

	// JUnitDoclet begin javadoc_method getMappedDrawingView()
	/**
	 * Method testGetMappedDrawingView is testing getMappedDrawingView
	 * @see org.jhotdraw.contrib.MiniMapView#getMappedDrawingView()
	 */
	// JUnitDoclet end javadoc_method getMappedDrawingView()
	public void testGetMappedDrawingView() throws Exception {
		// JUnitDoclet begin method getMappedDrawingView
		// JUnitDoclet end method getMappedDrawingView
	}

	// JUnitDoclet begin javadoc_method getSubject()
	/**
	 * Method testGetSubject is testing getSubject
	 * @see org.jhotdraw.contrib.MiniMapView#getSubject()
	 */
	// JUnitDoclet end javadoc_method getSubject()
	public void testGetSubject() throws Exception {
		// JUnitDoclet begin method getSubject
		// JUnitDoclet end method getSubject
	}

	// JUnitDoclet begin javadoc_method getViewBowColor()
	/**
	 * Method testGetViewBowColor is testing getViewBowColor
	 * @see org.jhotdraw.contrib.MiniMapView#getViewBowColor()
	 */
	// JUnitDoclet end javadoc_method getViewBowColor()
	public void testGetViewBowColor() throws Exception {
		// JUnitDoclet begin method getViewBowColor
		// JUnitDoclet end method getViewBowColor
	}

	// JUnitDoclet begin javadoc_method setViewBoxColor()
	/**
	 * Method testSetViewBoxColor is testing setViewBoxColor
	 * @see org.jhotdraw.contrib.MiniMapView#setViewBoxColor(java.awt.Color)
	 */
	// JUnitDoclet end javadoc_method setViewBoxColor()
	public void testSetViewBoxColor() throws Exception {
		// JUnitDoclet begin method setViewBoxColor
		// JUnitDoclet end method setViewBoxColor
	}

	// JUnitDoclet begin javadoc_method paint()
	/**
	 * Method testPaint is testing paint
	 * @see org.jhotdraw.contrib.MiniMapView#paint(java.awt.Graphics)
	 */
	// JUnitDoclet end javadoc_method paint()
	public void testPaint() throws Exception {
		// JUnitDoclet begin method paint
		// JUnitDoclet end method paint
	}

	// JUnitDoclet begin javadoc_method testVault
	/**
	 * JUnitDoclet moves marker to this method, if there is not match
	 * for them in the regenerated code and if the marker is not empty.
	 * This way, no test gets lost when regenerating after renaming.
	 * <b>Method testVault is supposed to be empty.</b>
	 */
	// JUnitDoclet end javadoc_method testVault
	public void testVault() throws Exception {
		// JUnitDoclet begin method testcase.testVault
		// JUnitDoclet end method testcase.testVault
	}

}
