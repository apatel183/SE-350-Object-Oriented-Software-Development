package types.point6;
import java.awt.Color;
interface Colored {
  Color getColor();
}
interface Point {
  double getX();
  double getY();
}
final class CartesianPoint implements Colored, Point {
  
  private final double _x;
  private final double _y;
  private final Color _color; 
  public CartesianPoint(double x, double y, Color color) {
    _x = x;
    _y = y;
    _color = color;
  }
  public double getX() { return _x; }
  public double getY() { return _y; }
  public Color getColor() {
    System.out.println("It's Cartesian!");
    return _color;
  }
  
}
final class PolarPoint implements Colored, Point {
  
  private final double _theta;
  private final double _r;
  private final Color _color; 
  public PolarPoint(double theta, double r, Color color) {
    _theta = theta;
    _r = r;
    _color = color;
  }
  public double getX() { return _r*Math.cos(_theta); }
  public double getY() { return _r*Math.sin(_theta); }
  public Color getColor() {
    System.out.println("It's Polar!");
    return _color;
  }
  
}
class Main {
  private Main() {}
  public static <T extends Point & Colored> void printColoredPoint(T cp) {
    System.out.println(cp.getX());
    System.out.println(cp.getY());
    System.out.println(cp.getColor());
  }
  public static void main(String[] args) {
    printColoredPoint(new CartesianPoint(0,0,Color.RED));
    printColoredPoint(new PolarPoint(0,0,Color.RED));
  }
}
