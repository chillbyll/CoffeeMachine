package cz.muni.fi.pb162.project.geometry;

/**
 * Represents a triangle
 *
 * @author Michal Drobnak
 */
public class Triangle {
    private final Vertex2D a;
    private final Vertex2D b;
    private final Vertex2D c;
    private final Triangle[] divided = new Triangle[3];
    private static final double ACCURACY = 0.001;


    /**
     * Constructor for a Triangle class
     *
     * @param a vertex object
     * @param b vertex object
     * @param c vertex object
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Overloaded constructor with depth parameter
     *
     * @param a vertex object
     * @param b vertex object
     * @param c vertex object
     * @param depth of division of a triangle
     */
    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c, int depth){
        this(a, b, c);
        this.divide(depth);
    }

    /**
     * Returns a vertex with a given index
     *
     * @param index of a vertex
     * @return vertex of a triangle
     */
    public Vertex2D getVertex(int index){
        switch(index){
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
            default:
                return null;
        }
    }

    @Override
    public String toString(){
        String coordinatesA = "["+ a.getX() + ", "+ a.getY() +"]";
        String coordinatesB = "["+ b.getX() + ", "+ b.getY() +"]";
        String coordinatesC = "["+ c.getX() + ", "+ c.getY() +"]";

        return "Triangle: vertices=" + coordinatesA + " " + coordinatesB + " " + coordinatesC;
    }

    /**
     * Returns true if triangle is divided else returns false
     *
     * @return boolean value
     */
    public boolean isDivided(){
        return divided[0] != null;
    }

    /**
     * Returns a sub triangle of a bigger triangle
     *
     * @param index of sub triangle
     * @return Triangle object
     */
    public Triangle getSubTriangle(int index){
        if(index < 0 || index > 2){
            return null;
        }
        return divided[index];
    }

    /**
     * Divides triangle into 3 smaller triangles and returns true
     *
     * @return boolean value
     */
    public boolean divide(){
        if(this.isDivided()){
            return false;
        }

        divided[0] = new Triangle(a, a.createMiddle(b), a.createMiddle(c));
        divided[1] = new Triangle(b, b.createMiddle(a), b.createMiddle(c));
        divided[2] = new Triangle(c, c.createMiddle(a), c.createMiddle(b));

        return true;
    }

    /**
     * Returns true if triangle is equilateral
     *
     * @return boolean value
     */
    public boolean isEquilateral(){
        double d1 = a.distance(b);
        double d2 = b.distance(c);
        double d3 = c.distance(a);
        return Math.abs(d1 - d2) < ACCURACY && Math.abs(d2 - d3) < ACCURACY;
    }

    /**
     * Divides triangle into smaller triangles
     *
     * @param depth of division of triangle
     */

    public void divide(int depth){
        if (depth <= 0){
            return;
        }
        depth--;
        if (!this.isDivided()) {
            this.divide();
        }
        for(int i = 0; i < divided.length ; i++){
            divided[i].divide(depth);
        }
    }
}

