package com.ganwenpeng.jsinterface.page.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ganwenpeng.jsinterface.R;
import com.ganwenpeng.jsinterface.model.home.bean.HomeItemBean;
import com.ganwenpeng.jsinterface.page.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author gangan
 */
public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {
    @BindView(R.id.tv_toolbar_title)
    TextView mTvToolbarTitle;
    @BindView(R.id.img_toolbar_back)
    ImageView mImgToolbarBack;
    @BindView(R.id.recycle_content)
    RecyclerView mRecycleContent;

    private HomeTableAdapter mHomeTableAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mUnbinder = ButterKnife.bind(this, view);

        setupUI();
        return view;
    }

    private void setupUI() {
        mTvToolbarTitle.setText("Android & H5 交互");

        mRecycleContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomeTableAdapter = new HomeTableAdapter();
        mRecycleContent.setAdapter(mHomeTableAdapter);
        mHomeTableAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.clickItem(position);
            }
        });
    }

    @Override
    public void render(ArrayList<HomeItemBean> list) {
        mHomeTableAdapter.setNewData(list);
        mHomeTableAdapter.notifyDataSetChanged();
    }

    private class HomeTableAdapter extends BaseQuickAdapter<HomeItemBean, BaseViewHolder> {
        HomeTableAdapter() {
            super(R.layout.layout_home_item);
        }

        @Override
        protected void convert(BaseViewHolder helper, HomeItemBean item) {
            helper.setText(R.id.tv_jscallnative_value, item.getJsCallNative())
                    .setText(R.id.tv_nativecalljs_value, item.getNativeCallJs());
        }
    }

}
