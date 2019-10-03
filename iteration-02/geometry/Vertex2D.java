package cz.muni.fi.pb162.project.geometry;

/**
 * @author Michal Drobnak
 */
public class Vertex2D {
    private double x;
    private double y;

    public Vertex2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     *
     * @return Info about vertex
     */
    @Override
    public String toString(){
        return "[" + x + ", " + y + "]";
    }

    /**
     *
     * @param otherVertex Vertex with new coordinates
     * @return Point in the middle of two vertexes
     */
    public Vertex2D createMiddle(Vertex2D otherVertex){
        double middleX = (this.x + otherVertex.x)/2;
        double middleY = (this.y + otherVertex.y)/2;

        return new Vertex2D(middleX, middleY);
    }
}
