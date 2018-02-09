package com.ganwenpeng.jsinterface.page.jsbridge;

import android.support.annotation.NonNull;

import com.ganwenpeng.jsinterface.page.base.BasePresenterInterface;
import com.ganwenpeng.jsinterface.page.base.BaseView;

interface JsBridgeContract {
    interface View extends BaseView<Presenter> {
        /**
         * 渲染页面
         *
         * @param url HTML链接
         */
        void renderUrl(@NonNull final String url);

        /**
         * 以桥接的方式发送消息到嵌入页
         * @param message 被发送的消息
         */
        void bridgeShowMessage(@NonNull final String message);

        /**
         * 以桥接的方式从嵌入页获取消息
         * @param message 获取消息时传给嵌入页的参数
         */
        void bridgeGetMessage(@NonNull final String message);
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
