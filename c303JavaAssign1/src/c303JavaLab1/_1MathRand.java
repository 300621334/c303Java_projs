package c303JavaLab1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.x500.X500Principal;
/*
 By:
 Shafiq-Ur-Rehman
 */

public class _1MathRand
{
	public static void main(String[] args)
	{
		double x = Math.random();
		List<Circle> circles = new ArrayList<Circle>();
		
		while (x >= 0.10)
		{
			Circle c = new Circle();
			c.setRadius(x);
			circles.add(c);
			x = Math.random();
		}
		
		int counter = 1;
		
		if (circles.isEmpty()) 
		{
			System.out.println("No circles exist in the list");
		}
		else 
		{
			for (Circle circle : circles) {
				System.out.printf("Circle_%02d has a radious of %s\n", counter, circle);
				++counter;
			} 
		}
		circles.clear();
		
	}
}

class Circle
{
	private double radius = 0.0;

	public double getRadius() {return radius;}

	public void setRadius(double radius) {this.radius = radius;}

	DecimalFormat df = new DecimalFormat("#.##"); //or "0.00"
	@Override
	public String toString()
	{
		return df.format(this.radius) + "";
	}
}
