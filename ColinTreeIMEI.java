/**
 * @author ColinTree (colinycl123@gmail.com)
 */

package cn.colintree.aix;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;

import android.telephony.TelephonyManager;
import android.telephony.CellLocation;     
import android.telephony.PhoneStateListener;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = ColinTreeIMEI.VERSION,
    description = "by ColinTree at http://aix.colintree.cn",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")

@SimpleObject(external = true)
@UsesPermissions(permissionNames = "android.permission.READ_PHONE_STATE")

public class ColinTreeIMEI extends AndroidNonvisibleComponent
implements Component {
    public static final int VERSION = 1;
    private ComponentContainer container;
    private Context context;
    private static final String LOG_TAG = "ColinTreeIMEI";
    public ColinTreeIMEI(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context();
        Log.d(LOG_TAG, "ColinTreeIMEI Created" );
    }
    /**
     * Return IMEI
     */
    @SimpleFunction(description = "返回 IMEI(GSM手机)或MEID(CDMA手机)<br/>Return IMEI(phone with GSM)or MEID(phone with CDMA)")
    public String GetDeviceID() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }
}