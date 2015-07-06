package fileOperator;

import android.app.Activity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.MatchRecordListPO;

/**
 * Created by gaoyang on 15/7/7.
 */
public class MatchRecordListFileOperator {

    private void saveObject(MatchRecordListPO matchRecordListPO,String name,Activity activity){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = activity.openFileOutput(name, activity.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(matchRecordListPO);
        } catch (Exception e) {
            e.printStackTrace();
            //这里是保存文件产生异常
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    //fos流关闭异常
                    e.printStackTrace();
                }
            }
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    //oos流关闭异常
                    e.printStackTrace();
                }
            }
        }
    }

    private MatchRecordListPO getObject(String name,Activity activity){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = activity.openFileInput(name);
            ois = new ObjectInputStream(fis);
            return (MatchRecordListPO)(ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
            //这里是读取文件产生异常
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    //fis流关闭异常
                    e.printStackTrace();
                }
            }
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    //ois流关闭异常
                    e.printStackTrace();
                }
            }
        }
        //读取产生异常，返回null
        return null;
    }
}
