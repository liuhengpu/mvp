package me.kaede.mvp.fragment.view;

import android.app.Activity;

/**
 * Created by kaede on 2015/5/19.
 */
public interface IFragmentView {
	Activity getActivity();
	void onItemClick(int position);
}
