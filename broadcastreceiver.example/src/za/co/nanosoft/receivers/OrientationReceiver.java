package za.co.nanosoft.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class OrientationReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "The phone has been rotated", Toast.LENGTH_LONG).show();
		
	}
	

}
