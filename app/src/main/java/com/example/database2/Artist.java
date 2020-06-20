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
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = (DatabaseConstants.ArtistTableKey.TABLE_NAME),
       foreignKeys = {
           @ForeignKey(
               entity = Account.class,
               parentColumns = {DatabaseConstants.AccountTableKey.ACCOUNT_ID_FIELD},
               childColumns = {DatabaseConstants.ArtistTableKey.ACCOUNT_FK_FIELD}
               /*onDelete = CASCADE)*/

               )},
		indices = {@Index(value = {DatabaseConstants.ArtistTableKey.ACCOUNT_FK_FIELD})}
)

public class Artist {

	@PrimaryKey(autoGenerate = false)
	@ColumnInfo(name = DatabaseConstants.ArtistTableKey.ARTIST_ID_FIELD)
	Long artistid;

	@ColumnInfo(name = DatabaseConstants.ArtistTableKey.ACCOUNT_FK_FIELD) public Long accountfk;

	@ColumnInfo(name = DatabaseConstants.ArtistTableKey.AGE_FIELD) public Integer age;

	public Artist() { 

		artistid = null;
		accountfk = null;
		age = null;
	}
}