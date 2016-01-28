/*
 * The JTS Topology Suite is a collection of Java classes that
 * implement the fundamental operations required to validate a given
 * geo-spatial data set to a known topological specification.
 * 
 * Copyright (C) 2016 Vivid Solutions
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Vivid Solutions BSD
 * License v1.0 (found at the root of the repository).
 * 
 */

package com.vividsolutions.jtstest.testbuilder.ui.style;

import java.awt.*;
import java.awt.geom.Point2D;

import org.locationtech.jts.geom.*;

import com.vividsolutions.jtstest.*;
import com.vividsolutions.jtstest.testbuilder.AppConstants;
import com.vividsolutions.jtstest.testbuilder.ui.GraphicsUtil;
import com.vividsolutions.jtstest.testbuilder.ui.Viewport;
import com.vividsolutions.jtstest.testbuilder.ui.render.GeometryPainter;

public class DataLabelStyle implements Style
{
  private Color color;

  public DataLabelStyle(Color color) {
    this.color = color;
  }

  public DataLabelStyle() {
  }

  public void paint(Geometry geom, Viewport viewport, Graphics2D g2d)
  {
    if (geom.getUserData() == null) return;
    
    Coordinate p = geom.getCentroid().getCoordinate();
    Point2D vp = viewport.toView(new Point2D.Double(p.x, p.y));
    
    g2d.setColor(color);
    g2d.setFont(AppConstants.FONT_LABEL);
    
    String label = geom.getUserData().toString();
    //int stringLen = (int) g2d.getFontMetrics().getStringBounds(label, g2d).getWidth();
    GraphicsUtil.drawStringAlignCenter(g2d, label, (int) vp.getX(), (int) vp.getY()); 
  }
  
  public Color getColor() {
    return color;
  }



}