package gui.view;

import android.app.Application;

import com.example.database2.Account;
import com.example.database2.AccountDao;
import com.example.database2.AccountRepository;
import com.example.database2.AppRoomDatabase;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class AccountViewModel extends AndroidViewModel {

    private AccountRepository mRepository;

    private LiveData<List<Account>> accounts;
    private AccountDao accountDao;

    public AccountViewModel(Application application) {
        super(application);

        AppRoomDatabase db = AppRoomDatabase.getDatabase(application);
        accountDao = db.accountDao();

        mRepository = new AccountRepository(accountDao);
        accounts = mRepository.getAllData();
    }

    LiveData<List<Account>> getAllWords() {
        return accounts;
    }

    void insert(Account account) {

//        Long value = mArtistDao.executeFunction(SqliteFunctions.MAX, ArtistTableKey.ARTIST_ID_FIELD, null);
        mRepository.insert(account);
    }
}
