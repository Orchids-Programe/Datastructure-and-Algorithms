package hw3;

public class Retangle extends Shape{
	private double width;
	private double height;
	public Retangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	protected double getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected double getArea() {
		// TODO Auto-generated method stub
		double S = width*height;
		return S;
	}
	@Override
	protected double getPerimeter() {
		// TODO Auto-generated method stub
		double P = (width+height)*2;
		return P;
	}
	public static void main(String[] args) {
		Retangle s1 = new Retangle(4, 3);
		System.out.println("Chu vi hinh chu nhat la : ");
		System.out.println(s1.getPerimeter());
	}
	
}
