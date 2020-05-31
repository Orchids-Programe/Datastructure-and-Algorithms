package hw3;

import java.util.ArrayList;

public class ShapeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		shapeArray.add(new Circle(2));
		shapeArray.add(new Retangle(3, 6));
		shapeArray.add(new Sphere(1, 2, 3, 4));
		shapeArray.add(new Circle(1));
		
		for(Shape x : shapeArray) {
			x.setName(x.getClass().getSimpleName());
			System.out.println(x.toString());
		}
		
		System.out.println();
		for(Shape x : shapeArray) {
			System.out.println("Area : "+x.getArea()+"\n"+"Perimeter : "+x.getPerimeter()+"\n"+"Volume : "+x.getVolume());
		}
	}

}
