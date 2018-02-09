package com.ganwenpeng.jsinterface.page.intercept;

import android.support.annotation.NonNull;

import com.ganwenpeng.jsinterface.page.base.BasePresenterInterface;
import com.ganwenpeng.jsinterface.page.base.BaseView;

interface InterceptContract {
    interface View extends BaseView<Presenter> {
        /**
         * 渲染页面
         *
         * @param url HTML链接
         */
        void renderUrl(@NonNull final String url);

        /**
         * 执行JS
         * @param js js代码
         */
        void execJavaScript(@NonNull final String js);
    }

    interface Presenter extends BasePresenterInterface {
        /**
         * 点击按钮1
         */
        void clickBtn1();

        /**
         * 点击按钮2
         */
        void clickBtn2();
    }
}
