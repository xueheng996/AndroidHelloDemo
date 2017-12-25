package com.xueheng.hellodemo.module.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.xueheng.hellodemo.R;
import com.xueheng.hellodemo.common.base.BaseActivity;
import com.xueheng.hellodemo.module.home.adapter.FruitAdapter;
import com.xueheng.hellodemo.module.home.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private FruitAdapter fruitAdapter;
    private List<Fruit> fruitList;

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

}
