// Learning overriding

import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;

    Coordinates(int x, int y) {
        this.x = x; this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //TODO 1 override toString() to return an informative string
    @Override
    public String toString(){
        System.out.println("Print out an informative string");
        return "This is a string";
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Coordinates))
            return false;

        Coordinates that = (Coordinates) o;
        return getX() == that.getX() && getY() == that.getY();
    }

    @Override public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public static void main(String[] args){
        Coordinates Coord1 = new Coordinates(4, 5);
        Coord1.toString();
    }
}
