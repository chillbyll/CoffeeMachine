package cz.muni.fi.pb162.project.geometry;

/**
 * Represents 2D Vertex
 *
 * @author Michal Drobnak
 */
public class Vertex2D {
    private final double x;
    private final double y;

    /**
     * Constructor of a Vertex2D class
     *
     * @param x coordinate
     * @param y coordinate
     */
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

    /**
     * Returns info about vertex
     *
     * @return String with vertex coordinates
     */
    @Override
    public String toString(){
        return "[" + x + ", " + y + "]";
    }

    /**
     * Creates a vertex in the middle of 2 vertexes
     *
     * @param otherVertex with new coordinates
     * @return Vertex2D object
     */
    public Vertex2D createMiddle(Vertex2D otherVertex){
        double middleX = (this.x + otherVertex.x)/2;
        double middleY = (this.y + otherVertex.y)/2;

        return new Vertex2D(middleX, middleY);
    }

    /**
     * Returns a distance between 2 vertexes
     *
     * @param vertex Vertex2D
     * @return double value
     */
    public double distance(Vertex2D vertex){
        if (vertex == null){
            return -1.0;
        }
        double xDist = Math.pow(vertex.getX() - this.x, 2);
        double yDist = Math.pow(vertex.getY() - this.y, 2);
        return Math.sqrt(xDist + yDist);
    }
}
