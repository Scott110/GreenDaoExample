package main.java.com.zto.scott.componentorder;

import android.content.Context;

import com.scott.order.db.DaoMaster;
import com.scott.order.db.DaoMaster.DevOpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Scott on 2018/1/15.
 */

public class OrderSqliteOpenHelper extends DevOpenHelper {
    public OrderSqliteOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
