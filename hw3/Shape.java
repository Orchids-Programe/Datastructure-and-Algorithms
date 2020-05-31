package hw3;

public abstract class Shape {
	protected String name;
	protected abstract double getVolume();
	protected abstract double getArea();
	protected abstract double getPerimeter();
	
	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	
}
