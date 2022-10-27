package kishor.com.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView  nametext,agetext,emid;
            EditText dumy1,dumy2,dumy3,dumy4,dumy5
            ;
    ArrayList<dataclass> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nametext = findViewById(R.id.textView14);
        agetext = findViewById(R.id.textView15);
        emid = findViewById(R.id.textView16);
        dumy1 = findViewById(R.id.textView17);
        dumy2 = findViewById(R.id.textView18);
        dumy3 = findViewById(R.id.textView19);
        dumy4 = findViewById(R.id.textView20);
        dumy5 = findViewById(R.id.textView21);
        loadData();

        String uname = getIntent().getStringExtra("2pagen");
        String um = getIntent().getStringExtra("2pagem");
        String ud = getIntent().getStringExtra("2paged");
        String uy = getIntent().getStringExtra("2pagey");
        String uem = getIntent().getStringExtra("2pagee");
        dumy1.setText(uname);
        dumy2.setText(um);
        dumy3.setText(ud);
        dumy4.setText(uy);
        dumy5.setText(uem);

        saveData(dumy1.getText().toString(), dumy2.getText().toString(), dumy3.getText().toString(), dumy4.getText().toString(), dumy5.getText().toString());



    }private void saveData(String name, String month, String date, String year, String emid) {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("form_data", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            Gson gson=new Gson();
            arrayList.add(new dataclass(name,month,date,year,emid));
            String json = gson.toJson(arrayList);
            editor.putString("emp_data", json);
            editor.apply();
            nametext.setText("");
            loadData();



    }

    private void loadData() {

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("form_data", MODE_PRIVATE);
        Gson Gson;
        Gson = new Gson();
        String json = sharedPreferences.getString("emp_data", null);
        Type type = new TypeToken<ArrayList<dataclass>>() {


        }.getType();

        Gson gson;
        arrayList = Gson.fromJson(json, type);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
                  nametext.setText("" + 0);
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                nametext.setText(  arrayList.get(i).name + "\n");
                agetext.setText( arrayList.get(i).date+ "/" + arrayList.get(i).month + "/" +arrayList.get(i).year + "\n");
                emid.setText( arrayList.get(i).email + "\n");

            }
        }
    }
}