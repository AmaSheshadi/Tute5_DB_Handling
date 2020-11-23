package com.example.dbhandlingtute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbhandlingtute.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etusername, etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
    }

    public void addDate(View view){
        DBHelper dbHelper = new DBHelper(this );
        long val = dbHelper.addInfo((etusername.getText().toString(),etpassword.getText().toString()));

        if(val>0){
            Toast.makeText(this,"Data successfully inserted",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Data not   inserted",Toast.LENGTH_SHORT).show();
        }
    }
    public void viewAll(View view){
        DBHelper dbHelper = new DBHelper(this);

        List unames = dbHelper.readAllInfo(" user");

        Toast.makeText(this,unames.toString(), Toast.LENGTH_SHORT).show();
    }

}