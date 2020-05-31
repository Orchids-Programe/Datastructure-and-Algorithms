package hw3;

public class Circle extends Shape {
	@SuppressWarnings("unused")
	private double radius = 0;
	public Circle(double radius) {
		this.radius = radius;
		
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	protected double getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		double S = Math.PI*Math.pow(radius, 2);
		return S;
	}
	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		double P = 2*Math.PI*Math.pow(radius, 1);
		return P;
	}
	public static void main(String[] args) {
		Circle s1 = new Circle(8);
		System.out.println("Chu vi hinh tron la : ");
		System.out.println(s1.getPerimeter());
	}
	
}
