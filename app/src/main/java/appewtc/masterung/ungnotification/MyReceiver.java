package appewtc.masterung.ungnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by masterUNG on 6/10/2016 AD.
 */
public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1 = new Intent(context, ShowNotification.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);

    }   // onReceive

}   // Main Class
