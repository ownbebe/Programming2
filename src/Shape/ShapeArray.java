package Shape;
import java.util.ArrayList;

public class ShapeArray {
	public static void main(String[] args) {
		Shape sphere1 = new Sphere(4, "Sphere");
		Shape cylinder1 = new Cylinder(5, 4, "Cylinder");
		Shape cone1 = new Cone(8, 9, "Cone");
		
		sphere1.surfaceArea();
		sphere1.volume();
		
		cylinder1.surfaceArea();
		cylinder1.volume();
		
		cone1.surfaceArea();
		cone1.volume();
		
		ArrayList<Shape> shapeArray = new ArrayList<Shape>();
		
		shapeArray.add(sphere1);
		shapeArray.add(cylinder1);
		shapeArray.add(cone1);
		
		for(int i = 0; i < shapeArray.size(); i++) {
			System.out.println(shapeArray.get(i).toString());
		}
	}
}
