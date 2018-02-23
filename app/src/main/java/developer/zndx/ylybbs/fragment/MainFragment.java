package developer.zndx.ylybbs.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;

import developer.zndx.ylybbs.R;

public class MainFragment extends Fragment {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    private RollPagerView mRollPagerView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.activity_main, container, false);




        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) mainView.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);



        TabLayout tabLayout = (TabLayout)mainView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        mRollPagerView = (RollPagerView)mainView.findViewById(R.id.rollpage);
        mRollPagerView.setAdapter(new TestLoopAdapter(mRollPagerView));
        mRollPagerView.setHintView(new ColorPointHintView(getActivity(),R.color.backgroundTitle,Color.WHITE));
        return mainView;

    }

    private class TestLoopAdapter extends LoopPagerAdapter {
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }



/////////////////////////////////////////////////////////////////////////////////////////
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class TwoFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public TwoFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static TwoFragment newInstance() {
            TwoFragment fragment = new TwoFragment();

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View twoView = inflater.inflate(R.layout.fragment_two, container, false);
            return twoView;
        }
    }

///////////////////////////////////////////////////////////////////////////////////////
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class ThreeFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public ThreeFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ThreeFragment newInstance() {
            ThreeFragment fragment = new ThreeFragment();

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View threeView = inflater.inflate(R.layout.fragment_three, container, false);
            return threeView;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class FourFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public FourFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FourFragment newInstance() {
            FourFragment fragment = new FourFragment();

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View fourView = inflater.inflate(R.layout.fragment_four, container, false);
            return fourView;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class FifthFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public FifthFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FifthFragment newInstance() {
            FifthFragment fragment = new FifthFragment();

            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View fifthView = inflater.inflate(R.layout.fragment_fifth, container, false);
            return fifthView;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return PlaceholderFragment.newInstance(position + 1);
                case 1:
                    return TwoFragment.newInstance();
                case 2:
                    return ThreeFragment.newInstance();
                case 3:
                    return FourFragment.newInstance();
                case 4:
                    return FifthFragment.newInstance();

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "全部";
                case 1:
                    return "前哨站";
                case 2:
                    return "云麓商城";
                case 3:
                    return "云麓小镇";
                case 4:
                    return "云麓知道";
            }
            return null;
        }
    }


}


