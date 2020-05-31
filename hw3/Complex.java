package hw3;

public class Complex {
	private float real;
	private float image;

	public Complex() {
		
	}
	
	public Complex(float real, float image) {
		super();
		this.real = real;
		this.image = image;
	}
	

	public float getReal() {
		return real;
	}

	public void setReal(float real) {
		this.real = real;
	}

	public float getImage() {
		return image;
	}

	public void setImage(float image) {
		this.image = image;
	}

	//cong voi so phuc c
	public Complex add(Complex c) {
		Complex add = new Complex();
		add.real = real + c.real;
		add.image = image + c.image;
		return c;
	}
	//tru cho so phuc c
	public Complex minus(Complex c) {
		Complex minus = new Complex();
		minus.real = real - c.real;
		minus.image = image - c.image;
		return minus;
		
	}
	//nhan so phuc voi so phuc c
	public Complex time(Complex c) {
		Complex time = new Complex();
		time.real = real*c.real + image*c.image;
		time.image = real*c.image + image*c.real;
		return time;
		
	}
	public float realpart() {
		return real;
		
	}
	public float imagepart() {
		return image;
		
	}
	@Override
	public String toString() {
		return real +"+"+ image + "*i";
	}
}
