package tools;

import java.util.Collections;
import java.util.List;

import po.ContactPO;

/**
 * Created by gaoyang on 15/6/30.
 */
public class SortContactPO {
    CharacterParser parser;

    public SortContactPO(){
        parser=CharacterParser.getInstance();
    }

    public String getFirstLetter(String name){
        String pinyin = parser.getSelling(name);
//                        System.out.print(pinyin);
        String sortString = pinyin.substring(0, 1).toUpperCase();
//                        System.out.println("--->+"+sortString);
        // 正则表达式，判断首字母是否是英文字母
        if(sortString.matches("[A-Z]")){
            return (sortString.toUpperCase());
        }else{
            return ("#");
        }
    }

    public void sort(List<ContactPO> contacts){

        for (int i = 0; i <contacts.size() ; i++) {
            contacts.get(i).setSortLetters(getFirstLetter(contacts.get(i).getName()));
        }
        Collections.sort(contacts, new PinyinComparator());
    }
}
