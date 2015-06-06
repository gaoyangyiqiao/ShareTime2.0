package netconnection;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by gaoyang on 15/4/1.
 */
public class Config {

    //日期的格式
    public static final String DATE_PATTERN="yyyy-MM-dd hh:mm:ss";

    public final static String URL="http://192.168.1.105:3306/sharetimedb/index.php";
    public static final String KEY_TOKEN="token";
    public static final String KEY_PHONE_NUM="phone";
    public static final String KEY_ACCOUNT="account";
    public static final String KEY_CONTACTS="contacts";
    public static final String KEY_ACTION="action";
    public static final String KEY_USER_ID="user_id";
    public static final String KEY_PHONE="phone";
    public static final String KEY_NAME="name";
    public static final String KEY_IMG="img";
    public static final String KEY_PHOTO_PATH="photopath";
    public static final String KEY_CONTACT_ID="contact_id";
    public static final String KEY_USER_ID_ARRAY="user_id_array";
    public static final String KEY_KEYWORDS="keywords";

    //json中的key
    public static final String KEY_ID="id";
    public static final String KEY_ACTIVITY="activity";
    public static final String KEY_SIZE="size";
    public static final String KEY_BEGIN_TIME="begin_time";
    public static final String KEY_CONTENT="content";
    public static final String KEY_CONTACTS_ID="contacts_id";
    public static final String KEY_INFO="info";
    public static final String KEY_USER_SCHEDULE="user_schedule";
    public static final String KEY_COMMON_FREE_SCHEDULE="common_free_schedule";
    public static final String KEY_THEME="theme";
    public static final String KEY_RECEIVE_TIME="receive_time";
    public static final String KEY_START_TIME="start_time";
    public static final String KEY_END_TIME="end_time";
    public static final String KEY_FOUNDER_ID="founder_id";
    public static final String KEY_RIGHT="right";
    public static final String KEY_USERS="users";
    public static final String KEY_STUDENT_ID="student_id";
    public static final String KEY_STUDENT_PASSWORD="student_password";

    public static final String ACTION_REGISTER="register";
    public static final String ACTION_GET_CONTACTS="get_contacts";
    public static final String ACTION_GET_CONTACT_INFO="get_contact_info";
    public static final String ACTION_GET_USER_SCHEDULE="get_user_schedule";
    public static final String ACTION_MATCH="match";
    public static final String ACTION_ADD_CONTACT="add_contact";
    public static final String ACTION_UPLOAD_CONTACTS="upload_contact";
    public static final String ACTION_UPLOAD_MYINFO="upload_myInfo";
    public static final String ACTION_INIT="init";
    public static final String ACTION_SEARCH_USER="search_user";
    public static final String ACTION_ADD_ACTIVITY="add_activity";

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

    public static String getCachedStudentId(Context context){
        return context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).getString(KEY_STUDENT_ID,null);
    }

    public static void cacheStudentId(Context context,String student_id){
        SharedPreferences.Editor e=context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_ID,student_id);
        e.commit();
    }

    public static String getCachedStudentPassword(Context context){
        return context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).getString(KEY_STUDENT_PASSWORD,null);
    }

    public static void cacheStudentPassword(Context context,String user_id){
        SharedPreferences.Editor e=context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_STUDENT_PASSWORD,user_id);
        e.commit();
    }

}
