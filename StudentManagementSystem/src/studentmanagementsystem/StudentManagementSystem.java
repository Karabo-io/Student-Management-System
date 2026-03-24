/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementsystem;

import java.util.Scanner;

import Exceptions.AgeException;
import Exceptions.AgeValidatorException;

/**
 *
 * @author Karabo
 */
public class StudentManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
  
        //Instantiate an array object
        StudentManager manager = new StudentManager();
        
        int choice; // Declaring a data type for the user's input
        do {  
            System.out.println("");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            
            System.out.print("Enter your choice: ");
            
         while (!scan.hasNextInt()){
            System.out.println("Invalid input! Enter a number between 1 and 6.");
            scan.next(); //Clear invalid input
        }
         
         choice = scan.nextInt();
         scan.nextLine();
        
            switch (choice) {
                case 1:   //Adding a student
                {
                    int age = 0;
                    
                         System.out.print("Enter Student ID: ");
                         String studentID = scan.nextLine();
                        
                         System.out.print("Enter Name: ");  
                         String name = scan.nextLine();
                       //Catch age exception and repeat the process until a valid age requirement is entered  
                       do {                       
                        try {                         
                            System.out.print("Enter Age: ");
                            age = scan.nextInt();
                            AgeValidatorException.validateAge(age);
                    
                        } catch (AgeException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        
                        if(age >= 17 && age <=45){
                            Student student = new Student(studentID, name, age);
                            manager.addStudent(student);
                            System.out.println("Student added successfully!");
                        }        
                        
                    } while (age < 17 || age > 45);
                }
                    break;
                
                case 2://Displaying students
                {
                    manager.displayStudents();
                } 
                    break;
                    
                case 3://Search
                {   
                    System.out.print("Enter Student ID: ");
                    String studentID = scan.nextLine();
                        
                    Student found = manager.searchStudent(studentID);
                    if(found != null){
                        System.out.println("Student found: \n" + found);
                    }else{
                        System.out.println("Student not found!");
                    }
                        
                }
                    break;
                    
                case 4://Remove
                {
                    System.out.print("Enter student ID: ");
                    String studentID = scan.nextLine();
                    
                    if(manager.removeStudent(studentID)){
                       System.out.println("Student removed successfully."); 
                    }else{
                        System.out.println("Student not found!");
                    }  
                    
                }break;
                
                case 5://Updating
                {
                    System.out.print("Enter Student ID to  update: ");
                    String ID = scan.nextLine();
                    
                    System.out.print("Enter new name: ");
                    String ename = scan.nextLine();
                    
                    System.out.print("Enter new age: ");
                    int eage = scan.nextInt();
                    scan.nextLine();
                    
                    if(manager.updateStudent(ID, ename, eage)){
                        System.out.println("Student updated successfully.");
                    }else{
                        System.out.println("Student not found!");
                    }
                }
                    
                default:
                    
            }
        }while(choice != 6);
        
        scan.close();//close the scannner
   }
}
