package com.yenyu.a20180115_03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.SharedLibraryInfo;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2;
    EditText ed;
    PreferenceManager pm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        ed = findViewById(R.id.editText);
    }

    public void clickWrite(View v) //點擊 儲存輸入內容(value-key存入手機)
    {

        SharedPreferences sp = getSharedPreferences("DATA",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("DATA",ed.getText().toString());
        editor.commit();
    }
    public void clickRead(View v) //點擊輸出內容(從手機取出呼叫的key裡面的value內容)
    {
        SharedPreferences sp = getSharedPreferences("DATA",MODE_PRIVATE);
        String str = sp.getString("DATA","");
        tv.setText(str);
    }

    public void clickSet(View v)
    {
        Intent it =new Intent(MainActivity.this,SettingsActivity.class);
        startActivity(it);
    }

    public void clickName(View v) //點擊顯示使用者名稱(撈資料-存在app的資料)
    {
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        String str = sp.getString("example_text","");
        //s:寫setting裡面使用者名稱的id
        tv2.setText(str);



    }
}
