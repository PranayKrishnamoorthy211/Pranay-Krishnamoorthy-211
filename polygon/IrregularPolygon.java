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

for (int i = 0; i < myPolygon.size(); i++) {
Point2D.Double current = myPolygon.get(i);
Point2D.Double next;

// If last point, connect back to first
if (i == myPolygon.size() - 1) {
next = myPolygon.get(0);
} else {
next = myPolygon.get(i + 1);
}

double dx = next.x - current.x;
double dy = next.y - current.y;

perimeter += Math.sqrt(dx * dx + dy * dy);
}


return perimeter;
}

// Calculate the area using the Shoelace Formula
public double area() {
double area = 0.0;

if (myPolygon.size() < 3) {
return 0.0;
}

for (int i = 0; i < myPolygon.size(); i++) {
Point2D.Double current = myPolygon.get(i);
Point2D.Double next;

// Wrap around to first point
if (i == myPolygon.size() - 1) {
next = myPolygon.get(0);
} else {
next = myPolygon.get(i + 1);
}
