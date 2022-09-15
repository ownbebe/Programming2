/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module8;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
/**Owen Schneider
Portfolio Project Option 1: CSC372-Portfolio Project
* Project purpose: Implement a LinkedList that stores student data. This list will be sorted and saved to a file
* Program inputs: Choice, student name, student address, student GPA
* Program outputs: studentList LinkedList
* Program limitations: Sorting can always be made more efficient
* Program errors: None that I am aware of
 */
public class studentDriver extends Student{
    private static LinkedList <Student> studentList = new LinkedList<>();
    
    public static void addStudents(){
        Scanner scan = new Scanner(System.in);
        int numStudents;
        int choice;
        boolean flag = true;
        double GPA;
        
        while(flag == true){
            System.out.println("How many students would you like to add to your list: ");
            numStudents = scan.nextInt();
            scan.nextLine();
            
            
            if(numStudents > 0){
                for(int i = 0; i < numStudents; i++){
                    System.out.println("Enter student name: ");
                    String name = scan.nextLine();
                    
                    System.out.println("Enter student address: ");
                    String address = scan.nextLine();
                    
                    while(true){
                        System.out.println("Enter student GPA: ");
                        GPA = scan.nextDouble();
                        scan.nextLine();
                        if(GPA > 0 && GPA < 5){
                       
                            break;
                        }
                        else{
                            System.out.println("Invalid student GPA, try again.");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    
                    Student temp = new Student(name, address, GPA);
                    studentList.add(temp);
                }
                System.out.println("Your students have been added.");
                flag = false;
            }
            
            else{
                while(true){
                    System.out.println("Are you sure you do not want to enter any students?");
                    System.out.println("Enter 1 to enter students, 2 to not enter students: ");
                    choice = scan.nextInt();
                
                    if(choice == 1){
                        flag = true;
                        break;
                    }
                
                    else if(choice == 2){
                        System.out.println("No students added.");
                        flag = false;
                        break;
                    }
                    else{
                        System.out.println("Invalid input, try again.");
                    }
                }  
            }
        }
    }
    
    public static void removeStudents(){
        Scanner scan = new Scanner(System.in);
        int remove;
        int choice;
        boolean flag = true;
        while(flag){
            System.out.println("Listing options of students to remove.");
            list();
            System.out.println("Enter the student to remove.");
            System.out.println("Which number is given to the student in the list: ");
            remove = scan.nextInt();
            scan.nextLine();
            if(remove > studentList.size() + 1 || remove <= 0 || studentList.size() <= 0){
                System.out.println("Invalid input, try again.");
            }
            else{
                studentList.remove(remove - 1);
                System.out.println("Student number " + remove + " has been removed");
                list();
            }
            System.out.println("Would you like to remove another student?");
            System.out.println("Enter \"1\" for yes and \"2\" for no: ");
            choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice){
                case 1:{
                    System.out.println("Restarting method.");
                    
                    break;
                }
                    
                case 2:{
                    System.out.println("All selected students removed successfully.");
                    flag = false;
                    
                    break;
                }
                        
                default:
                    System.out.println("Invalid input, try again.");
            }
        }
    }
    
    public static void nameCompare(){
        int i;
        int j;
        int indexSmallest;
        Student temp;
        
        for(i = 0; i < studentList.size() - 1; i++){
            
            indexSmallest = i;
            for(j = i; j < studentList.size(); j++){
                if(studentList.get(j).getName().compareTo(studentList.get(indexSmallest).getName()) < 0){
                    indexSmallest = j;
                }
            }
            
            temp = studentList.get(indexSmallest);
            studentList.set(indexSmallest, studentList.get(i));
            studentList.set(i, temp);
        }
    }
    
        
    
    public static void list(){
        for(int j = 0; j < studentList.size(); j++) {
            System.out.println("Student " + String.valueOf(j + 1));
            System.out.println("--------------");
            System.out.println("Student: " + studentList.get(j).getName());
            System.out.println("Address: " + studentList.get(j).getAddress());
            System.out.println("GPA: " + String.valueOf(studentList.get(j).getGPA()));
            System.out.println("");
	}
    }
    
    public static void menu(){
        System.out.println("Options");
        System.out.println("-----------------------------");
        System.out.println("1. Add students");
        System.out.println("2. Remove students");
        System.out.println("3. View students");
        System.out.println("4. Exit");
    }
    
    public static boolean saveInventory(){
	try {
            File path = new File("StudentList.txt");
            if(path.createNewFile()){
                FileWriter writer = new FileWriter(path);
                for(int i = 0; i < studentList.size(); i++) {
                    writer.write("Student " + String.valueOf(i + 1) + "\n");
                    writer.write("---------------\n");
                    writer.write("Name: " + studentList.get(i).getName() + "\n");
                    writer.write("Address: " + studentList.get(i).getAddress() + "\n");
                    writer.write("GPA: " + String.valueOf(studentList.get(i).getGPA()) + "\n");
                    writer.write("\n");
                }
            writer.close();
            return true;
            }
            else{
                FileWriter writer = new FileWriter(path);
                for(int i = 0; i < studentList.size(); i++) {
                    writer.write("Student " + String.valueOf(i + 1) + "\n");
                    writer.write("---------------\n");
                    writer.write("Name: " + studentList.get(i).getName() + "\n");
                    writer.write("Address: " + studentList.get(i).getAddress() + "\n");
                    writer.write("GPA: " + String.valueOf(studentList.get(i).getGPA()) + "\n");
                    writer.write("\n");
                }
            writer.close();
            return true;
            }	
	} 
        catch (IOException e) {
            return false;
	}	
    }
    
    public static void main(String[] args){
        int choice;
        int choice2;
        boolean flag = true;
        boolean result;
        
        studentList = new LinkedList<Student>();
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the studnet inventory system");
        while(flag){
        menu();
        System.out.println("Which option would you like to do, enter a number: ");
        choice = scan.nextInt();
        scan.nextLine();
        
            switch(choice){
            case 1:{
                addStudents();
                nameCompare();
                
                break;
            }
                
            case 2:{
                list();
                removeStudents();
                
                break;
            }
                
            case 3:{
                if(studentList.size() <= 0){
                    System.out.println("The list is not big enough yet. Add students to view the list.");
                }
                else{
                    list();
                }
                
                break;
            }
                
            case 4:{
                System.out.println("Thank you for using the studnet inventory system.");
                flag = false;
                
                break;
            }
                
            
            default:
                System.out.println("Invalid input, try again.");
            }
            System.out.println("");
        }
        
        System.out.println("This list will be saved to a file named \"StudentsList\"");
        
        
        result = saveInventory();
        if (result) {
            System.out.println("Successfully saved to \"StudentsList.txt\"");
	}
			
	else {
            System.out.println("ERROR: did not save to \"StudentsList.txt\"");
	}      
    }
}
