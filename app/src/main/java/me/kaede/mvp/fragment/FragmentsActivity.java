package me.kaede.mvp.fragment;

import android.app.DownloadManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import me.kaede.mvp.R;
import me.kaede.mvp.fragment.adapter.MyAdapter;
import me.kaede.mvp.fragment.presenter.ActivityPresenterCompl;
import me.kaede.mvp.fragment.presenter.IActivityPresenter;
import me.kaede.mvp.util.TastUtil;
import me.kaede.mvp.util.TestHuiDiao;

public class FragmentsActivity extends AppCompatActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragments);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		TabLayout tabLayout = (TabLayout) this.findViewById(R.id.tablayout_fragments);
		ViewPager viewPager = (ViewPager) this.findViewById(R.id.viewpager_fragments);
		viewPager.setAdapter(new MyAdapterFrag(getSupportFragmentManager()));
		viewPager.setOffscreenPageLimit(3);
		tabLayout.setupWithViewPager(viewPager);

		IActivityPresenter iActivityPresenter = new ActivityPresenterCompl(this);
		iActivityPresenter.loadDatas();

    }

    //读写流，socket的通信
    private void test(){
        //test
        DownloadManager  downloadManager  = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        //网络请求的uri
        Uri  uri = Uri.parse("");
        DownloadManager.Request  request = new DownloadManager.Request(uri);
       long id  =  downloadManager.enqueue(request);
        try {
            downloadManager.openDownloadedFile(id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // jia yi bin bing wu ji gen xin gui you
        // zi chou yin mou chen shi wu wei shen you xu hai

    }
	public class MyAdapterFrag extends FragmentStatePagerAdapter {
		public String[] pagers = new String[]{"FragmentA","FragmentB","FragmentC"};
		public MyAdapterFrag(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return DemoFragment.newInstance(position);
		}

		@Override
		public int getCount() {
			return pagers.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {

			return pagers[position];
		}
	}

/*

 */
}
