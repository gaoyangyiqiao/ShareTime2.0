package turingmachine.com.sharetime20;

import android.test.InstrumentationTestCase;

import net.tsz.afinal.http.AjaxParams;

import java.util.HashMap;

/**
 * Created by gaoyang on 15/6/4.
 */
public class TestClass extends InstrumentationTestCase{

    public void test()throws Exception{
        AjaxParams params=new AjaxParams();
        params.put("1","1");
        params.put("haha","haha");
        System.out.println(params);
        assertEquals(3, 1);
    }

}
