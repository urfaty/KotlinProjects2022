package com.example.midtermalma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Quiz4_MainActivity extends AppCompatActivity {

    private String[] mobileOS = {"USD", "EUR", "GBP", "YEN"};
    private ArrayAdapter<String> mArrayAdapter;
    ListView mListView;
    private EditText et1;
    private EditText et2;
    private TextView tv3;
    private double Usd = 18.5;
    private double Eur = 18.3;
    private double Gbp = 21.1;
    private double Yen = 7.84;
    private double choosenCurrency = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain_quiz4);

        mListView = (ListView) findViewById(R.id.lv_os);

        mArrayAdapter = new Quiz4_CustomAdapter(this, mobileOS);
        mListView.setAdapter(mArrayAdapter);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv3 = (TextView) findViewById(R.id.tv3);



        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                System.out.println("tsss"+et1.getText().toString());
                if (et1.getText().toString() != "") {
                    System.out.println("tsss"+et1.getText().toString());
                    String deneme;
                    int deneme1 = Integer.parseInt(deneme = et1.getText().toString());
                    double result = deneme1 / choosenCurrency;
                    et2.setText("" + result);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
               // et1.removeTextChangedListener(this);

            }
        });

//        et2.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//               // et2.removeTextChangedListener(this);
//
//
//            }
//        });



        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //View corresponds to ImageView and TextView  in list_item.xml
                //ImageView id: logo
                //TextView id: label

                TextView tv = (TextView) view.findViewById(R.id.label);
                ImageView img = (ImageView) view.findViewById(R.id.logo);

                et1.setText("");
                et2.setText("");

                switch (tv.getText().toString()) {
                    case "USD":
                        choosenCurrency = 18.5;
                        tv3.setText("Amount (USD)");
                        break;
                    case "EUR":
                        choosenCurrency = 18.3;
                        tv3.setText("Amount (EUR)");
                        break;
                    case "GBP":
                        choosenCurrency = 21.1;
                        tv3.setText("Amount (GBP)");
                        break;
                    case "YEN":
                        choosenCurrency = 7.84;
                        tv3.setText("Amount (YEN)");
                        break;
                }
            }
        });
    }


    private void displayToast(String msg) {

        Toast toast = Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);
        // Appears in the center
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

        // Appears in the top-left corner
        // toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
        toast.show();

        // To use Toast in one go
        // Appear in the center bottom by default
        // Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

}