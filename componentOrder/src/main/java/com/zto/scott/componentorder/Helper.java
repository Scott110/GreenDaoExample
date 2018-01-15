package main.java.com.zto.scott.componentorder;

import android.content.Context;

import com.scott.order.db.DaoMaster;
import com.scott.order.db.DaoSession;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

import main.java.com.scott.libdb.GreenDaoManager;

/**
 * Created by Scott on 2018/1/12.
 */

public class Helper<T> {
    private static volatile Helper instance = null;
    private static final String DB_NAME = "db_order";
    private Context mCxt;
    private DaoSession daoSession;
    private DaoMaster daoMaster;


    private Helper(Context context) {
        mCxt = context.getApplicationContext();

    }

    public static Helper getInstance(Context context) {
        if (instance == null) {
            synchronized (Helper.class) {
                if (instance == null) {
                    instance = new Helper(context);
                }
            }
        }
        return instance;
    }

    private DaoSession getDaoSession() {
        String daoMasterClazzName = DaoMaster.class.getName();
        String dbOpenHelperClazzName = OrderSqliteOpenHelper.class.getName();
        if(daoMaster==null) {
            daoMaster = (DaoMaster) GreenDaoManager.getInstance().getDaoMaster(daoMasterClazzName, dbOpenHelperClazzName, mCxt, DB_NAME, false, null);
        }
        if(daoSession==null){
            daoSession = (DaoSession) GreenDaoManager.getInstance().getDaoSession(daoMaster);
        }
        return daoSession;
    }


    //关闭数据库
    public  void closeDbConnections() {
        if (daoMaster!= null) {
           daoMaster.getDatabase().close();
            daoMaster = null;
        }
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }


    public void insert(T t) {
        if (daoSession == null) {
            daoSession = getDaoSession();
        }
        daoSession.insert(t);
    }

    /**批量存储
     * @param list
     */
    public void insertBatch(final List<T> list){
        if (daoSession == null) {
            daoSession = getDaoSession();
        }

        daoSession.runInTx(new Runnable() {
            @Override
            public void run() {
                for (T t1: list) {
                    insert(t1);
                }
            }
        });
    }

    /**普通条件查询
     * @param t
     * @param whereCondition
     * @return
     */
    public T query(Class<T> t,WhereCondition whereCondition) {
        if (daoSession == null) {
            daoSession = getDaoSession();
        }
        T bean = daoSession.queryBuilder(t).where(whereCondition).build().unique();
        return bean;
    }

}
