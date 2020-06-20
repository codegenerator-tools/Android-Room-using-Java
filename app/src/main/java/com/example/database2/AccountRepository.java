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
import androidx.sqlite.db.SimpleSQLiteQuery;

public class AccountRepository {

    private AccountDao accountDao;

    public AccountRepository(AccountDao accountDao) {

		this.accountDao = accountDao;
	}

    public LiveData<List<Account>> getAllData() {

        return accountDao.getAllData();
    }

    public LiveData<List<Account>> getAllData(String orderBy) {

        return accountDao.getAllData(orderBy);
    }

	public List<Long> insertAll(List<Account> data) {
        return accountDao.insertAll(data);
    }

	public Long insert(Account data) {
        return accountDao.insert(data);
    }

    public LiveData<Account> getData(String whereCondition) {

		StringBuilder finalQuery = new StringBuilder();
		finalQuery.append("SELECT * FROM " + DatabaseConstants.AccountTableKey.TABLE_NAME);

		if(whereCondition != null && whereCondition.length() > 0) {

			finalQuery.append(" WHERE " + whereCondition);
		}

		finalQuery.append(" LIMIT 1");

		SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(finalQuery.toString());

		return accountDao.getData(simpleSQLiteQuery);
	}

	public LiveData<List<Account>> getListData(String whereCondition, String orderBy) {

        StringBuilder finalQuery = new StringBuilder ();
        finalQuery.append("SELECT * FROM " + DatabaseConstants.AccountTableKey.TABLE_NAME);

		if(whereCondition != null && whereCondition.length() > 0) {

			finalQuery.append(" WHERE " + whereCondition);
		}

		if(orderBy != null && orderBy.length() > 0) {

			finalQuery.append(" ORDER BY " + orderBy);
		}
        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(finalQuery.toString());

        return accountDao.getListData(simpleSQLiteQuery);
    }

    public int delete(String whereCondition) {

		if(whereCondition == null || whereCondition.length() <= 0) {

			return 0;
		}

        String finalQuery = "DELETE FROM " + DatabaseConstants.AccountTableKey.TABLE_NAME  + " WHERE " + whereCondition;
        
        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(finalQuery);

        return accountDao.delete(simpleSQLiteQuery);
    }

    public int deleteAllData() {

        return accountDao.deleteAllData();
    }
}