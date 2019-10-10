package cz.muni.fi.pb162.project.geometry;

/**
 * Represents a circle
 *
 * @author Michal Drobnak
 */
public class Circle {
    private final Vertex2D center;
    private final double radius;

    /**
     * Constructor of a Circle class
     *
     * @param center of a circle
     * @param radius of a cricle
     */
    public Circle(Vertex2D center, double radius){
        this.center = center;
        this.radius = radius;
    }

    /**
     * Overloaded constructor without parameters
     */
    public Circle(){
        this(new Vertex2D(0.0, 0.0), 1.0);
    }

    public Vertex2D getCenter(){
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        str.append("Circle: center=[").append(center.getX());
        str.append(", ").append(center.getY());
        str.append("], radius=").append(radius);

        return str.toString();
    }
}
