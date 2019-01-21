package me.kaede.mvp.outteradapter.view;

import android.app.Activity;

import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public interface IAdapterView {
	 void onGetDataList(List<String> datas);
	 void onLoadMoreData(String item,int position);
	 void toast(String msg);
	 Activity onGetActivity();
	 void onShowFooterView(Boolean isShow);
	 void onShowTag(int isShow);
    void onGetTagList(List<Integer> datas);
    void onDeleteData(int position);
}
