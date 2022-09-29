package com.mutualmobile.swiggy_clone.ui.screens.payment
import androidx.lifecycle.ViewModel
import com.mutualmobile.swiggy_clone.R
import com.mutualmobile.swiggy_clone.models.OtherPayment

class PaymentsViewModel :  ViewModel(){

  fun getPaymentsList(): MutableList<OtherPayment> {
    val list = mutableListOf<OtherPayment>()

    list.add(OtherPayment(R.drawable.wallet_24,"Wallet","Paytm, PhonePe, Amazon Pay & more"))
    list.add(OtherPayment(R.drawable.wallet_24,"Sodexo","Sodexo card valid only on instamart"))
    list.add(OtherPayment(R.drawable.wallet_24,"Netbanking","Select from list of banks"))
    list.add(OtherPayment(R.drawable.wallet_24,"Pay Later","LazyPay lets order now and Pay later"))
    list.add(OtherPayment(R.drawable.wallet_24,"CRED Pay","Pay using credi cards saved on CRED"))
    list.add(OtherPayment(R.drawable.wallet_24,"Pay on Delivery","Pay with cash"))

    return list
  }

}