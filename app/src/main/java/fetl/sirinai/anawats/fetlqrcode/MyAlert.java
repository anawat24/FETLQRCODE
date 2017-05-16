package fetl.sirinai.anawats.fetlqrcode;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Anawat.S on 16/05/2017.
 */

public class MyAlert {

    //Explicit ระกาศตัวแปร
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle,String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.mipmap.ic_user);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();


            }
        });
        builder.show();
    }



} // Main Class
