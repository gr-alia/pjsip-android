package net.gotev.sipservice.client

import android.widget.Toast
import net.gotev.sipservice.BroadcastEventReceiver
import net.gotev.sipservice.Logger

class CallReceiver : BroadcastEventReceiver() {

    override fun onIncomingCall(accountID: String?, callID: Int, displayName: String?, remoteUri: String?, isVideo: Boolean) {

    }
}