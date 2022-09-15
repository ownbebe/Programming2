/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module6;

import static Module6.NameComparator.NameCompare;
import static Module6.RollNoComparator.compare;
import java.util.ArrayList;
import java.util.Scanner;

/* Owen Schneider
Storing and ArrayList: CSC 372-CTA6
Project Purpose: Sort an ArrayList using a selection sort method
Program inputs: None
Program outputs: Unsorted ArrayList, sorted by RollNo, sorted by name
Program Limtations: None that I am aware of.
Program errors: None that I am aware of.

 */
public class Roll{
    private static ArrayList<Student> classRoll;
    
    public static void list(){
        for(int j = 0; j < classRoll.size(); j++) {
            System.out.println("Student " + String.valueOf(j + 1));
            System.out.println("Roll number: " + String.valueOf(classRoll.get(j).getRollNo()));
            System.out.println("Student: " + classRoll.get(j).getName());
            System.out.println("Address: " + classRoll.get(j).getAddress());
            System.out.println("");
	}
    }
    
    public static void generatedList(){
        Student s1 = new Student(7, "John", "123 23rd St");
	Student s2 = new Student(9, "Bill", "123 23rd St");
	Student s3 = new Student(10, "Suzy", "123 23rd St");
	Student s4 = new Student(2, "Sam", "123 23rd St");
	Student s5 = new Student(1, "Will", "123 23rd St");
	Student s6 = new Student(3, "Kenzie", "123 23rd St");
	Student s7 = new Student(8, "Shelby", "123 23rd St");
	Student s8 = new Student(6, "Owen", "123 23rd St");
	Student s9 = new Student(4, "Paul", "123 23rd St");
	Student s10 = new Student(5, "Riley", "123 23rd St");
        
        classRoll.add(0, s1);
	classRoll.add(1, s2);
	classRoll.add(2, s3);
	classRoll.add(3, s4);
	classRoll.add(4, s5);
	classRoll.add(5, s6);
	classRoll.add(6, s7);
	classRoll.add(7, s8);
	classRoll.add(8, s9);
	classRoll.add(9, s10);
    }
    
    public static void main(String[] args){
        classRoll = new ArrayList<Student>();
        Scanner scan = new Scanner(System.in);
        int choice;
        int num;
        
        
        System.out.println("Would you like to generate your own list of students?");
        System.out.println("Enter 1 for custom lsit, 2 for pregenerated list: ");
        choice = scan.nextInt();
        scan.nextLine();
        
        while(true){
            if(choice == 1){
                System.out.println("How many students do you have: ");
                num = scan.nextInt();
                scan.nextLine();
                for(int i = 0; i < num; i++){
                    System.out.println("Enter roll number: ");
                    int rollNo = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter student name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter  student address: ");
                    String address = scan.nextLine();
                
                    Student temp = new Student(rollNo, name, address);
                    classRoll.add(temp);
                }
            
                list();
                compare(classRoll);
                System.out.println("Sorted by roll number.");
                System.out.println("----------------------");
                System.out.println("");
        
                list();
        
                NameCompare(classRoll);
                System.out.println("Sorted by name.");
                System.out.println("----------------------");
                System.out.println("");
        
                list();
            
                break;
            }
        
            else if(choice == 2){
                generatedList();
                list();
                compare(classRoll);
                System.out.println("Sorted by roll number.");
                System.out.println("----------------------");
                System.out.println("");
        
                list();
        
                NameCompare(classRoll);
                System.out.println("Sorted by name.");
                System.out.println("----------------------");
                System.out.println("");
        
                list();
            
                break;
            }
            else{
                System.out.println("Invalid input try again.");
            }
        }
    }

    public static ArrayList<Student> getClassRoll() {
        return classRoll;
    }

    public static void setClassRoll(ArrayList<Student> classRoll) {
        Roll.classRoll = classRoll;
    }
}
