package tools;

import java.util.Comparator;

import po.ContactPO;

/**
 *
 * @author gaoyang
 * 比较拼音顺序
 */
public class PinyinComparator implements Comparator<ContactPO> {

	public int compare(ContactPO o1, ContactPO o2) {
		if (o1.getSortLetters().equals("@")
				|| o2.getSortLetters().equals("#")) {
			return -1;
		} else if (o1.getSortLetters().equals("#")
				|| o2.getSortLetters().equals("@")) {
			return 1;
		} else {
			return o1.getSortLetters().compareTo(o2.getSortLetters());
		}
	}

}
