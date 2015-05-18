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
            int whichWeek1=Integer.parseInt(tem.getWhichWeek().split("-")[0]);
            int whichWeek2=Integer.parseInt(tem.getWhichWeek().split("-")[1]);
            int whichDay1=Integer.parseInt(tem.getWhichDay().split("-")[0]);
            int whichDay2=Integer.parseInt(tem.getWhichDay().split("-")[1]);
            int section1=Integer.parseInt(tem.getSection().split("-")[0]);
            int section2=Integer.parseInt(tem.getSection().split("-")[1]);
            if(weekIndex>=whichWeek1&&weekIndex<=whichWeek2&&whichDayIndex>=whichDay1&&whichDayIndex<=whichDay2&&classIndex>=section1&&classIndex<=section2){
                return tem.toString();
            }
        }
        return null;
    }

}
