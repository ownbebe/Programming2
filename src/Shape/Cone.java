package Shape;

public class Cone extends Shape{
	private double radius;
	private double height;
	private double pi = 3.14;
	private double sa;
	private double vol;
	
	Cone(double radius, double height, String name){
		super(name);
		this.radius = radius;
		this.height = height;
	}
	@Override
	public double surfaceArea() {
		sa = pi * radius * height + pi * (radius * radius);
		return sa;
	}
	@Override
	public double volume() {
		vol = (pi * (radius * radius) * height)/ 3;
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
