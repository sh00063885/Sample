package sample.masaibar.filtersample;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class FilterService extends Service {

    private View mView;
    private WindowManager mWindowManager;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        LayoutInflater layoutInflater = LayoutInflater.from(this);

        //重ねあわせするViewの設定
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,      //オーバーレイヤーに設定
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT                              //ウインドウの透明化
        );

        //WindowManagerを取得
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        //レイアウトファイルから重ねあわせするViewを作成
        mView = layoutInflater.inflate(R.layout.filter, null);

        //透過率80の黒色のフィルターを指定
        //パラメータは左から(透過率,R,G,B) ココをいじれば任意のフィルターに変更可能
        mView.setBackgroundColor(Color.argb(80, 0, 0, 0));

        //Viewを画面上に重ねあわせする
        mWindowManager.addView(mView, layoutParams);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mWindowManager.removeView(mView);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
