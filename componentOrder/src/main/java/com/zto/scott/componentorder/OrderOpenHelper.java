package main.java.com.zto.scott.componentorder;

import android.content.Context;

import com.scott.order.db.DaoMaster.OpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Scott on 2018/1/11.
 * 用于升级
 */

public class OrderOpenHelper extends OpenHelper {
    public OrderOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
