package com.cookandroid.project14_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.EditText;
import android.widget.ImageView;

public class MyReceiver extends BroadcastReceiver {
    Context context;
    ImageView ivBattery;
    EditText edtBattery;

    public MyReceiver(Context c) {
        context = c;
        ivBattery = (ImageView) ((MainActivity) context).findViewById(R.id.ivBattery);
        edtBattery = (EditText) ((MainActivity) context).findViewById(R.id.edtBattery);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
            int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            edtBattery.setText("현재 배터리 잔량 : " + remain + "\n");

            if (remain >= 90)
                ivBattery.setImageResource(R.drawable.battery_100);
            else if (remain >= 80)
                ivBattery.setImageResource(R.drawable.battery_80);
            else if (remain >= 60)
                ivBattery.setImageResource(R.drawable.battery_60);
            else if (remain >= 20)
                ivBattery.setImageResource(R.drawable.battery_20);
            else
                ivBattery.setImageResource(R.drawable.battery_0);

            int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
            switch (plug) {
                case 0:
                    edtBattery.append("전원 연결 안됨");
                    break;
                case BatteryManager.BATTERY_PLUGGED_AC:
                    edtBattery.append("전원 연결: 어댑터 연결됨");
                    break;
                case BatteryManager.BATTERY_PLUGGED_USB:
                    edtBattery.append("전원 연결: USB 전원 연결됨");
                    break;
            }
        }
    }
}