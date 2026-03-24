/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;
/**
 *
 * @author Karabo
 */
public class AgeValidatorException {
    
    public static void validateAge(int age) {
        //Setting age to be from 17 years and above
        if(age < 17){
            throw new AgeException("Age must be older than 16 years, please try again!");
        }
        
        //Students should not be older than 45
        if(age > 45){
            throw new AgeException("Age must not be older 45 years!");
        }
    }
    
}
