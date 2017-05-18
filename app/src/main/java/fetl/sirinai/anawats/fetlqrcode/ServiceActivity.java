package fetl.sirinai.anawats.fetlqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private ImageView barImageView,qrImageView;
    private ListView listView;
    private String nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Initial View
        initialView();

        //Show Text
        nameString = getIntent().getStringExtra("Login");
        textView.setText(nameString);

    }//Main method

    private void initialView() {
        textView = (TextView) findViewById(R.id.txtNameLogin);
        barImageView = (ImageView) findViewById(R.id.imvBarcode);
        qrImageView = (ImageView) findViewById(R.id.imvQaCode);
        listView = (ListView) findViewById(R.id.livProduct);
    }


} // Main Class
