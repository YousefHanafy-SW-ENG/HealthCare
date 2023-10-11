package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    String [][] doctor_details={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    private String[][]doctor_details1=
            {
        {"Doctor Nane : Yousef Hanafy", "Hospital Address : Elgawy", "Exp : 5yrs", "Mobile No: 01017882518", "600"},
        {"Doctor Name : Abdelrahman", "Hospital Address: Eldawaa", "Exp 15yrs", "Mobile No: 01065502855", "900"},
        {"Doctor Name : Hamo", "Hospital Address : ELrahma", "Exp : 8yrs", "Mobile No: 01057296582", "300"},
        {"Doctor Name abwahab", "Hospital Address : masr elgdeda", "Exp 6yrs", "Mobile No: 01037950351", "500"},
        {"Doctor Name : Nadeen ramdan", "Hospital Address : 57357", "Exp : 7yrs", "Mobile No: 01046926422","800"}
        };
    private String[][]doctor_details2=
            {
                    {"Doctor Nane : Yousef Hanafy", "Hospital Address : Elgawy", "Exp : 5yrs", "Mobile No:01017882518", "600"},
                    {"Doctor Name : Abdelrahman", "Hospital Address: Eldawaa", "Exp 15yrs", "Mobile No: 01065502855", "900"},
                    {"Doctor Name : Hamo", "Hospital Address : ELrahma", "Exp : 8yrs", "Mobile No: 01057296582", "300"},
                    {"Doctor Name : Abwahab", "Hospital Address : masr elgdeda", "Exp 6yrs", "Mobile No: 01037950351", "500"},
                    {"Doctor Name : nadeen ramdan", "Hospital Address : 57357", "Exp : 7yrs", "Mobile No: 01046926422","800"}
            };
    private String[][]doctor_details3=
            {
                    {"Doctor Nane : Yousef Hanafy", "Hospital Address : Elgawy", "Exp : 5yrs", "Mobile No:01017882518", "600"},
                    {"Doctor Name : Abdelrahman", "Hospital Address: Eldawaa", "Exp 15yrs", "Mobile No:01065502855", "900"},
                    {"Doctor Name : Hamo", "Hospital Address : ELrahma", "Exp : 8yrs", "Mobile No:01057296582", "300"},
                    {"Doctor Name : Abwahab", "Hospital Address : masr elgdeda", "Exp 6yrs", "Mobile No:01037950351", "500"},
                    {"Doctor Name : Nadeen ramdan", "Hospital Address : 57357", "Exp : 7yrs", "Mobile No:01046926422","800"}
            };
    private String[][]doctor_details4=
            {
                    {"Doctor Nane : Yousef Hanafy", "Hospital Address : Elgawy", "Exp : 5yrs", "Mobile No:01017882518", "600"},
                    {"Doctor Name : Abdelrahman", "Hospital Address: Eldawaa", "Exp 15yrs", "Mobile No:01065502855", "900"},
                    {"Doctor Name : Hamo", "Hospital Address : ELrahma", "Exp : 8yrs", "Mobile No:01057296582", "300"},
                    {"Doctor Name : Abwahab", "Hospital Address : masr elgdeda", "Exp 6yrs", "Mobile No:01037950351", "500"},
                    {"Doctor Name : Nadeen ramdan", "Hospital Address : 57357", "Exp : 7yrs", "Mobile No:01046926422","800"}
            };
    private String[][]doctor_details5=
            {
                    {"Doctor Nane : Yousef Hanafy", "Hospital Address : Elgawy", "Exp : 5yrs", "Mobile No:01017882518", "600"},
                    {"Doctor Name : Abdelrahman", "Hospital Address: Eldawaa", "Exp 15yrs", "Mobile No:01065502855", "900"},
                    {"Doctor Name : Hamo", "Hospital Address : ELrahma", "Exp : 8yrs", "Mobile No:01057296582", "300"},
                    {"Doctor Name : Abwahab", "Hospital Address : masr elgdeda", "Exp 6yrs", "Mobile No:01037950351", "500"},
                    {"Doctor Name : Nadeen ramdan", "Hospital Address : 57357", "Exp : 7yrs", "Mobile No:01046926422","800"}
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewCart);
        btn=findViewById(R.id.buttonHADBack);

        Intent it = getIntent();
        String title= it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else if(title.compareTo("Cardiologist")==0)
            doctor_details=doctor_details4;
        else if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList () ;
        for(int i=0;i<doctor_details.length ;i++){
            item = new HashMap<String, String>();
            item.put( "line1", doctor_details[i][0]);
            item.put ( "line2", doctor_details[i][1]) ;
            item.put ( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put ( "line5", "Cons Fees: "+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(
                this,list,
                R.layout.multi_line,
                new String []{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst= findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}