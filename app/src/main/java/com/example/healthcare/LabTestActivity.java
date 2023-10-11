package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[] [] packages=
            {
                    {"Package 1 : Full Body Checkup", "", "", "","999"},
                    {"Package 2 : Blood Glucose Fasting", "", "", "","299"},
                    {"Package 3 : Covid-19 AntiBody - IGg", "", "", "","899"},
                    {"Package 4 : Thyroid Check", "", "", "","499"},
                    {"Package 5 : Immunity Check", "", "", "","699"}
            };
    private String[] package_details = {
            "BLood Glucose Fasting\n" +
                    " Complete Hemogram\n" +
                    "HbAlc\n" +
                    " Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test",
            "BLood Glucose Fasting",
            "COVID-19 Antibody- IgG",
            "Thyroid Profile-Total (T3, T4 & TSH ULtra-sensitive)",
            "Complete Hemogram\n" +
                    "Kidney Function Test\n" +
                    "CRP (C Reactive Protein) Quantitative, Serum\n" +
                    " Iron Studies\n " +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Lipid Profile"
    };
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart=findViewById(R.id.buttonCardCheckout);
        btnBack=findViewById(R.id.buttonHADBack);
        listView=findViewById(R.id.listViewHA);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList () ;
        for(int i=0;i<packages.length ;i++){
            item = new HashMap<String, String>();
            item.put( "line1", packages[i][0]);
            item.put ( "line2", packages[i][1]) ;
            item.put ( "line3", packages[i][2]);
            item.put( "line4", packages[i][3]);
            item.put ( "line5", "Total Cost: "+packages[i][4]);
            list.add( item );
        }
        sa = new SimpleAdapter(
                this,list,
                R.layout.multi_line,
                new String []{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestActivityDetails.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}