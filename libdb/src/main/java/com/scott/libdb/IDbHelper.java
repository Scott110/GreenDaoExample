package main.java.com.scott.libdb;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Scott on 2018/1/15.
 * 数据库基本操作
 */

public interface IDbHelper<T, K> {
    //插入
    boolean insert(T t);


    /**批量插入
     * @param mList
     * @return
     */
    boolean insertList(List<T> mList);

    //删除
    boolean delete(T t);

    //根据关键字删除
    boolean deleteByKey(K key);

    //批量删除
    boolean deleteBatch(List<T> mList);

    boolean deleteByKeyInTx(K... key);

    //删除所有
    boolean deleteAll();

    //插入或者更新
    boolean insertOrReplace(@NonNull T t);


    /** 批量插入/更新
     * @param mList
     * @return
     */
    boolean insertOrReplaceList(List<T> mList);

    //更新
    boolean update(T t);

   // boolean updateInTx(M... m);

    //批量更新
    boolean updateBatch(List<T> mList);

    //M selectByPrimaryKey(K key);

    List<T> loadAll();

    //boolean refresh(M m);

    /** * 清理缓存 */
    void clearDaoSession();

   //删除数据库中所有表
    boolean dropDatabase();

    /** * 事务 */
    void runInTx(Runnable runnable);





    /** * 自定义查询 * * @return */
    //QueryBuilder<M> getQueryBuilder();


    /** 原始数据查询
     * @param where
     * @param selectionArg
     * @return
     */
    List<T> queryRaw(String where, String... selectionArg);
}
