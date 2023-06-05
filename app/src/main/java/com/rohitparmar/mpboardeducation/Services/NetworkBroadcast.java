package com.rohitparmar.mpboardeducation.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;


public class NetworkBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        if (!isNetworkConnected(context)){

            View view = LayoutInflater.from(context).inflate(R.layout.no_internet_connection_lay,null);
            AlertDialog alertDialog = new AlertDialog.Builder(context).setView(view)
                    .setCancelable(false)
                    .create();
            alertDialog.show();



            Button tryAgainBtn = view.findViewById(R.id.tryAgainBttn);

            tryAgainBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isNetworkConnected(context)){
                        alertDialog.dismiss();
                    }
                }
            });

        }

    }
    private  boolean isNetworkConnected(Context context){

        try{

            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null & networkInfo.isConnected();

        }catch (Exception e){
            e.printStackTrace();
            return false ;
        }

    }

}
