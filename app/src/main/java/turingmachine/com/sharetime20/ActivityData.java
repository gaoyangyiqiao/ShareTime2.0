package turingmachine.com.sharetime20;

import java.util.ArrayList;

import po.ActiviryPO;
import po.ActivityDetailPO;

/**
 * Created by hello on 2015/4/24.
 */
public class ActivityData {
    private ActiviryPO activiryPO;
    private int length;
    private String content;
    //以下的坐标反应的是该活动在表格里的位置,从1开始编号
    private int startx;
    private int starty;
    private int scoorx;
    private int scoory;
    private int ecoorx;
    private int ecoory;
    public int getScoorx(){
        return scoorx;
    }
    public int getScoory(){
        return scoory;
    }
    public int getEcoorx(){
        return ecoorx;
    }
    public int getEcoory(){
        return ecoory;
    }
    public void setScoorx(int x){
        scoorx=x;
    }
    public void setScoory(int x){
        scoory=x;
    }
    public void setEcoorx(int x){
        ecoorx=x;
    }
    public void setEcoory(int x){
        ecoory=x;
    }


    public int getStartx() {
        return startx;
    }

    public void setStartx(int startx) {
        this.startx = startx;
    }
    public int getStarty(){
        return starty;
    }

    private int endx;
    private int endy;
    public int getEndx(){
        return endx;
    }
    public int getEndy(){
        return endy;
    }
    public ActivityData(ActiviryPO activityPO,int length){
        this.activiryPO=activityPO;
        this.length=0;
    }
    public String getContent(){

       String result=activiryPO.getContent();

        return result;
    }

}
