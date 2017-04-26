package baseproject.com.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import baseproject.com.activity.databinding.RecyclerLayoutBinding;
import baseproject.com.adapter.RecyclerAdapter;
import baseproject.com.beans.UserBean;

/**
 * Created by lin on 7/3/17.
 */

public class DataBindingWithRecycler extends AppCompatActivity {


    private ArrayList<UserBean> mUserArr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerLayoutBinding mBinder = DataBindingUtil.setContentView(this, R.layout.recycler_layout);

        prepareArraylist();

        LinearLayoutManager mLinearLayourManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mBinder.recyler.setLayoutManager(mLinearLayourManager);
        mBinder.recyler.setAdapter(new RecyclerAdapter(mUserArr, this));

    }

    private void prepareArraylist() {

        mUserArr = new ArrayList<>();

        mUserArr.add(new UserBean(1, "Vaibhav", "Jain"));
        mUserArr.add(new UserBean(2, "Ranjeet", "Signh"));
        mUserArr.add(new UserBean(3, "Rishi", "Gargi"));
    }
}
