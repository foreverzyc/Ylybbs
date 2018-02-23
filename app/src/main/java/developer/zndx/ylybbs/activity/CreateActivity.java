package developer.zndx.ylybbs.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.ArrayList;
import java.util.List;

import developer.zndx.ylybbs.util.Code;
import developer.zndx.ylybbs.R;

public class CreateActivity extends AppCompatActivity {


    EditText zc_email;
    EditText zc_password;
    EditText zc_username;
    EditText verify;
    ImageView pic;
    String realnum;

    TextView zc_textview;
    ListView listView;
    PopupWindow typeSelectPopup;
    List<String> testData;
    ArrayAdapter<String>testDataAdapter;
    static final int REQUEST_CODE_CHOOSE  = 26;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        init();
    }

    void init(){
        zc_email = (EditText)findViewById(R.id.zc_email);
        zc_password = (EditText)findViewById(R.id.zc_password);
        zc_username = (EditText)findViewById(R.id.zc_username);
        verify = (EditText)findViewById(R.id.verify);
        zc_textview = (TextView) findViewById(R.id.zc_textview);
        pic = (ImageView)findViewById(R.id.pic);
        pic.setImageBitmap(Code.getInstance().createBitmap());
        realnum = Code.getInstance().getCode().toLowerCase();
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pic.setImageBitmap(Code.getInstance().createBitmap());
                realnum = Code.getInstance().getCode().toLowerCase();
            }
        });
        zc_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initSelectPopup();
                if (typeSelectPopup != null && !typeSelectPopup.isShowing()) {
                    typeSelectPopup.showAsDropDown(zc_textview, 0, 10);
                }
            }
        });
        zc_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    zc_username.setHint("");
                }else{
                    if(zc_username.getText().toString().equals("")){
                        zc_username.setHint("用户名");
                    }
                }
            }
        });
        zc_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    zc_password.setHint("");
                }else{
                    if(zc_password.getText().toString().equals("")){
                        zc_password.setHint("密码");
                    }
                }
            }
        });
        zc_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    zc_email.setHint("");
                }else{
                    if(zc_email.getText().toString().equals("")){
                        zc_email.setHint("邮箱");
                    }
                }
            }
        });
        verify.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    verify.setHint("");
                }else{
                    if(verify.getText().toString().equals("")){
                        verify.setHint("验证码");
                    }
                }
            }
        });
    }

    private void initSelectPopup() {
        listView = new ListView(this);
        TestData();
        // 设置适配器
        testDataAdapter = new ArrayAdapter<String>(this, R.layout.popup_text_item, testData);
        listView.setDivider(new ColorDrawable(getResources().getColor(R.color.create_layout)));
        listView.setDividerHeight(3);
        listView.setAdapter(testDataAdapter);

        // 设置ListView点击事件监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 在这里获取item数据
                String value = testData.get(position);
                // 把选择的数据展示对应的TextView上
                zc_textview.setText(value);
                // 选择完后关闭popup窗口
                typeSelectPopup.dismiss();
            }
        });
        typeSelectPopup = new PopupWindow(listView,zc_textview.getWidth(), ActionBar.LayoutParams.WRAP_CONTENT, true);
        // 取得popup窗口的背景图片
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.bg_corner);
        typeSelectPopup.setBackgroundDrawable(drawable);
        typeSelectPopup.setFocusable(true);
        typeSelectPopup.setOutsideTouchable(true);
        typeSelectPopup.showAsDropDown(zc_textview,0,-3);
        typeSelectPopup.update();
        typeSelectPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // 关闭popup窗口
                typeSelectPopup.dismiss();
            }
        });
    }


    public void next(View view){
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,GuideActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,GuideActivity.class));
        finish();
    }

    private void TestData() {
        testData = new ArrayList<>();
        testData.add("信息科学与工程学院");
        testData.add("文学与新闻传播学院");
        testData.add("商学院");
        testData.add("公共管理学院");
        testData.add("化学化工学院");
        testData.add("材料科学与工程学院");
        testData.add("土木工程学院");
        testData.add("资源与安全工程学院");
        testData.add("软件学院");
        testData.add("外国语学院");
        testData.add("数学与统计学院");
        testData.add("法学院");
        testData.add("机电工程学院");
        testData.add("冶金与环境学院");
        testData.add("资源加工与生物工程学院");
        testData.add("航空航天学院");
        testData.add("建筑与艺术学院");
        testData.add("马克思主义学院");
        testData.add("物理与电子学院");
        testData.add("能源科学与工程学院");
        testData.add("交通运输工程学院");
        testData.add("体育教研部");
        testData.add("生命科学学院");
        testData.add("地球科学与信息物理学院");
        testData.add("湘雅医学院");
        }

        public void avatar(View view){

            Matisse.from(this)
                    .choose(MimeType.allOf())
                    .countable(false)
                    .theme(R.style.Matisse_Zhihu)
                    .maxSelectable(1)
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(new GlideEngine())
                    .forResult(REQUEST_CODE_CHOOSE);
        }
    }


