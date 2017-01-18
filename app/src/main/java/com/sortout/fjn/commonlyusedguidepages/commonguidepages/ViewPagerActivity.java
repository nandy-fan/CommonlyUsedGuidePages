package com.sortout.fjn.commonlyusedguidepages.commonguidepages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.sortout.fjn.commonlyusedguidepages.R;
import com.sortout.fjn.commonlyusedguidepages.commonguidepages.widget.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager 引导 com.madi.applicant.ui.navigationPages.ViewPagerActivity
 * https://github.com/THEONE10211024/CircleIndicator
 * Usage

 xml:

 <pers.medusa.circleindicator.widget.CircleIndicator
 android:layout_width="match_parent"
 android:layout_height="40dp"
 android:layout_centerVertical="true"
 android:id="@+id/indicator"
 CircleIndicator:ci_background="@android:color/white"
 CircleIndicator:ci_selected_background="0xffe6454a"
 CircleIndicator:ci_mode="outside"
 CircleIndicator:ci_gravity="center"
 CircleIndicator:ci_radius="10dp"
 CircleIndicator:ci_margin="5dp"
 />
 java:

 circleIndicator.setViewPager(viewPager);
 */
public class ViewPagerActivity extends FragmentActivity {
	private ViewPager mVPActivity;
	private GuideFragmentOne mFragmentOne;
	private GuideFragmentTwo mFragmentTwo;
	private GuideFragmentThree mFragmentThree;
	private CircleIndicator circleIndicator;

	private List<Fragment> mListFragment = new ArrayList<Fragment>();
	private PagerAdapter mPgAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager);
		initView();
	}

	private void initView() {
		mVPActivity = (ViewPager) findViewById(R.id.vp_activity);
		circleIndicator = (CircleIndicator) findViewById(R.id.indicators);

		mFragmentOne = new GuideFragmentOne();
		mFragmentTwo = new GuideFragmentTwo();
		mFragmentThree = new GuideFragmentThree();
		mListFragment.add(mFragmentOne);
		mListFragment.add(mFragmentTwo);
		mListFragment.add(mFragmentThree);
		mPgAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mListFragment);
		mVPActivity.setAdapter(mPgAdapter);
		circleIndicator.setViewPager(mVPActivity);
	}

}
