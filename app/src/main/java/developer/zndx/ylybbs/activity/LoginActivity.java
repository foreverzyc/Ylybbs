package developer.zndx.ylybbs.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import developer.zndx.ylybbs.R;

public class LoginActivity extends AppCompatActivity {

    LinearLayout email_linear;
    LinearLayout password_linear;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    void init(){
        email_linear = (LinearLayout)findViewById(R.id.email_linear);
        password_linear = (LinearLayout)findViewById(R.id.password_linear);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    email.setHint("");
                }else{
                    if(email.getText().toString().equals("")){
                        email.setHint("学号/邮箱");
                    }
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    password.setHint("");
                }else{
                    if(password.getText().toString().equals("")){
                        password.setHint("密码");
                    }
                }
            }
        });
    }

    public void go(View view){
        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,NavigationActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,GuideActivity.class));
        finish();
    }
}
