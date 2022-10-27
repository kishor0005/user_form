package kishor.com.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


     EditText kbname;
     EditText kbm;
     EditText kbd;
   EditText kby;
     EditText kbem;
   //  TextView kbt;
     ArrayList<dataclass>arrayList;
     Button kbsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kbsave = findViewById(R.id.kb_save);
        kbname = findViewById(R.id.kb_name);
        kbm = findViewById(R.id.kb_m);
        kbd = findViewById(R.id.kb_d);
        kby = findViewById(R.id.kb_y);
        kbem = findViewById(R.id.kb_em);
        //kbt = findViewById(R.id.kb_t);
       // loadData();

        kbsave = (Button)  findViewById(R.id.kb_save);
        kbsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             //   saveData(kbname.getText().toString(),kbm.getText().toString(),kbd.getText().toString(),kby.getText().toString(),kbem.getText().toString());
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                String n= kbname.getText().toString();
                String m= kbm.getText().toString();
                String d= kbd.getText().toString();
                String y= kby.getText().toString();
                String e= kbem.getText().toString();
                intent.putExtra("2pagen",n);
                intent.putExtra("2pagem",m);
                intent.putExtra("2paged",d);
                intent.putExtra("2pagey",y);
                intent.putExtra("2pagee",e);

                startActivity(intent);

            //    opencactivity_main2();

            }

//            private void opencactivity_main2() {
//
//            }

//            private void saveData(String name, String month, String date, String year, String emid)
//            { SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("form_data", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//
//                Gson gson=new Gson();
//                arrayList.add(new dataclass(name,month,date,year,emid));
//                String json = gson.toJson(arrayList);
//                editor.putString("emp_data", json);
//                editor.apply();
//      //          k.setText("List Data\n");
//                loadData();
//            }


        });
    }



//    private void loadData() {
//
//        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("form_data", MODE_PRIVATE);
//        Gson Gson;
//        Gson = new Gson();
//        String json = sharedPreferences.getString("emp_data", null);
//        Type type = new TypeToken<ArrayList<dataclass>>() {
//
//
//        }.getType();
//
//        Gson gson;
//        arrayList = Gson.fromJson(json, type);
//        if (arrayList == null) {
//            arrayList = new ArrayList<>();
//      //      kbt.setText("" + 0);
//        } else {
//            for (int i = 0; i < arrayList.size(); i++)
//            {
//        //        kbt.setText(kbt. getText().toString() + "\n" + arrayList.get(i).name + "\n"+arrayList.get(i).email);
//
//            }
//        }


    //}
}