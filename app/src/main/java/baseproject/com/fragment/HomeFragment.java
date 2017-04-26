package baseproject.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

import baseproject.com.activity.R;
import baseproject.com.appInterface.DialogInterface;
import baseproject.com.utils.AppConstant;
import baseproject.com.utils.AppDialog;
import baseproject.com.utils.ApplicationSnackbar;

/**
 * Organizaton LPTPL
 * Created by Vaibhav Jain on 18/5/16.
 */
public class HomeFragment extends Fragment {

    private static final int DIALOGID = 100;
    //    private final String TAG = getActivity().getClass().getSimpleName();
    private View mView;
    private RelativeLayout ll_main;

    DialogInterface dialogInterface = new DialogInterface() {
        @Override
        public void clickResponse(int Id, String response) {
            if (Id == DIALOGID) {
                if (response.equals(AppConstant.dialogYes))
                    // Do here what you want to perform on yes click
                    ApplicationSnackbar.showSnackBar(ll_main, "Yes Clicked");
                else
                    // Do here what you want to perform on no click
                    ApplicationSnackbar.showSnackBar(ll_main, "No Clicked");
            }
        }
    };

    // For Firebase Authentication
    private FirebaseAuth firebaseAuth;

    private Button clickHere;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        mView = inflater.inflate(R.layout.homefragment, null);
        ll_main = (RelativeLayout) mView.findViewById(R.id.ll_main);
        clickHere = (Button) mView.findViewById(R.id.button);

//        firebaseAuth = FirebaseAuth.getInstance();

        clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDialog.showDialog(getActivity(), DIALOGID, "Title", "Description" +
                        "", "ok", "No", false, false, dialogInterface);
            }
        });


        Intent objIntent = new Intent();
        objIntent.setAction("abc");
//        objIntent.setAction("def");
        getActivity().sendBroadcast(objIntent);



        /*// Using Lambda Expression

        clickHere.setOnClickListener((v) -> {
            AppDialog.showDialog(getActivity(), DIALOGID, "Title", "Description" +
                    "", "ok", "No", false, false, dialogInterface);
        });*/

        return mView;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        // For setting toolbar title
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");
    }


}
