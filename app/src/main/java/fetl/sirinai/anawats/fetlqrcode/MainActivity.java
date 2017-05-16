package fetl.sirinai.anawats.fetlqrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit ประกาศตัวแปร
    private EditText userEditText, passwordEditText; // private ประเภทออฟเจ็ค ชื่อ+ประประเภทออฟเจ็ค(userEditText)
    private TextView textView;
    private Button button;


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


        }


    }
}   //Main Class
