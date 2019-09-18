package location.com.mylocation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class SetNumberDialog extends Dialog implements
        View.OnClickListener {

    public Activity c;
    private EditText tvNumber;
    private Button btnCancel, btnUpdate;

    public SetNumberDialog(Activity a) { //constructor
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //to remove default title from dialog box
        setContentView(R.layout.dialog_set_number);
        tvNumber = (EditText) findViewById(R.id.tvNumber);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnUpdate = (Button) findViewById(R.id.btnupdate);
        btnCancel.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel:
                dismiss();
                break;
            case R.id.btnupdate:
                String number = tvNumber.getText().toString().trim();
                Intent it = new Intent(c, ActivityMain.class);
                it.putExtra("number", number);
                getContext().startActivity(it);
                break;
            default:
                break;
        }
        dismiss();
    }
}
