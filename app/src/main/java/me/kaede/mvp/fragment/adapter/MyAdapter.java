package me.kaede.mvp.fragment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.kaede.mvp.R;
import me.kaede.mvp.fragment.presenter.IFragmentPresenter;
import me.kaede.mvp.util.TestHuiDiao;
import me.kaede.mvp.util.TestInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaede on 2015/10/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	List<String> datas;
	IFragmentPresenter iFragmentPresenter;
     Context  mActivity;
	public MyAdapter(IFragmentPresenter iFragmentPresenter) {
		this.iFragmentPresenter = iFragmentPresenter;
		this.datas = new ArrayList<>();

	}

	public void setDatas(List<String> datas){
		if (datas != null && datas.size() > 0){
			this.datas.clear();
			this.datas.addAll(datas);
			notifyDataSetChanged();
		}
	}

	public String getItem(int position){
		return datas.get(position);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, final int position) {
		holder.mTextView.setText(datas.get(position));
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				iFragmentPresenter.onItemClick(position);
				setData="--"+position+datas.get(position);
				notifyDataSetChanged();

			}
		});
	}

	@Override
	public int getItemCount() {
		return datas.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public TextView mTextView;
		public ViewHolder(View v) {
			super(v);
			mTextView = (TextView) v.findViewById(R.id.tv_recyclerview_item);
		}
	}

	public   String setData = "13545007115";
	public  class fraCall{
		public String info = "";
		public TestHuiDiao mphoneI;
		public  void setCallBack(TestHuiDiao  phoneI){
			mphoneI = phoneI;
		}

		public  void doPlayphone(){
			info = setData;
			mphoneI.playPhone(info);
		}
	}

	public class  Inter{
	    public String  info="";
	    public TestInterface  testInterface;

        public Inter(TestInterface testInterface) {
            this.testInterface = testInterface;
        }

        public void doPlay(){
            testInterface.playGame("who is that");
        }
    }
}


