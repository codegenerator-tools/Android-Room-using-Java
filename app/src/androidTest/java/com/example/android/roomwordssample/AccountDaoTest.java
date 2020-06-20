package com.example.android.roomwordssample;

import android.content.Context;

import com.example.database2.Account;
import com.example.database2.AccountDao;
import com.example.database2.AppRoomDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AccountDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private AccountDao accountDao;
    private AppRoomDatabase appRoomDatabase;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();

        appRoomDatabase = Room.inMemoryDatabaseBuilder(context, AppRoomDatabase.class)

                .allowMainThreadQueries()
                .build();
        accountDao = appRoomDatabase.accountDao();
    }

    @After
    public void closeDb() {
        appRoomDatabase.close();
    }

    @Test
    public void insertAndGet() throws Exception {
        Account account = new Account();
        account.name = "Test name";
        accountDao.insert(account);
        List<Account> allAccounts = LiveDataTestUtil.getValue(accountDao.getAllData());
        assertEquals(allAccounts.get(0).name, account.name);
    }

    @Test
    public void fetchAllData() throws Exception {
        Account account = new Account();
        account.name = "Test name 1";
        accountDao.insert(account);

        Account account2 = new Account();
        account2.name = "Test name 2";
        accountDao.insert(account2);

        List<Account> allAccounts = LiveDataTestUtil.getValue(accountDao.getAllData());
        assertEquals(allAccounts.get(0).name, account.name);
        assertEquals(allAccounts.get(1).name, account2.name);
    }

    @Test
    public void deleteAll() throws Exception {
        Account account = new Account();
        account.name = "Test name 1";
        accountDao.insert(account);

        Account account2 = new Account();
        account2.name = "Test name 2";
        accountDao.insert(account2);

        accountDao.deleteAllData();
        List<Account> allAccounts = LiveDataTestUtil.getValue(accountDao.getAllData());
        assertTrue(allAccounts.isEmpty());
    }
}
