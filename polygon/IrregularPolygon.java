package polygon;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

public class IrregularPolygon {
private ArrayList<Point2D.Double> pointsList;

public IrregularPolygon() {
pointsList = new ArrayList<Point2D.Double>();
}

public void add(Point2D.Double newPoint) {
pointsList.add(newPoint);
}

public double perimeter() {
if (pointsList.size() < 2) {
return 0.0;
}

double totalPerimeter = 0.0;

for (int i = 0; i < pointsList.size(); i++) {
Point2D.Double currentPoint = pointsList.get(i);
Point2D.Double nextPoint = pointsList.get((i + 1) % pointsList.size());
totalPerimeter += currentPoint.distance(nextPoint);
}

return totalPerimeter;
}

public double area() {
if (pointsList.size() < 3) {
return 0.0;
}

double calculationSum = 0.0;

for (int i = 0; i < pointsList.size(); i++) {
Point2D.Double pointA = pointsList.get(i);
Point2D.Double pointB = pointsList.get((i + 1) % pointsList.size());
calculationSum = calculationSum + (pointA.getX() * pointB.getY() - pointA.getY() * pointB.getX());
}

return Math.abs(calculationSum / 2.0);
}

public void draw()
{
if (pointsList.size() < 2) {
return;
}

try {
DrawingTool pen = new DrawingTool(new SketchPad(500, 500));

Point2D.Double startPoint = pointsList.get(0);

pen.up();
pen.move(startPoint.getX(), startPoint.getY());
pen.down();

for (int i = 1; i < pointsList.size(); i++) {
Point2D.Double nextDrawPoint = pointsList.get(i);
pen.move(nextDrawPoint.getX(), nextDrawPoint.getY());
}

pen.move(startPoint.getX(), startPoint.getY());

} catch (java.awt.HeadlessException error) {
System.out.println("Exception: No graphics support available.");
}
}
}
