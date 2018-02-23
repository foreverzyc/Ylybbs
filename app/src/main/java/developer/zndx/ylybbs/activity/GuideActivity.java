package developer.zndx.ylybbs.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import developer.zndx.ylybbs.R;

public class GuideActivity extends AppCompatActivity {

    public long last = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }

    public void register(View view) {
        startActivity(new Intent(this, CreateActivity.class));
        finish();
    }

    public void login(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        long current = System.currentTimeMillis();
        if (current - last < 2000) {
            finish();

        } else {
            Toast.makeText(this, "确定要退出吗", Toast.LENGTH_SHORT).show();
            last = current;
        }
    }
}
