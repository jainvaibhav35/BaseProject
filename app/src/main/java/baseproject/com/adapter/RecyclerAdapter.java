package baseproject.com.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import baseproject.com.activity.BR;
import baseproject.com.activity.databinding.RecyclerAdapterBinding;
import baseproject.com.beans.UserBean;

/**
 * Created by lin on 7/3/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    private ArrayList<UserBean> mUserArr;
    private RecyclerAdapterBinding mAdapterBinding;
    private LayoutInflater mInflater;
    private Context mContext;

    public RecyclerAdapter(ArrayList<UserBean> mUserArr, Context mContext) {
        this.mUserArr = mUserArr;
        this.mContext = mContext;
    }

    @Override
    public RecyclerAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mInflater = LayoutInflater.from(parent.getContext());
        mAdapterBinding = RecyclerAdapterBinding.inflate(mInflater, parent, false);

        return new viewHolder(mAdapterBinding);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.viewHolder holder, int position) {
        final UserBean mUser = mUserArr.get(position);

        holder.bindUser(mUser);
    }

    @Override
    public int getItemCount() {
        return mUserArr.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding itemView;

        public viewHolder(ViewDataBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }

        public void bindUser(UserBean mUser) {

//            itemView.setUser(mUser);
//            itemView.setVariable(BR., mUser);

            itemView.setVariable(BR.user, mUser);
            itemView.executePendingBindings();
        }
    }
}
