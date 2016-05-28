package com.mathlabs.drawing;

import com.mathlabs.graphs.Graph;
import com.mathlabs.graphs.Point;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphicsapp.GraphicsWindow;

public class Canvas {
    private int width, height;
    private GraphicsWindow app;

    private Point topLeft, bottomRight;

    public static double STEP_SIZE = 0.1;

    public Canvas(int width, int height, Point topLeft, Point bottomRight) {
        this.width = width;
        this.height = height;

        this.app = new GraphicsWindow(width, height);

        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public void draw(Graph g, String color) {
        double left = this.topLeft.getX(),
                right = this.bottomRight.getX(),
                top = this.topLeft.getY(),
                bottom = this.bottomRight.getY();

        double distanceX = right - left,
                distanceY = top - bottom;

        double centerX = this.width / 2,
                centerY = this.height / 2;

        Point[] points = g.toPoints(left, right, Canvas.STEP_SIZE);

        for (Point p : points) {
            double x = p.getX() / distanceX * centerX + centerX,
                    y = this.height - (p.getY() / distanceY * centerY + centerY);

            Rect pixel = new Rect((int)x, (int)y, 1, 1, this.getColorFromString(color));
            pixel.setBorderWeight(0);

            this.app.addObjectToDraw(pixel);
        }

        this.app.display();
    }

    public void setBackground(String color) {
        Color c = this.getColorFromString(color);

        Rect bg = new Rect(0, 0, this.width, this.height, c);
        bg.setBorderWeight(0);

        app.addObjectToDraw(bg);
    }

    private Color getColorFromString(String color) {
        switch (color) {
            case "red":
                return Color.RED;

            case "green":
                return Color.GREEN;

            case "blue":
                return Color.BLUE;

            case "white":
                return Color.WHITE;

            default:
                return Color.BLACK;
        }
    }
}