/**
 * Auto generated using Code Generator
 *
 * For more information about this tool, please visit
 * https://www.coding-made-easy.com

 * This file is Generated on : Sat Jun 20 10:47:15 GMT+05:30 2020
**/

package com.example.database2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
    tableName = (DatabaseConstants.AccountTableKey.TABLE_NAME))

public class Account {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = DatabaseConstants.AccountTableKey.ACCOUNT_ID_FIELD)
	Long accountid;

	@ColumnInfo(name = DatabaseConstants.AccountTableKey.NAME_FIELD) public String name;

	@ColumnInfo(name = DatabaseConstants.AccountTableKey.AGE_FIELD) public Integer age;

	@ColumnInfo(name = DatabaseConstants.AccountTableKey.DATE_FIELD) public Long date;

	@ColumnInfo(name = DatabaseConstants.AccountTableKey.EARNINGS_FIELD) public Double earnings;

	@ColumnInfo(name = DatabaseConstants.AccountTableKey.MORE_FIELD) public Float more;

	public Account() { 

		name = null;
		age = null;
		date = null;
		earnings = null;
		more = null;
	}
}