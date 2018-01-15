package main.java.com.scott.libdb;

import android.content.Context;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * GreenDao 相关管理
 * Created by Scott on 2018/1/12.
 */

public class GreenDaoManager {
    private static volatile GreenDaoManager instance = null;
    private static final boolean mIsEncrypt = false;
    private static final String mEncryptKey = "abcdefg";


    public static GreenDaoManager getInstance() {
        if (instance == null) {
            synchronized (GreenDaoManager.class) {
                if (instance == null) {
                    instance = new GreenDaoManager();
                }
            }
        }
        return instance;
    }


    public AbstractDaoMaster getDaoMaster(String daoMasterClazz, String openHelperClazz,
                                          Context cxt, String dbName, boolean isEncrypt, String encryptKey) {
        try {
            Class helperClazz = Class.forName(openHelperClazz);
            Class[] paramTypes = new Class[]{Context.class, String.class};
            Object[] params = new Object[]{cxt, dbName};
            Constructor openHelperCon = helperClazz.getConstructor(paramTypes);
            Object openHelper = openHelperCon.newInstance(params);
            String methodName = "";
            Method m;
            Database db;
            if (isEncrypt) {
                methodName = "getEncryptedWritableDb";
                if(encryptKey==null){
                    encryptKey=mEncryptKey;
                }
                Class<?>[] helperMethodParTypes = new Class<?>[1];
                helperMethodParTypes[0] = String.class;
                m = helperClazz.getMethod(methodName, helperMethodParTypes);
                db = (Database) m.invoke(openHelper, encryptKey);
            } else {
                methodName = "getWritableDb";
                m = helperClazz.getMethod(methodName, new Class[]{});
                db = (Database) m.invoke(openHelper, new Object[]{});
            }
            Class daoMasterClz = Class.forName(daoMasterClazz);
            Class<?>[] daoParTypes = new Class<?>[1];
            daoParTypes[0] = Database.class;
            Constructor daoMasterCon = daoMasterClz.getConstructor(daoParTypes);
            AbstractDaoMaster daoMaster = (AbstractDaoMaster) daoMasterCon.newInstance(db);
            return daoMaster;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public AbstractDaoSession getDaoSession(AbstractDaoMaster daoMaster) {
        if (daoMaster == null) return null;
        AbstractDaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }

    /**
     * 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
     */
    public static void enableQueryBuilderLog() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }






}
