package fetl.sirinai.anawats.fetlqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    //Explicit
    private EditText nameEditText, userEditext, passEditText; //ประเภทตัวแปร ชื่อตัวแปร&ประเภทตัวแปร
    private ImageView imageView;
    private Button button;
    private String nameString, userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initial View
        initialView();
        //Controller
        controller();


    } // Main Method

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    private void controller() {
        imageView.setOnClickListener(RegisterActivity.this);
        button.setOnClickListener(RegisterActivity.this);
    }

    private void initialView() {
        nameEditText = (EditText) findViewById(R.id.edtName);
        userEditext = (EditText) findViewById(R.id.edtUser);
        passEditText = (EditText) findViewById(R.id.edtPassword);

        imageView = (ImageView) findViewById(R.id.btnBack);
        button = (Button) findViewById(R.id.btnNewRegis);
    }


    @Override
    public void onClick(View v) {

        //For Back
        if (v == imageView) {
            finish();
        }

        //For button
        if (v == button) {
            //Get Value from EditText
            nameString = nameEditText.getText().toString().trim();
            userString = userEditext.getText().toString().trim();
            passwordString = passEditText.getText().toString().trim();

            // Check Space
            if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                // (have Space)
                MyAlert myAlert = new MyAlert(this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                        getResources().getString(R.string.massage_HaveSpace));

            } else {
                //(NO Space)


            }


        }

    }
} //Main Class
