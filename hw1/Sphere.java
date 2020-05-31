package hw1;

public class Sphere {
	private double radian;
	private double x;
	private double y;
	private double z;
	public Sphere(double radian, double x, double y, double z) {
		super();
		this.radian = radian;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getRadian() {
		return radian;
	}
	public void setRadian(double radian) {
		this.radian = radian;
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
	public double capacity() {
		double V = (4*Math.PI*Math.pow(radian,3))/3;
		return V;
	}
	public double acreage() {
		double S = 4*Math.PI*Math.pow(radian,2);
		return S;
	}
	public boolean Baonhau(Sphere s2) {
		double d = Math.sqrt((x-s2.x)*(x-s2.x)+(y-s2.y)*(y-s2.y)+(z-s2.z)*(z-s2.z));
		if( d < Math.abs(radian - s2.radian)) {
			return true;
		}
		return false;
	}
	public boolean Giaonhau(Sphere s2) {
		double d = Math.sqrt((x-s2.x)*(x-s2.x)+(y-s2.y)*(y-s2.y)+(z-s2.z)*(z-s2.z));
		if(Math.abs(radian-s2.radian) < d  && d < radian + s2.radian )
			return true;
		return false;
	}
	public static void main(String[] args) {
		Sphere s1 = new Sphere(1, 2, 3, 4);
		Sphere s2 = new Sphere(5,6,7,8);
		System.out.println(s1.capacity());
		System.out.println(s2.acreage());
		System.out.println(s1.Baonhau(s2));
		System.out.println(s1.Giaonhau(s2));
	}
}

