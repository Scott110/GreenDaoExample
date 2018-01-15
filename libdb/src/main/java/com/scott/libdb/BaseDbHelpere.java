package main.java.com.scott.libdb;

import android.content.Context;
import android.support.annotation.NonNull;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;

import java.util.List;

/**
 * Created by Scott on 2018/1/15.
 * 基础数据库操作类
 */

public abstract class BaseDbHelpere<T,K> implements IDbHelper<T,K> {
    public Context mCxt;
    public AbstractDaoSession daoSession;
    public AbstractDaoMaster daoMaster;

    public abstract AbstractDaoSession getDaoSession();

    @Override
    public boolean insert(T t) {
        if (daoSession == null) {
            daoSession = getDaoSession();
        }
        daoSession.insert(t);
        return true;
    }



    @Override
    public boolean insertList(@NonNull List<T> mList) {
        try {
            if (mList == null || mList.size() == 0)
                return false;
            daoMaster.insertInTx(list);
        } catch (SQLiteException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public boolean deleteByKey(Object key) {
        return false;
    }

    @Override
    public boolean deleteBatch(List mList) {
        return false;
    }

    @Override
    public boolean deleteByKeyInTx(Object[] key) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean insertOrReplace(@NonNull Object o) {
        return false;
    }

    @Override
    public boolean insertOrReplaceList(List mList) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean updateBatch(List mList) {
        return false;
    }

    @Override
    public List loadAll() {
        return null;
    }

    @Override
    public void clearDaoSession() {

    }

    @Override
    public boolean dropDatabase() {
        return false;
    }

    @Override
    public void runInTx(Runnable runnable) {

    }

    @Override
    public List queryRaw(String where, String... selectionArg) {
        return null;
    }
}
