package fetl.sirinai.anawats.fetlqrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit ประกาศตัวแปร
    private EditText userEditText, passwordEditText; // private ประเภทออฟเจ็ค ชื่อ+ประประเภทออฟเจ็ค(userEditText)
    private TextView textView;
    private Button button;

    //Login Page
    private  String userString, passwordString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial View ผูกความสัมพันธ์ ออฟเจ็กกับตัวแปรให้เป็นตัวเดียวกัน
        initialview();

        //controller ปุ่มควบคุม
        controller(); //สร้าง Method alt+Enter ในวงเล็บ


    } //Main Method

    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);
    }

    private void initialview() {
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtRegis);
        button = (Button) findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View v) {

        //for TextView
        if (v== textView) {
            //Intent to Register
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class); // สร้าง Intent
            startActivity(intent);
        }

        //for Button
        if (v==button) {

            //Get Value from Edit text
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            //Check Space
            if (userString.equals("") || passwordString. equals("")) {
                //Have Space
                MyAlert myAlert = new MyAlert(this);
                myAlert.myDialog(getResources().getString(R.string.title_HaveSpace),
                        getResources().getString(R.string.massage_HaveSpace));

            } else {
                //NO space
                checkUserAnPass();




            }



        }


    }

    private void checkUserAnPass() {

        try {
            GetData getData = new GetData(this);
            MyConstant myConstant = new MyConstant();
            getData.execute(myConstant.getUslGetUser());
            String strJSON = getData.get();
            Log.d("17MayV2", "JSON ===>" + strJSON);
          //showMessage(strJSON);


            JSONArray jsonArray = new JSONArray(strJSON);
            boolean b = true; // User False
            String strName = null, strPassword=null;
            MyAlert myAlert = new MyAlert(this);

            for (int i =0;i< jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString("User"))) {
                    b = false;
                    strName = jsonObject.getString("Name");
                    strPassword = jsonObject.getString("Password");

                }
            }// For

            if (b) {
                //User Flase
                myAlert.myDialog(getResources().getString(R.string.title_userFalse),
                        getResources().getString(R.string.massage_UserFalse));

            } else if (passwordString.equals(strPassword)) {
                //Password Ture
                Toast.makeText(this, getString(R.string.welcome)+ strName, Toast.LENGTH_SHORT).show();

                //Intent to Service เปิดหน้าใหม่โยนค่าไปด้วย
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                intent.putExtra("Login", strName); //โยนค่า
                startActivity(intent);
                finish();

            } else {
                //Passowrd Flase
                myAlert.myDialog(getResources().getString(R.string.title_PasswordFalse),
                        getResources().getString(R.string.massage_PasswordFalse ));

            }




        } catch (Exception e) {
            Log.d("17MayV2", "e checkUser ===>" + e.toString());

        }

    }

    private void showMessage(String strJSON) {
        Toast.makeText(this, strJSON, Toast.LENGTH_SHORT).show();
    }
}   //Main Class
