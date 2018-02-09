package com.ganwenpeng.jsinterface.page.jsbridge;

import com.ganwenpeng.jsinterface.page.base.BasePresenterInterface;
import com.ganwenpeng.jsinterface.page.base.BaseView;

interface JsBricgeContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenterInterface {

    }
}
