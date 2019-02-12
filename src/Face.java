public class Face {
    double xPosition;
    double yPosition;

    public Face(double x, double y){
        xPosition = x;
        yPosition = y;
    }

    public void draw() {
        Ellipse topPetal = new Ellipse(xPosition, yPosition, 100, 100);
        topPetal.setColor(Color.BLACK);
        topPetal.draw();
        Ellipse leftPetal = new Ellipse(xPosition + 15, yPosition + 25, 20, 20);
        leftPetal.setColor(Color.BLACK);
        leftPetal.draw();
        leftPetal.fill();
        Ellipse center = new Ellipse(xPosition + 65, yPosition + 25, 20, 20);
        center.setColor(Color.BLACK);
        center.draw();
        center.fill();
        Line stem = new Line(xPosition + 25, yPosition + 75, xPosition + 75, yPosition + 75);
        stem.setColor(Color.BLACK);
        stem.draw();
    }

}
