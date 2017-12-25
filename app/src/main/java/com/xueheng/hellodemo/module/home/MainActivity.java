package com.xueheng.hellodemo.module.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.xueheng.hellodemo.R;
import com.xueheng.hellodemo.common.base.BaseActivity;
import com.xueheng.hellodemo.common.utils.LogUtil;
import com.xueheng.hellodemo.common.utils.ToastUtil;
import com.xueheng.hellodemo.module.home.adapter.FruitAdapter;
import com.xueheng.hellodemo.module.home.entity.Fruit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity {

    private FruitAdapter fruitAdapter;
    private List<Fruit> fruitList;
    private String strResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }


    @Override
    public void initView() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("首页");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fruitList=new ArrayList<>();
        fruitAdapter=new FruitAdapter(fruitList,MainActivity.this);
        ListView lvMain=findView(R.id.lv_main);
        lvMain.setAdapter(fruitAdapter);

        httpGet();

        httpPost();
    }

    @Override
    public void initData() {

        Fruit fruit1=new Fruit("11",1);
        Fruit fruit2=new Fruit("22",2);
        Fruit fruit3=new Fruit("33",3);
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);

        fruitAdapter.notifyDataSetChanged();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void httpGet(){
        OkHttpClient client = new OkHttpClient();
        //构造Request对象
        //采用建造者模式，链式调用指明进行Get请求,传入Get的请求地址
        Request request = new Request.Builder().get().url("http://www.jianhu.cm/u/df45b87cfdf").build();
        Call call = client.newCall(request);
        //异步调用并设置回调函数
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //
                final IOException exception=e;
                LogUtil.d("Get 失败");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.showShortToast(exception.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String responseStr = response.body().string();
                //strResult=response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //tv_result.setText(responseStr);
                        ToastUtil.showShortToast(strResult);
                    }
                });
            }
        });

    }

    public void httpPost(){
        OkHttpClient client = new OkHttpClient();
        //构建FormBody，传入要提交的参数
        FormBody formBody = new FormBody
                .Builder()
                .add("username", "initObject")
                .add("password", "initObject")
                .build();
        final Request request = new Request.Builder()
                .url("http://www.jianshu.com/")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseStr = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        });


    }

}
