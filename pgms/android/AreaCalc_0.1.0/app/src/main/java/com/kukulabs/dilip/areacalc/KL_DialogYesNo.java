package com.kukulabs.dilip.areacalc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.preference.Preference;

/**
 * Created by Dilip on 8/8/2014.
 */
public class KL_DialogYesNo {
    public Runnable yes = null, no = null;

    public boolean Confirm(Activity act, String msgTitle, String confirmText,
                           String yesButtonCaption, String noButtonCaption, Runnable yesProc, Runnable noProc ) {
        yes = yesProc;
        no = noProc;
        new AlertDialog.Builder(act)
                .setTitle(msgTitle)
                .setMessage(confirmText)
                .setCancelable(false)
                .setPositiveButton(yesButtonCaption, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        yes.run();
                    }
                }).setNegativeButton(noButtonCaption, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                no.run();
            }
        }).setIcon(android.R.drawable.ic_dialog_alert).show();
        return true;
    }
}
