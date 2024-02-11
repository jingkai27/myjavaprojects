public abstract class abstractClass {
    private String colour;
    private boolean filled;

    abstractClass(){
        colour = "white"; filled = false;
    }

    abstractClass(String colour, boolean filled){
        this.colour = colour;
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColour() {
        return colour;
    }

    public boolean isFilled() {
        return filled;
    }
}
