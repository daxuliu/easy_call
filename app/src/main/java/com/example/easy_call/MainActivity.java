package com.example.easy_call;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.easycall.adapter.at.Call;
import com.example.easycall.adapter.at.Use;
import com.example.easycall.adapter.builder.Builder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mjxx.speechlibsnative.sdk.Config;
import com.mjxx.speechlibsnative.sdk.SpeechSDK;
import com.suke.widget.SwitchButton;

public class MainActivity extends AppCompatActivity {
    @Call( name = "fab", id = R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("call", "fab");


//                String s=null;
//                Log.d("crash",s.equals("")+"");
//                Config config = new Config();
//                config.setShowLog(true);  //是否打印日志
//                config.setWriteLog(true); //是否保存日志文件，true则输出日志到 手机储存/SpeechSdkLogs/
//                //以下参数由服务方提供：
//                config.setAsrServerUrl("http://182.61.15.84:8090/v2"); // 语音识别服务器地址
//                config.setAsrPid(Integer.parseInt("888"));  //选填，默认888
//                config.setAsrLongRecordEnable(true);  //asr收否支持长时间录音
//                config.setAsrSaveRecord(true);  //是否保存asr录音文件，true则保存到 手机储存/MUSIC/baidu_asr/
//
//                config.setTtsServerUrl("http://182.61.15.84:8802");  // 语音合成服务器地址
//                config.setWebServerUrl("http://47.106.235.8:10000"); //web host
//                config.setRemoteServerHost(""); //如需代理，请配置我放业务服务器Host
//                SpeechSDK.startSpeech(view.getContext(),config);



            }
        });
        com.suke.widget.SwitchButton switchButton = (com.suke.widget.SwitchButton)
                findViewById(R.id.switch_button);

        switchButton.setChecked(true);
        switchButton.isChecked();
//        switchButton.toggle();     //switch state
//        switchButton.toggle(false);//switch without animation
//        switchButton.setShadowEffect(true);//disable shadow effect
//        switchButton.setEnabled(false);//disable button
//        switchButton.setEnableEffect(false);//disable the switch animation
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job
            }
        });
        @Use
        String use="use";
        Builder builder =  Builder.getBuilder();
        builder.addPage(this, "main");
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.getCall("main", "fab").call();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}