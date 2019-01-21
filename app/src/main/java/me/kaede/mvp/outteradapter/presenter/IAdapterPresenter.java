package me.kaede.mvp.outteradapter.presenter;

import android.app.Activity;

/**
 * Created by kaede on 2015/5/19.
 */
public interface IAdapterPresenter {
	 void loadDatas();
	 void loadMoreData(String item,int position);
	 Activity getActivity();
	 void showFooterView(Boolean isShow);
	 void setTag(int position);
	void deleteData(int position);
}
