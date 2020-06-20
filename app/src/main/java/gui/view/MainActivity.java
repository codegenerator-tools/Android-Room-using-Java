package gui.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import com.example.database2.Account;
import com.example.roomjava.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private AccountViewModel accountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final AccountListAdapter adapter = new AccountListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        accountViewModel = new ViewModelProvider(this).get(AccountViewModel.class);

        accountViewModel.getAllWords().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(@Nullable final List<Account> accounts) {
                adapter.setAccounts(accounts);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewAccountActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch(msg.what) {

                case 1:

                    Bundle data = msg.getData();
                    final String artistName = data.getString("artist_name");
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {

                            Account account = new Account();
                            account.name = artistName;
                            accountViewModel.insert(account);
                        }
                    });

                    break;
            }
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
//            Artist word = new Artist();
//            word.artistname = data.getStringExtra(NewWordActivity.EXTRA_REPLY);
//            mWordViewModel.insert(word);
//            Bundle bundle = new Bundle();
//            bundle.putString("artist_name", data.getStringExtra(NewWordActivity.EXTRA_REPLY));
//            Message message = new Message();
//            message.what = 1;
//            message.setData(bundle);
//            mHandler.sendMessage(message);
//            mHandler.sendEmptyMessage(1);
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {

                    Account account = new Account();
                    account.name = data.getStringExtra(NewAccountActivity.ACTIVITY_RESULT_KEY);
                    accountViewModel.insert(account);
                }
            });

        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Invalid response received",
                    Toast.LENGTH_LONG).show();
        }
    }
}
