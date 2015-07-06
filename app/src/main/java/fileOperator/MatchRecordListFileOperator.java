package fileOperator;

import android.app.Activity;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.MatchRecordListPO;
import po.MatchRecordPO;

/**
 * Created by gaoyang on 15/7/7.
 */
public class MatchRecordListFileOperator {


    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public MatchRecordListFileOperator(){
    }

    public void saveObject(MatchRecordListPO matchRecordListPO,String filename){
        try {
            //存入数据
            File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator +"ContactBackup"+File.separator +filename);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            fileOutputStream= new FileOutputStream(file.toString());
            objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(matchRecordListPO);

        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            if (objectOutputStream!=null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream!=null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream!=null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public MatchRecordListPO getObject(String filename) {
        MatchRecordListPO matchRecordListPO=new MatchRecordListPO();
        try {
            File file = new File(Environment.getExternalStorageDirectory().toString() + File.separator + "ContactBackup" + File.separator + filename);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }


            //取出数据
            fileInputStream = new FileInputStream(file.toString());
            objectInputStream = new ObjectInputStream(fileInputStream);
            matchRecordListPO = (MatchRecordListPO) objectInputStream.readObject();


        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return matchRecordListPO;
    }
}
