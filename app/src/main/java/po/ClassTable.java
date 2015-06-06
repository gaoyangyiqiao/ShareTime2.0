package po;

import java.util.ArrayList;

/**
 * Created by hello on 2015/5/18.
 */
public class ClassTable implements  classPOInterface{
   private ArrayList<ClassPO> list;
    private int length;
    static private ClassTable classTable=new ClassTable();
    public static ClassTable getClassTable(){
        return  classTable;
    }
    private ClassTable(){

    }
    public String getClass(int weekIndex,int whichDayIndex,int classIndex){
        for(int i=0;i<length;i++){
            ClassPO tem=list.get(i);


        }
        return null;
    }

}
