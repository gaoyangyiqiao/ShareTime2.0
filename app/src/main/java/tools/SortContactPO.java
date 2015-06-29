package tools;

import java.util.Collections;
import java.util.List;

import po.ContactPO;

/**
 * Created by gaoyang on 15/6/30.
 */
public class SortContactPO {
    public void sort(List<ContactPO> contacts){
        CharacterParser parser=CharacterParser.getInstance();

        for (int i = 0; i <contacts.size() ; i++) {
            String pinyin = parser.getSelling(contacts.get(i).getName());
//                        System.out.print(pinyin);
            String sortString = pinyin.substring(0, 1).toUpperCase();
//                        System.out.println("--->+"+sortString);
            // 正则表达式，判断首字母是否是英文字母
            if(sortString.matches("[A-Z]")){
                contacts.get(i).setSortLetters(sortString.toUpperCase());
            }else{
                contacts.get(i).setSortLetters("#");
            }
        }
        Collections.sort(contacts, new PinyinComparator());
    }
}
