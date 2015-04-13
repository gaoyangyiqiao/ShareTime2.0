package businesslogic.schedulebl;

/**
 * Created by hello on 2015/4/13.
 */
public class Activitybl {
    //新建活动并返回活动的id
    private String actvvityUrl;
    public Activitybl(String actvvityUrl){
        this.actvvityUrl=ScheduleConfig.activity;
    }
    public int newActivity(String  content,String par){
        content=content.replaceAll(" ","+");
        http.sendPost(ScheduleConfig.url+actvvityUrl,"order=new&content="+content+"&par="+par);
        String id=  http.sendPost(ScheduleConfig.url+actvvityUrl,"order=maxid");
        return Integer.parseInt(id);
    }
    public boolean isExit(){
        return false;
    }
    public void delActivity(int activityid){
        http.sendPost(ScheduleConfig.url+actvvityUrl,"order=del&id="+activityid);
    }
    public void addPar(int activityid,int parid){
        http.sendPost(ScheduleConfig.url+actvvityUrl,"order=add+par&id="+activityid+"&par="+parid);
    }
    public void delPar(int activityid,int parid){
        http.sendPost(ScheduleConfig.url+actvvityUrl,"order=del+par&id="+activityid+"&par="+parid);
    }
    public void setContent(String content,int activityid){
        content=content.replaceAll(" ","+");
        http.sendPost(ScheduleConfig.url+actvvityUrl,"order=del+par&id="+activityid+"&content="+content);
    }
    public String[] getContent(int activityid){
        String result=http.sendPost(ScheduleConfig.url+actvvityUrl,"order=get+inf&id="+activityid);
        String[] activity=result.split("#");
        return activity;
    }
}
