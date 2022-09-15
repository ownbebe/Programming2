package Shape;

public class Sphere extends Shape {
	private double radius;
	private double sa;
	private double vol;
	double pi = 3.14;
	
	Sphere(double radius, String name){
		super(name);
		this.radius = radius;
	}
	@Override
	public double surfaceArea() {
		sa = 4* pi * (radius *radius);
		return sa;
	}
	@Override
	public double volume() {
		double pi = 3.14;
		vol = (4 * pi * (radius * radius *radius))/ 3;
		return vol;
	}
	
	@Override
	public String toString() {
		String strSA = String.valueOf(sa);
		String strVOL = String.valueOf(vol);
		System.out.println(this.name);
		System.out.println("Surface area: " +strSA);
		System.out.println("Volume: " + strVOL);
		
		return "";
	}
}
