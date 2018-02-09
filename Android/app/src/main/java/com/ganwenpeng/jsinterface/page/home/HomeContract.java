package com.ganwenpeng.jsinterface.page.home;

import com.ganwenpeng.jsinterface.model.home.bean.HomeItemBean;
import com.ganwenpeng.jsinterface.page.base.BasePresenterInterface;
import com.ganwenpeng.jsinterface.page.base.BaseView;

import java.util.ArrayList;

interface HomeContract {
    interface View extends BaseView<Presenter> {
        /**
         * 渲染界面
         * @param list 首页列表的每一行对应的bean
         */
        void render(final ArrayList<HomeItemBean> list);
    }

    interface Presenter extends BasePresenterInterface {
        /**
         * 点击了某一行，通知presenter
         * @param position 点击了哪里行？从0开始
         */
        void clickItem(final int position);
    }
}
