package Shape;

public abstract class Shape{
	String name = " ";
	
	Shape(String name){
		this.name = name;
	}
	
	abstract double surfaceArea();
	
	abstract double volume();
	
}