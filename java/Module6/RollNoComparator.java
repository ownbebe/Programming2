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
public class RollNoComparator extends Roll{
    public static void compare(ArrayList<Student> students){
        int i;
        int j;
        int indexSmallest;
        Student temp;
        
        for(i = 0; i < getClassRoll().size() - 1; i++){
            
            indexSmallest = i;
            for(j = i; j < getClassRoll().size(); j++){
                if(getClassRoll().get(j).getRollNo() < getClassRoll().get(indexSmallest).getRollNo()){
                    indexSmallest = j;
                }
            }
            
            temp = getClassRoll().get(indexSmallest);
            getClassRoll().set(indexSmallest, getClassRoll().get(i));
            getClassRoll().set(i, temp);
        }
    }
}
