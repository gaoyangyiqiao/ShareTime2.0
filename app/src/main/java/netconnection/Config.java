package netconnection;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by gaoyang on 15/4/1.
 */
public class Config {
    //此时为仙1四楼ip地址
//    public final static String URL="http://172.26.223.2:3306/sharetimedb/index.php";
    //此时为大活5楼地址
    public final static String URL="http://192.168.1.110:3306/sharetimedb/index.php";

    public static final String KEY_TOKEN="token";
    public static final String KEY_PHONE_NUM="phone";
    public static final String KEY_ACCOUNT="account";
    public static final String KEY_CONTACTS="contacts";
    public static final String KEY_ACTION="action";
    public static final String KEY_USER_ID="user_id";
    public static final String KEY_ID="id";
    public static final String KEY_PHONE="phone";
    public static final String KEY_NAME="name";
    public static final String KEY_IMG="img";

    public static final String ACTION_GET_CONTACTS="get_contacts";
    public static final String ACTION_GET_CONTACT_INFO="get_contact_info";

    public static final int RESULT_STATUS_SUCCESS = 1;
    public static final int RESULT_STATUS_FAIL = 0;
    public static final int RESULT_STATUS_INVALID_TOKEN = 2;

    public static final String APP_ID = "com.turingmachine.sharetime";
    public static final String CHARSET = "utf-8";

    public static String getCachedId(Context context){
        return context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).getString(KEY_ID,null);
    }

    public static void cacheId(Context context,String user_id){
        SharedPreferences.Editor e=context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_ID,user_id);
        e.commit();
    }

    public static String getCachedToken(Context context){
        return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).getString(KEY_TOKEN, null);
    }

    public static void cacheToken(Context context,String token){
        SharedPreferences.Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_TOKEN, token);
        e.commit();
    }
    public static String getCachedPhoneNum(Context context){
        return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).getString(KEY_PHONE_NUM, null);
    }

    public static void cachePhoneNum(Context context,String phoneNum){
        SharedPreferences.Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_PHONE_NUM, phoneNum);
        e.commit();
    }

}
