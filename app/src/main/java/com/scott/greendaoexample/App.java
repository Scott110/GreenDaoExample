package com.scott.greendaoexample;

import android.app.Application;


import com.scott.order.db.DaoMaster;
import com.zto.scott.componentorder.Order;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Scott on 2018/1/11.
 */

public class App extends Application {
   private static Application instance;
   //private DaoSession daoSession;
   private final boolean ENCRYPTED=true;
    public static Application getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        //initGreenDao();





    }

   /* private void initGreenDao(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }*/

}
