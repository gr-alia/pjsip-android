package net.gotev.sipservice.client.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.gotev.sipservice.R
import net.gotev.sipservice.SipAccountData
import net.gotev.sipservice.SipServiceCommand

class MainActivity : AppCompatActivity() {

    var username: String = ""
    var pass: String = ""
    var host: String = ""
    var numberToCall: String = ""

    val sipAccount = SipAccountData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SipServiceCommand.setEncryption(this, true, "keys_alias")

        login_btn.setOnClickListener {
            extractData()

            sipAccount.password = pass
            sipAccount.username = username
            sipAccount.host = host
            sipAccount.realm = "*"
            SipServiceCommand.setAccount(this, sipAccount)

        }
        make_call_btn.setOnClickListener{

            SipServiceCommand.makeCall(this, sipAccount.idUri, numberToCall)
        }

        end_call_btn.setOnClickListener{

        }
    }

    private fun extractData(){
        username = username_et.text.toString()
        pass = pas_et.text.toString()
        host = host_et.text.toString()
        numberToCall = callee_et.text.toString()
    }
}
