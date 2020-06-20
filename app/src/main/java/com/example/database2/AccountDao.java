/**
 * Auto generated using Code Generator
 *
 * For more information about this tool, please visit
 * https://www.coding-made-easy.com

 * This file is Generated on : Sat Jun 20 10:47:15 GMT+05:30 2020
**/

package com.example.database2;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

@Dao
public interface AccountDao extends BaseCommonDao<Account> {

    @Query("SELECT * FROM " + DatabaseConstants.AccountTableKey.TABLE_NAME)
	LiveData<List<Account>> getAllData();

    @Query("SELECT * FROM " + DatabaseConstants.AccountTableKey.TABLE_NAME + " ORDER BY :orderBy") 
	LiveData<List<Account>> getAllData(String orderBy);

    @RawQuery(observedEntities = Account.class)
    LiveData<Account> getData(SupportSQLiteQuery query);

    @RawQuery(observedEntities = Account.class)
    LiveData<List<Account>> getListData(SupportSQLiteQuery query);

    @Query("DELETE FROM " + DatabaseConstants.AccountTableKey.TABLE_NAME)
    int deleteAllData();

    @RawQuery(observedEntities = Account.class)
    int delete(SupportSQLiteQuery query);

    /**
     * Table name to be utilized by BaseCommonDao to perform operations sa. execution of
     * Sqlite functions (MAX, MIN, etc..)
     */
    default String getTableName() {
        return DatabaseConstants.AccountTableKey.TABLE_NAME;
    }
}