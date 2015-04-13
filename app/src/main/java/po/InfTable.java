package po;

import java.util.HashMap;
import java.util.Map;

//这个类用于存储user的基础信息在userinf的存储位置
public final class InfTable {
    private Map<String,Integer> map=new HashMap<String,Integer>();
    public InfTable(){
        map.put("id", 0);
        map.put("name",1);
        map.put("phone number", 2);
        map.put("picture path", 3);
    }
    public int getIndex(String name){
        return map.get(name);
    }
    public int getSize(){
        return map.size();
    }
    public String[] describeTable(){
        int i=0;
        String[] list=new String[map.size()];
        for(String s:map.keySet()){
            list[i]=s;
            i++;
        }
        return list;
    }
    public String toString(){
        String result="";
        for(String temp:map.keySet()){
            result=result+","+temp;
        }
        return "#InfTable"+result;
    }

}
