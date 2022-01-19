package org.techtown.moviefriend01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText name=findViewById(R.id.signup_name);
        EditText id=findViewById(R.id.signup_id);
        EditText pw=findViewById(R.id.signup_pw);

        Button button6=findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Button button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String username=name.getText().toString();
                final String userid=id.getText().toString();
                final String userpw=pw.getText().toString();

                if(username.equals("")||userid.equals("")||userpw.equals("")){
                    AlertDialog.Builder dialog=new AlertDialog.Builder(SignupActivity.this);
                    dialog.setIcon(R.mipmap.ic_launcher);
                    dialog.setTitle("알림");
                    dialog.setMessage("모두 입력");
                    dialog.setNegativeButton("확인",null);
                    dialog.show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    intent.putExtra("userid",userid);
                    intent.putExtra("userpw",userpw);
                    intent.putExtra("username",username);
                    startActivityForResult(intent,RESULT_OK);
                }
            }
        });
    }
}
