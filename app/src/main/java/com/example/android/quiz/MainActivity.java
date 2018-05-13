package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startQuiz(View view){

        EditText editText = (EditText) findViewById(R.id.user_name);
        String message = editText.getText().toString();
        EditText editText1 = (EditText) findViewById(R.id.user_mailId);
        String mail = editText1.getText().toString();
        boolean checking = isValidEmail(mail);
        if (message != null && !message.isEmpty()) {
            if (mail != null && !mail.isEmpty() && checking) {

                Intent intent = new Intent(MainActivity.this, QuizActiviity.class);

                Bundle packs = new Bundle();
                packs.putString("user_name", message);
                packs.putString("user_mailId", mail);
                intent.putExtras(packs);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Please enter valid e-mail address!", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show();
            return;
        }
        }


    @Override
protected void onSaveInstanceState(Bundle outState) {

    super.onSaveInstanceState(outState);

    EditText editText = findViewById(R.id.user_name);
    outState.putString("user_name_present", editText.getText().toString());

    EditText editText1 = findViewById(R.id.user_mailId);
    outState.putString("user_mailId_present",editText.getText().toString());
}
    @Override
    protected void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);
        EditText editText = findViewById(R.id.user_name);
        editText.setText(inState.getString("user_name_present"));
        EditText editText1 = findViewById(R.id.user_mailId);
        editText1.setText(inState.getString("user_mailId_present"));
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
