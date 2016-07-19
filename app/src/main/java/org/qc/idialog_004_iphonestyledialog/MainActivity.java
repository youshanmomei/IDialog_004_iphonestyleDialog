package org.qc.idialog_004_iphonestyledialog;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_sigleok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomMessageOk("Confirmation", "Just click to continue !");
            }
        });

        findViewById(R.id.btn_okcancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Alert", "Are you sure you want continue ?");
            }
        });
    }

    /**
     *
     * @param sTitle
     *          title for dialog
     * @param sMsg
     *          msg for body
     */
    private void showMessage(String sTitle, String sMsg) {
        final Dialog dialog = new Dialog(MainActivity.this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.view_okdialogview);


        TextView tvOkDialogTtitle = (TextView) dialog.findViewById(R.id.tv_okdialog_title);
        TextView tvOkDialogMsg = (TextView) dialog.findViewById(R.id.tv_okdialog_msg);
        Button btnOkDialogOk = (Button) dialog.findViewById(R.id.btn_okdialog_ok);

        tvOkDialogTtitle.setText(sTitle);
        tvOkDialogTtitle.setTextColor(Color.WHITE);
        tvOkDialogMsg.setText(sMsg);
        tvOkDialogMsg.setTextColor(Color.WHITE);
        btnOkDialogOk.setTextColor(Color.WHITE);
        btnOkDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //write your code to do things after users clicks ok
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    /**
     * it will show the ok/cancel dialog like iphone
     * make sure no keyword is visible
     * @param sTitle
     *          title for dialog
     * @param sMsg
     *          msg for body
     */
    private void showCustomMessageOk(String sTitle, String sMsg) {
        final Dialog dialog = new Dialog(MainActivity.this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.view_okcanceldialogview);

        ((TextView)dialog.findViewById(R.id.dialog_title)).setText(sTitle);
        ((TextView)dialog.findViewById(R.id.dialog_message)).setText(sMsg);

        Button btnOk = (Button) dialog.findViewById(R.id.btn_ok);
        btnOk.setTextColor(getResources().getColor(R.color.white));
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //write your code to do things after users click
                //ok
                dialog.dismiss();
            }
        });

        Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btnCancel.setTextColor(getResources().getColor(R.color.white));
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //write your code to do things after users click
                //cancel
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}
