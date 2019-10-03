package cz.muni.fi.pb162.project.geometry;

public class Triangle {
    private Vertex2D a;
    private Vertex2D b;
    private Vertex2D c;
    private Triangle[] divided = new Triangle[3];

    public Triangle(Vertex2D a, Vertex2D b, Vertex2D c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

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

    public void setVertex(int index, Vertex2D vertex){
        switch(index){
            case 0:
                a.setX(vertex.getX());
                a.setY(vertex.getY());
                break;
            case 1:
                b.setX(vertex.getX());
                b.setY(vertex.getY());
                break;
            case 2:
                c.setX(vertex.getX());
                c.setY(vertex.getY());
                break;
        }
    }

    public String toString(){
        String coordinatesA = "["+ a.getX() + ", "+ a.getY() +"]";
        String coordinatesB = "["+ b.getX() + ", "+ b.getY() +"]";
        String coordinatesC = "["+ c.getX() + ", "+ c.getY() +"]";

        return "Triangle: vertices=" + coordinatesA + " " + coordinatesB + " " + coordinatesC;
    }

    public boolean isDivided(){
        return divided == null;
    }

    public Triangle getSubTriangle(int index){
        if(index < 0 || index > 2) return null;
        return divided[index];
    }

    public boolean divide(){
        if(this.isDivided()){
            return false;
        }

        divided[0] = new Triangle(a, a.createMiddle(b), a.createMiddle(c));
        divided[1] = new Triangle(b, b.createMiddle(a), b.createMiddle(c));
        divided[2] = new Triangle(c, c.createMiddle(a), c.createMiddle(b));

        return true;
    }
}
