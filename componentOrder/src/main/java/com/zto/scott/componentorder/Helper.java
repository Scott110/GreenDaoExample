package main.java.com.zto.scott.componentorder;

import android.content.Context;

import com.scott.order.db.DaoMaster;

/**
 * Created by Scott on 2018/1/12.
 */

public class Helper {
    public void test(Context cxt){
    DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(cxt,"ss");
    DaoMaster daoMaster=new DaoMaster(helper.getWritableDb());

    }

}
