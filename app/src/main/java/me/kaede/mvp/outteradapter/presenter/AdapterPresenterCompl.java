package me.kaede.mvp.outteradapter.presenter;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import me.kaede.mvp.outteradapter.view.IAdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public class AdapterPresenterCompl implements IAdapterPresenter {
	List<String> datas;
	List<Integer> tags;
	IAdapterView iAdapterView;

	public AdapterPresenterCompl(IAdapterView iAdapterView) {
		this.iAdapterView = iAdapterView;
	}

	@Override
	public void loadDatas() {
		String[] countries = new String[]{"Kaede Akatsuki","Loves","Neko Tattsun","Deeply"};
		datas = new ArrayList<>();
		tags = new ArrayList<>();

		for (String item:countries){
			datas.add(item);
		}

		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				iAdapterView.onGetDataList(datas);
			}
		}, 500);

	}

	@Override
	public void loadMoreData(final String item, final int po) {
		showFooterView(true);
		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				iAdapterView.onLoadMoreData(item,po);
				iAdapterView.onShowTag(po);
			}
		}, 500);
	}

	@Override
	public Activity getActivity() {
		return iAdapterView.onGetActivity();
	}

	@Override
	public void showFooterView(Boolean isShow) {
		iAdapterView.onShowFooterView(isShow);
	}

	@Override
	public void setTag(int position) {

	}

	@Override
	public void deleteData(final int position) {
        showFooterView(true);
		Handler handler = new Handler(Looper.getMainLooper());
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				iAdapterView.onDeleteData(position);
                iAdapterView.onShowTag(position);
			}
		}, 500);
	}


}
