
package polygon;

import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

public class IrregularPolygon {
    private ArrayList<ArrayList<Point2D.Double>> shapes;
    private SketchPad pad;
    private DrawingTool pen;

    public IrregularPolygon() {
        shapes = new ArrayList<ArrayList<Point2D.Double>>();
        shapes.add(new ArrayList<Point2D.Double>());
        
        // Initialize the drawing window once
        pad = new SketchPad(500, 500);
        pen = new DrawingTool(pad);
    }

    public void add(Point2D.Double newPoint) {
        shapes.get(0).add(newPoint);
    }

    public void addSmileyFace() {
        ArrayList<Point2D.Double> rEye = new ArrayList<Point2D.Double>();
        rEye.add(new Point2D.Double(20, 40));
        rEye.add(new Point2D.Double(30, 40));
        rEye.add(new Point2D.Double(25, 50));
        shapes.add(rEye);

        ArrayList<Point2D.Double> lEye = new ArrayList<Point2D.Double>();
        lEye.add(new Point2D.Double(-20, 40));
        lEye.add(new Point2D.Double(-30, 40));
        lEye.add(new Point2D.Double(-25, 50));
        shapes.add(lEye);

        ArrayList<Point2D.Double> mouth = new ArrayList<Point2D.Double>();
        mouth.add(new Point2D.Double(-30, 10));
        mouth.add(new Point2D.Double(0, -10));
        mouth.add(new Point2D.Double(30, 10));
        shapes.add(mouth);
    }

    public void draw() {
        for (int i = 0; i < shapes.size(); i++) {
            ArrayList<Point2D.Double> current = shapes.get(i);
            
            if (current.size() > 0) {
                Point2D.Double first = current.get(0);
                pen.up();
                pen.move(first.getX(), first.getY());
                pen.down();

                for (int j = 1; j < current.size(); j++) {
                    Point2D.Double pt = current.get(j);
                    pen.move(pt.getX(), pt.getY());
                }

                pen.move(first.getX(), first.getY());
            }
        }
    }

    public double perimeter() {
        ArrayList<Point2D.Double> pts = shapes.get(0);
        if (pts.size() < 2) return 0.0;
        double total = 0.0;
        for (int i = 0; i < pts.size(); i++) {
            total += pts.get(i).distance(pts.get((i + 1) % pts.size()));
        }
        return total;
    }

    public double area() {
        ArrayList<Point2D.Double> pts = shapes.get(0);
        if (pts.size() < 3) return 0.0;
        double sum = 0.0;
        for (int i = 0; i < pts.size(); i++) {
            sum += (pts.get(i).getX() * pts.get((i + 1) % pts.size()).getY() - 
                    pts.get(i).getY() * pts.get((i + 1) % pts.size()).getX());
        }
        return Math.abs(sum / 2.0);
    }
}