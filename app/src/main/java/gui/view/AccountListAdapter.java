package gui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.database2.Account;
import com.example.roomjava.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import gui.view.AccountListAdapter.AccountViewHolder;


public class AccountListAdapter extends RecyclerView.Adapter<AccountViewHolder> {

    class AccountViewHolder extends RecyclerView.ViewHolder {
        private final TextView accountItemView;

        private AccountViewHolder(View itemView) {
            super(itemView);
            accountItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Account> accounts;

    AccountListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new AccountViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AccountViewHolder holder, int position) {
        if (accounts != null) {
            Account current = accounts.get(position);
            holder.accountItemView.setText(current.name);
        }
        else {
            holder.accountItemView.setText("No Word");
        }
    }

    void setAccounts(List<Account> words) {
        accounts = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (accounts != null)
            return accounts.size();
        else return 0;
    }
}


