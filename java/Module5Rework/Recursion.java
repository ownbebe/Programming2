/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module5Rework;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author owens
 */
public class Recursion {
    private static ArrayList<Float> array = new ArrayList<Float>();
    private static float answer = 0;
    private static int length;

  
	
    public static void input() {
	Scanner scan = new Scanner(System.in);
	float input;
        boolean flag = true;
        
        while(flag == true){
            System.out.println("How many numbers would you like to add: ");
            length = scan.nextInt();
            scan.nextLine();
            if(length > 0){
                for(int i = 0; i < length; i++) {
                    System.out.println("Enter a number: ");
                    input = scan.nextFloat();
                    array.add(i, input);
                }
                break;
            }
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
    }
      
    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Recursion.length = length;
    }
	
    public static float recursiveMethod(int n) {
	if (n < 0) {
            return answer;
	}
		
	else {
            answer += array.get(n);
            recursiveMethod(n-1);
            }
	return answer; 	
	}

	public static float getAnswer() {
		return answer;
	}

	public static void setAnswer(float answer) {
		Recursion.answer = answer;
	}
}
