package hw3;

public class Sphere extends Shape {
	private double radius;
	private double x;
	private double y;
	private double z;
	
	
	public Sphere(double radius, double x, double y, double z) {
		super();
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	protected double getVolume() {
		// TODO Auto-generated method stub
		double V = (4*Math.PI*Math.pow(radius, 3))/3;
		return V;
	}
	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		double S = 4*Math.PI*Math.pow(radius, 2);
		return S;
	}
	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		double P = Math.PI*Math.pow(radius, 2);
		return P;
	}
	public static void main(String[] args) {
		Sphere s1 = new Sphere(1,2,3,4);
		System.out.println("The tich hinh cau la : ");
		System.out.println(s1.getVolume());
	}
}
