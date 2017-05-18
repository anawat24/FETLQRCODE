package fetl.sirinai.anawats.fetlqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private TextView textView;
    private ImageView barImageView, qrImageView;
    private ListView listView;
    private String nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Initial View
        initialView();

        //Show Text
        showText();


        //Create List view
        createListView();


    }//Main method

    private void createListView() {

        try {
            MyConstant myConstant = new MyConstant();
            String urlJSON = myConstant.getUrlGetProduct();

            GetData getData = new GetData(this);
            getData.execute(urlJSON);
            String strJSON = getData.get();
             Log.d("18MayV1", "JSON ===> " + strJSON);
           // Toast.makeText(this, strJSON, Toast.LENGTH_SHORT).show();
            JSONArray jsonArray = new JSONArray(strJSON);
            int i = jsonArray.length();
            String[] iconStrings = new String[i];
            String[] titleStrings = new String[i];
            String[] detailStrings = new String[i];

            for (int i1 = 0; i1 < i; i1++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i1);
                iconStrings[i1] = jsonObject.getString("Image");
                titleStrings[i1] = jsonObject.getString("Produce");
                detailStrings[i1] = jsonObject.getString("Detail");
            }// For
            MyAdapter myAdapter = new MyAdapter(this, iconStrings, titleStrings, detailStrings);
            listView.setAdapter(myAdapter);



        } catch (Exception e) {

            Log.d("18MayV1", "e CreateListView ===> " + e.toString());
        }


    }

    private void showText() {
        nameString = getIntent().getStringExtra("Login");
        textView.setText(nameString);
    }

    private void initialView() {
        textView = (TextView) findViewById(R.id.txtNameLogin);
        barImageView = (ImageView) findViewById(R.id.imvBarcode);
        qrImageView = (ImageView) findViewById(R.id.imvQaCode);
        listView = (ListView) findViewById(R.id.livProduct);
    }


} // Main Class
