package com.example.administrator.myapplication;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FrofileActivity extends MainActivity {
    private TextView txtView;
    private Button btnCall,btnBack;
    private EditText edtEnterNumber,edtGetUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frofile_activity);
//        txtView=(TextView)findViewById(R.id.txt_view);
        edtEnterNumber=(EditText)findViewById(R.id.edt_EnterNumber);
        btnCall=(Button)findViewById(R.id.btn_call);
        edtGetUser=(EditText)findViewById(R.id.edt_getuser);
        btnBack=(Button)findViewById(R.id.btn_back);
        //Nhan du lieu tu mainActivity
        if(getIntent()!=null){
            String data=getIntent().getStringExtra("+");
            edtGetUser.setText(data);
        }
        // Chuyen du lieu ve MainActivity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("back","thank you");
                setResult(123,intent);
                finish();

            }
        });

        //thuc hien cuoc goi voi button Call
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  u=edtEnterNumber.getText().toString();
                if(!TextUtils.isEmpty(u)) {
                    String dial = "tel:" + u;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(FrofileActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
//    public void goGoogle(View view)  {
//        String url="http://google.com";
//
//        // Một Intent không tường minh, yêu cầu mở một URL.
//        Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        startActivity(intent2);
//    }
//
//    // Phương thức này được gọi khi người dùng click vào Button "Send Email".
//    public void sendEmail(View view)  {
//
//        // Danh sách người nhận
//        String[] recipients=new String[]{"friendemail@gmail.com"};
//        // Tiêu đề email.
//        String subject="Hi, how are you!";
//        // Nội dung email.
//        String content ="This is my test email";
//
//        Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
//        intentEmail.putExtra(Intent.EXTRA_EMAIL, recipients);
//        intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
//        intentEmail.putExtra(Intent.EXTRA_TEXT, content);
//
//        intentEmail.setType("text/plain");
//
//        startActivity(Intent.createChooser(intentEmail, "Choose an email client from..."));
//    }
}
