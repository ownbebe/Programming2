/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module6;

import java.util.ArrayList;

/**
 *
 * @author owens
 */
public class NameComparator extends Roll{
    public static void NameCompare(ArrayList<Student> students){
        int i;
        int j;
        int indexSmallest;
        Student temp;
        
        for(i = 0; i < getClassRoll().size() - 1; i++){
            
            indexSmallest = i;
            for(j = i; j < getClassRoll().size(); j++){
                if(getClassRoll().get(j).getName().compareTo(getClassRoll().get(indexSmallest).getName()) < 0){
                    indexSmallest = j;
                }
            }
            
            temp = getClassRoll().get(indexSmallest);
            getClassRoll().set(indexSmallest, getClassRoll().get(i));
            getClassRoll().set(i, temp);
        }
    }
}
