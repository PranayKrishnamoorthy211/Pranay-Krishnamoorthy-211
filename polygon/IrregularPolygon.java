package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList;
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {

private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

// constructor
public IrregularPolygon() {}

// Add a point to the polygon
public void add(Point2D.Double aPoint) {
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

if (i == myPolygon.size() - 1) {
next = myPolygon.get(0);
} else {
next = myPolygon.get(i + 1);
}

perimeter += current.distance(next);
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

if (i == myPolygon.size() - 1) {
next = myPolygon.get(0);
} else {
next = myPolygon.get(i + 1);
}

area += (current.getX() * next.getY()) -
(current.getY() * next.getX());
}

area = Math.abs(area) / 2.0;

return area;
}

// Draw the polygon
public void draw() {
try {

if (myPolygon.size() < 2) {
return;
}

DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));

Point2D.Double first = myPolygon.get(0);

myDrawingTool.up();
myDrawingTool.move(first.getX(), first.getY());
myDrawingTool.down();

for (int i = 1; i < myPolygon.size(); i++) {
Point2D.Double point = myPolygon.get(i);
myDrawingTool.move(point.getX(), point.getY());
}

myDrawingTool.move(first.getX(), first.getY());

} catch (java.awt.HeadlessException e) {
System.out.println("Exception: No graphics support available.");
}
}
}
