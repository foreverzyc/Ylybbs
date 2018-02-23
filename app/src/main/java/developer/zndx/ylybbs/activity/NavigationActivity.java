package developer.zndx.ylybbs.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import developer.zndx.ylybbs.fragment.MainFragment;
import developer.zndx.ylybbs.fragment.MyFragment;
import developer.zndx.ylybbs.R;
import developer.zndx.ylybbs.fragment.SorryFragment;

public class NavigationActivity extends AppCompatActivity {

    private ViewPager mRootPager;
    private MyPagerAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = 0;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    id=0;
                    break;
                case R.id.navigation_dashboard:
                    id=1;
                    break;
                case R.id.navigation_notifications:
                    id=2;
                    break;

            }
            mRootPager.setCurrentItem(id,true);
            return true;
        }

    };

    public class MyPagerAdapter extends FragmentPagerAdapter {

        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return 3;
        }

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            super.finishUpdate(container);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return super.isViewFromObject(view, object);
        }

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new MainFragment();
                case 1:
                    return new SorryFragment();
                case 2:
                    return new MyFragment();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mRootPager = (ViewPager)findViewById(R.id.rootview);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mRootPager.setAdapter(mAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
