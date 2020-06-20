/**
 * Auto generated using Code Generator
 *
 * For more information about this tool, please visit
 * https://www.coding-made-easy.com

 * This file is Generated on : Sat Jun 20 10:47:15 GMT+05:30 2020
**/

package com.example.database2;

public class  DatabaseConstants {

	public interface BaseConstants {


			// If you change the database schema, you must increment the database version
		int DATABASE_VERSION = 1;
		String DATABASE_NAME = "database.db";
	}

	interface AccountTableKey {

			String TABLE_NAME = "account";

			String ACCOUNT_ID_FIELD = "account_id";
			String NAME_FIELD = "name";
			String AGE_FIELD = "age";
			String DATE_FIELD = "date";
			String EARNINGS_FIELD = "earnings";
			String MORE_FIELD = "more";
        }

	interface ArtistTableKey {

			String TABLE_NAME = "artist";

			String ARTIST_ID_FIELD = "artist_id";
			String ACCOUNT_FK_FIELD = "account_fk";
			String AGE_FIELD = "age";
        }

	interface InstrumentTableKey {

			String TABLE_NAME = "instrument";

			String ID_FIELD = "id";
			String TYPE_FIELD = "type";
			String ACT_FK_FIELD = "act_fk";
			String ARTIST_FK_FIELD = "artist_fk";
        }

}
