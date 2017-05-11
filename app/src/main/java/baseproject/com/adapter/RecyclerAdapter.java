package baseproject.com.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import baseproject.com.activity.BR;
import baseproject.com.activity.R;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_adapter, parent, false);
        viewHolder holder = new viewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.viewHolder holder, int position) {
        final UserBean mUser = mUserArr.get(position);

        holder.getBindings().setVariable(BR.user, mUser);
        holder.getBindings().executePendingBindings();


//        holder.bindUser(mUser);
    }

    @Override
    public int getItemCount() {
        return mUserArr.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        RecyclerAdapterBinding itemView;

        public viewHolder(View mView) {
            super(mView);
            itemView = DataBindingUtil.bind(mView);
        }

        /*public void bindUser(UserBean mUser) {

//            itemView.setUser(mUser);
//            itemView.setVariable(BR., mUser);

            itemView.setVariable(BR.user, mUser);
            itemView.executePendingBindings();
        }*/

        public RecyclerAdapterBinding getBindings() {
            return itemView;
        }
    }
}
