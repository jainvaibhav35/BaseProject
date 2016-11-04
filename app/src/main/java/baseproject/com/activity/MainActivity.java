package baseproject.com.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import baseproject.com.fragment.DbOperatoinFragment;
import baseproject.com.fragment.DrawerFragment;
import baseproject.com.fragment.FireBaseFragment;
import baseproject.com.fragment.HomeFragment;
import baseproject.com.fragment.RetrofitSampleHit;
import baseproject.com.fragment.SocialMediaFragment;
import baseproject.com.utils.ApplicationSnackbar;
import me.leolin.shortcutbadger.ShortcutBadger;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Organization - LPTPL
 * Vaibhav Jain
 */

public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener {

    private static final int DIALOGID = 100;
    private final String TAG = getClass().getSimpleName();
    private FrameLayout content_frame;
    private DrawerFragment drawerFragemnt;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private Fragment mFragment;
    private String title;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        showBadgeCount(2);

        mToolbar.setTitle(TAG);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        // By default this method will replace HomeFragment on MainActivity

        displayView(-1);


        /**
         * Navigation menu commented because of toggle menu icon
         */

        /*

        mToolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_launcher));
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ApplicationSnackbar.showSnackBar(mDrawerLayout, getString(R.string.click_action));
                }
            });

        */

    }

    /**
     * Method to show the badge count on the app icon
     */
    private void showBadgeCount(int badgeCount) {
        ShortcutBadger.applyCount(this, badgeCount);
    }

    /**
     * This will initialize all views
     */

    private void initViews() {
        content_frame = (FrameLayout) findViewById(R.id.content_frame);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragemnt = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.left_menu_fragment);

        // Method for setting up navigation drawer on the fragmnet
        drawerFragemnt.setUp(R.id.left_menu_fragment, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragemnt.setDrawerListener(this);

    }

    /**
     * Method used to replace fragment
     *
     * @param replaceFragment
     */

    private void replaceFragment(Fragment replaceFragment) {
        mFragment = replaceFragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, replaceFragment)
                .addToBackStack(TAG)
                .commit();

        mToolbar.setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    /**
     * Method to perform any action onclick of action menu
     * , always return true if your switch case matches
     * otherwise it will create crash .
     *
     * @param item
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            default:
                ApplicationSnackbar.showSnackBar(mDrawerLayout, item.getTitle()
                        + " " + getResources().getString(R.string.click_action));
                return true;
        }
//        return onOptionsItemSelected(item);

    }


    /**
     * Overrided method of FramentDrawerListner.
     * <p>
     * Perform action here in switch case where you want to navidgate
     *
     * @param view
     * @param position
     */
    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        switch (position) {
            case -1:
                title = "Home";
                replaceFragment(new HomeFragment());
                break;
            case 0:
                title = "Home";
                if (mFragment != null && !(mFragment instanceof HomeFragment))
                    replaceFragment(new HomeFragment());
                break;
            case 1:
                title = "Firebase";
                if (mFragment != null && !(mFragment instanceof FireBaseFragment))
                    replaceFragment(new FireBaseFragment());
                break;
            case 2:
                title = "Social";
                if (mFragment != null && !(mFragment instanceof SocialMediaFragment))
                    replaceFragment(new SocialMediaFragment());
                break;
            case 3:
                title = "DB Operation";
                if (mFragment != null && !(mFragment instanceof DbOperatoinFragment))
                    replaceFragment(new DbOperatoinFragment());
            case 4:
                title = "Retrofit hit";
                if (mFragment != null && !(mFragment instanceof RetrofitSampleHit))
                    replaceFragment(new RetrofitSampleHit());
            default:
                ApplicationSnackbar.showSnackBar(mDrawerLayout, position + " " + getResources().getString(R.string.click_action));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mFragment != null) {
            // Logic is for that we have to pop all fragments which we have pushed
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
            } else
                super.onBackPressed();
        }

    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause ", "onPause called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume ", "onResume called");
    }
}
