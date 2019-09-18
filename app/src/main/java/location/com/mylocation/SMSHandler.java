package location.com.mylocation;

import android.app.Activity;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by ahmad on 1/10/2018.
 */

public class SMSHandler {
    private String message = null;
    private String contactNumber = null;
    public static SMSHandler INSTANCE = new SMSHandler();
    private Activity activity;
    private SmsManager sms;

    public void newMessage(Activity activity, String message, String contactNumber){
        this.activity = activity;
        this.message = message;
        this.contactNumber = contactNumber;
    }

    public void send(){
        if(message.isEmpty() || contactNumber.isEmpty()){
            return;
        }

        sms = SmsManager.getDefault();
        sms.sendTextMessage(contactNumber, null, message, null, null);
        return;
    }
}
