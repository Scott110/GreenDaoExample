package main.java.com.scott.libdb;

import android.content.Context;

import org.greenrobot.greendao.AbstractDaoMaster;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Scott on 2018/1/12.
 */

public class GreenDaoHelper<T> {

    public static T getDaoMaster(String daoMasterClazz, String openHelperClazz,
                                 Context cxt, String dbName) {
        try {
            Class helperClazz = Class.forName(openHelperClazz);
            Class[] paramTypes = new Class[]{Context.class, String.class};
            Object[] params = new Object[]{cxt, dbName};
            Constructor openHelperCon = helperClazz.getConstructor(paramTypes);
            Object openHelper = openHelperCon.newInstance(params);
            String methodName="getWritableDb";
            Method m = helperClazz.getMethod(methodName, null);
            Object db= m.invoke(openHelper,null);

            Class daoMaster = Class.forName(daoMasterClazz);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            //此处不可用 DaoMaster.DevOpenHelper, 那是开发辅助类，我们要自定义一个，方便升级
            DaoMaster.OpenHelper helper = new MyOpenHelper(mContext, DB_NAME);
            daoMaster = new DaoMaster(helper.getEncryptedReadableDb("password"));
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }*/

}
