package blockchainvideoapp.com.goviddo.goviddoandroid.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import blockchainvideoapp.com.goviddo.goviddoapp.R;
import blockchainvideoapp.com.goviddo.goviddoapp.coreclass.BackgrounFullLayoutChange;
import blockchainvideoapp.com.goviddo.goviddoapp.fragments.HomeFragment;
import blockchainvideoapp.com.goviddo.goviddoapp.fragments.MovieFragment;
import blockchainvideoapp.com.goviddo.goviddoapp.fragments.OriginalFragment;
import blockchainvideoapp.com.goviddo.goviddoapp.fragments.ShortFilmsFragment;
import blockchainvideoapp.com.goviddo.goviddoapp.fragments.WebSeriesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SwitchCompat switchAB;
    CoordinatorLayout mMainActivityCoordinatorLayout;

    BackgrounFullLayoutChange mBackgrounFullLayoutChange;



    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBackgrounFullLayoutChange = new BackgrounFullLayoutChange();



        mViewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);



        mMainActivityCoordinatorLayout = findViewById(R.id.mainActivityCoordinatorLayout);

        if (BackgrounFullLayoutChange.getFlag() == 2)
        {
            mBackgrounFullLayoutChange.setFlag(2);
            mBackgrounFullLayoutChange.setCoordinatorLayout(mMainActivityCoordinatorLayout,MainActivity.this);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }







    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "Home");
        adapter.addFrag(new MovieFragment(), "Movies");
        adapter.addFrag(new WebSeriesFragment(), "Web Series");
        adapter.addFrag(new ShortFilmsFragment(), "Short Films");
        adapter.addFrag(new OriginalFragment(), "Originals");
        viewPager.setAdapter(adapter);
    }








    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }














    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
