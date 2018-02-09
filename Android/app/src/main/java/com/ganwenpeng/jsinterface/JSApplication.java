package com.ganwenpeng.jsinterface;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;


public class JSApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initLogger();
    }

    /**
     * 初始化日志框架
     */
    private void initLogger() {
        // 格式化log，添加全局tag【tugou-log】，查看日志时筛选 tugou-log即可
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag("jsinterface-log")
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
        Logger.d("initing");
    }
}
