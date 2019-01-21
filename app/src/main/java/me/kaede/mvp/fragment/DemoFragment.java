package me.kaede.mvp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import de.greenrobot.event.EventBus;
import me.kaede.mvp.R;
import me.kaede.mvp.fragment.adapter.MyAdapter;
import me.kaede.mvp.fragment.event.FragmentGetDatasEvent;
import me.kaede.mvp.fragment.presenter.FragmentPresenterCompl;
import me.kaede.mvp.fragment.presenter.IFragmentPresenter;
import me.kaede.mvp.fragment.view.IFragmentView;
import me.kaede.mvp.util.TestHuiDiao;


public class DemoFragment extends Fragment implements IFragmentView,TestHuiDiao {
	private static final String BUNDLE_INDEX = "BUNDLE_INDEX";

	private int index;

	private MyAdapter adapter;
	private IFragmentPresenter iFragmentPresenter;


	public static DemoFragment newInstance(int index) {
		DemoFragment fragment = new DemoFragment();
		Bundle args = new Bundle();
		args.putInt(BUNDLE_INDEX, index);
		fragment.setArguments(args);
		return fragment;
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			index = getArguments().getInt(BUNDLE_INDEX);
		}
	}
     private  MyAdapter.fraCall call;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_demo, container, false);

		//register
		EventBus.getDefault().register(this);

		//find view
		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_home);

		//init
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		iFragmentPresenter = new FragmentPresenterCompl(this);
		adapter = new MyAdapter(iFragmentPresenter);
		recyclerView.setAdapter(adapter);

		call = adapter.new fraCall();
		call.setCallBack(this);

		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}


	@Override
	public void onItemClick(int position) {
		Toast.makeText(getActivity(),"Tab "+index+" : "+(String)adapter.getItem(position),Toast.LENGTH_SHORT).show();

        //测试接口回调
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                call.doPlayphone();
            }
        });
	}

	// EventBus Subscribe
	public void onEvent(FragmentGetDatasEvent getDatasEvent){
		if (getDatasEvent!=null && getDatasEvent.getDatas()!=null && getDatasEvent.getDatas().size()>0){
			adapter.setDatas(getDatasEvent.getDatas());
		}
	}


	@Override
	public void playPhone(String number) {
		Log.e("liu1","number--"+number);
	}
}
