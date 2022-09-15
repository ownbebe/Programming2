/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module5Rework;

/**
 *
 * @author owens
 */
public class driverRecursion extends Recursion {
    public static void main(String[] args) {
		input();
		recursiveMethod(getLength() - 1);
		System.out.println("The sum of your numbers are: " + getAnswer());
	}
}
