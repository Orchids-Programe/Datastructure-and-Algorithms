package hw1;

public class hinhcau {
	private double r;
	private double x;
	private double y;
	private double z;

	public hinhcau(double r, double x, double y, double z) {
		super();
		this.r = r;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
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
	public double thetich()
	{
		double V = (4*Math.PI*Math.pow(r, 3))/3;
		return V;
	}
	public double dientich()
	{
		double S = 4*Math.PI*Math.pow(r, 2);
		return S;
	}
	public boolean baonhau(hinhcau s2)
	{
		double d = Math.sqrt((x-s2.x)*(x-s2.x)+(y-s2.y)*(y-s2.y)+(z-s2.z)*(z-s2.z));
		if(d < Math.abs(r - s2.r))
		{
			return true;
		}
		return false;
	}
	public boolean giaonhau(hinhcau s2)
	{
		double d = Math.sqrt((x-s2.x)*(x-s2.x)+(y-s2.y)*(y-s2.y)+(z-s2.z)*(z-s2.z));
		if(Math.abs(r - s2.r) < d && d < r + s2.r)
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		
		
		hinhcau s1 = new hinhcau(1, 2, 3, 4);
		hinhcau s2 = new hinhcau(5, 6, 7, 8);
		System.out.println(s1.thetich());
		System.out.println(s1.dientich());
		System.out.println(s1.baonhau(s2));
		System.out.println(s1.giaonhau(s2));

	}

}
