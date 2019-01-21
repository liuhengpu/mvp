package me.kaede.mvp.home.view;

import java.util.List;

/**
 * Created by kaede on 2015/5/19.
 */
public interface IHomeView {
	 void onGetDataList(List<String> datas);
	 void toast(String msg);

}
