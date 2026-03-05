package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {

private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

// constructor
public IrregularPolygon() {}

// Add a point to the polygon
public void add(Point2D.Double aPoint)
{
myPolygon.add(aPoint);
}

// Calculate the perimeter of the polygon
public double perimeter() {
double perimeter = 0.0;

if (myPolygon.size() < 2) {
return 0.0;
}