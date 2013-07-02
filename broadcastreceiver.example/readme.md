##Broadcast Receiver Example

In this example code we investigate what a broadcast receiver app is and how to implement on on the android platform.

A broadcast receiver is an android component or piece of application that responds to a system wide announcement. 
This announcement could typically be a call or sms being received by the phone.

###Create an android project
We create an android project by file > new > other > Android > Android Application Project.
Give the project the relevant information and create a main activity. Even for a broadcast receiver this is 
needed.

Run the application as an android application to make sure the application is copied to the phone and runs on
the phone.


###Create a Broadcastreceiver for Phone orientation.
We are going to create a broadcastreceiver for when the user orientates the phone. Create a class that looks like 


```java
package za.co.nanosoft.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OrientationReceiver extends BroadcastReceiver {

  @Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
	}
	

}
```
