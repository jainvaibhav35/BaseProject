package baseproject.com.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import baseproject.com.activity.databinding.DatabindingActivityBinding;

/**
 * Created by lin on 7/3/17.
 */

public class DataBinding extends AppCompatActivity {

    DatabindingActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.databinding_activity);
        binding.button.setText("HI Button");
    }

}
