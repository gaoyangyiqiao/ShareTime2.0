package po;

public class UserInf {
    private LinkList<Object> list=new LinkList<Object>();//存储基本信息的链表
    private InfTable table;
    public UserInf(Object[] userInf){
        for(Object temp:userInf)
            list.insert(temp);
    }
    public UserInf(int id,String name,String phoneNumber,String picturePath){
        list.insert(id);
        list.insert(name);
        list.insert(phoneNumber);
        list.insert(picturePath);
    }
    public void setInf(String name,Object inf){//修改信息，name是要修改信息的名字，inf是修改后的值
        list.setValueAt(getIndex(name), inf);
    }
    public Object getInf(String name){
        return list.getValueAt(getIndex(name));
    }
    public int getIndex(String name){//取得信息在list中的位置
        return table.getIndex(name);
    }
    public String[] getDescribeOfUserInf(){
        return table.describeTable();
    }
    public String toString(){
        return "#UserInf,"+list.toString()+","+table.toString();
    }



}
