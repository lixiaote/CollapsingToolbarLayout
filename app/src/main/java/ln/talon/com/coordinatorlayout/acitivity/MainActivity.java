package ln.talon.com.coordinatorlayout.acitivity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import ln.talon.com.coordinatorlayout.R;
import ln.talon.com.coordinatorlayout.fragment.FirstFragment;
import ln.talon.com.coordinatorlayout.fragment.SecondFragment;
import ln.talon.com.coordinatorlayout.fragment.ThirdFragment;
import ln.talon.com.coordinatorlayout.fragment.dummy.FourthFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static final int ViewPagerCount = 4;
    private LayoutInflater layoutInflater;
    private String[] tabs = {"first", "second", "third", "fourth"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutInflater = LayoutInflater.from(this);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.ucvp);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(getTabItemView(i));
        }

    }
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tabview, null);
        TextView textView = (TextView) view.findViewById(R.id.tabname);
        textView.setText(tabs[index]);
        return view;
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = FirstFragment.newInstance(12);
                    break;
                case 1:
                    fragment = SecondFragment.newInstance(30);
                    break;
                case 2:
                    fragment = ThirdFragment.newInstance(21);
                    break;
                case 3:
                    fragment = FourthFragment.newInstance(14);
                    break;

            }
            return fragment;
        }

        @Override
        public int getCount() {
            return ViewPagerCount;
        }
    }
}
