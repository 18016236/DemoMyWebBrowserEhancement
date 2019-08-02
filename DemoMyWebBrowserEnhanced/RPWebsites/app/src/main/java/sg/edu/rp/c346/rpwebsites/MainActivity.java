package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spn1;
    Spinner spn2;
    Button btnGo;
    ArrayList<String>alNumbers;
    ArrayAdapter<String>aaNumbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.button);

        alNumbers = new ArrayList<>();

        final String[] strNumbers = getResources().getStringArray(R.array.main);

        alNumbers.addAll(Arrays.asList(strNumbers));

        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:

                        alNumbers.clear();

                        String[] categories = getResources().getStringArray(R.array.notmain);

                        alNumbers.addAll(Arrays.asList(categories));

                        spn2.setAdapter(aaNumbers);

                        spn2.setSelection(0);

                        break;

                    case 1:

                        alNumbers.clear();

                        String[] subcategories = getResources().getStringArray(R.array.notMainSecond);

                        alNumbers.addAll(Arrays.asList(subcategories));

                        spn2.setAdapter(aaNumbers);

                        spn2.setSelection(0);

                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spn1.getSelectedItem().equals("RP")){
                    if (spn2.getSelectedItem().equals("Homepage")){
                        Intent intent = new Intent(getBaseContext(),SecondActivity.class);
                        intent.putExtra("value","https://www.rp.edu.sg/");
                        startActivity(intent);

                    }else if(spn2.getSelectedItem().equals("Student Life")){
                        Intent intent = new Intent(getBaseContext(),SecondActivity.class);
                        intent.putExtra("value","https://www.rp.edu.sg/student-life");
                        startActivity(intent);
                    }

                } else if(spn1.getSelectedItem().equals("SOI")){
                    if(spn2.getSelectedItem().equals("DMSD")){
                        Intent intent = new Intent(getBaseContext(),SecondActivity.class);
                        intent.putExtra("value","https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                        startActivity(intent);
                    }
                    else if(spn2.getSelectedItem().equals("DIT")){
                        Intent intent = new Intent(getBaseContext(),SecondActivity.class);
                        intent.putExtra("value","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                        startActivity(intent);
                    }

                }

            }

        });

    }
}
