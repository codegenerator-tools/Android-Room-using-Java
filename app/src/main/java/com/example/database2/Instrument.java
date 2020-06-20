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
    tableName = (DatabaseConstants.InstrumentTableKey.TABLE_NAME),
       foreignKeys = {
           @ForeignKey(
               entity = Account.class,
               parentColumns = {DatabaseConstants.AccountTableKey.ACCOUNT_ID_FIELD},
               childColumns = {DatabaseConstants.InstrumentTableKey.ACT_FK_FIELD}
               /*onDelete = CASCADE)*/
),
           @ForeignKey(
               entity = Artist.class,
               parentColumns = {DatabaseConstants.ArtistTableKey.ARTIST_ID_FIELD},
               childColumns = {DatabaseConstants.InstrumentTableKey.ARTIST_FK_FIELD}
               /*onDelete = CASCADE)*/

               )},
		indices = {@Index(value = {DatabaseConstants.InstrumentTableKey.ACT_FK_FIELD, DatabaseConstants.InstrumentTableKey.ARTIST_FK_FIELD})}
)

public class Instrument {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = DatabaseConstants.InstrumentTableKey.ID_FIELD)
	Integer id;

	@ColumnInfo(name = DatabaseConstants.InstrumentTableKey.TYPE_FIELD) public Integer type;

	@ColumnInfo(name = DatabaseConstants.InstrumentTableKey.ACT_FK_FIELD) public Long actfk;

	@ColumnInfo(name = DatabaseConstants.InstrumentTableKey.ARTIST_FK_FIELD) public Long artistfk;

	public Instrument() { 

		type = null;
		actfk = null;
		artistfk = null;
	}
}