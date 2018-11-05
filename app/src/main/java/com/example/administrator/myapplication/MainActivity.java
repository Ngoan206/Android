package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtuser;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=(Button)findViewById(R.id.btn_login);
        edtuser=(EditText)findViewById(R.id.edt_user);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=edtuser.getText().toString();
                Intent intent=new Intent(MainActivity.this,FrofileActivity.class);
                intent.putExtra("username",s);//gui du lieu qua FrofileActivity
                //Nhan di lieu tu FrofileActivity
                startActivityForResult(intent,123);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String value=data.getStringExtra("back");
        Toast.makeText(MainActivity.this,value+"",Toast.LENGTH_SHORT).show();
    }
}
