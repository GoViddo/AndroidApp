package blockchainvideoapp.com.goviddo.goviddo.activity;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import blockchainvideoapp.com.goviddo.goviddo.Fragments.HomeFragment;
import blockchainvideoapp.com.goviddo.goviddo.Fragments.OthersFragment;
import blockchainvideoapp.com.goviddo.goviddo.Fragments.SearchFragment;
import blockchainvideoapp.com.goviddo.goviddo.Fragments.SubscriptionFragment;
import blockchainvideoapp.com.goviddo.goviddo.R;

public class HomeActivity extends AppCompatActivity {



    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private int[] mTabIcons;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mTabIcons = new int[]{
                R.mipmap.ic_account_balance_24px,
                R.mipmap.musica_searcher,
                R.mipmap.video_camera,
                R.mipmap.ic_view_headline_24px
        };




        mViewPager =  findViewById(R.id.container);
        setupViewPager(mViewPager);

        mTabLayout =  findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new SearchFragment(), "Search");
        adapter.addFragment(new SubscriptionFragment(), "Subscription");
        adapter.addFragment(new OthersFragment(), "Other");
        viewPager.setAdapter(adapter);



    }


    private void setupTabIcons() {

       /* View view1 = getLayoutInflater().inflate(R.layout.custom_tablayout_image, null);
        view1.findViewById(R.id.icon).setBackgroundResource(mTabIcons[0]);
        mTabLayout.getTabAt(0).setCustomView(view1);*/

        mTabLayout.getTabAt(0).setIcon(mTabIcons[0]);
        mTabLayout.getTabAt(1).setIcon(mTabIcons[1]);
        mTabLayout.getTabAt(2).setIcon(mTabIcons[2]);
        mTabLayout.getTabAt(3).setIcon(mTabIcons[3]);
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

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }


}


