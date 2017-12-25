package com.xueheng.hellodemo.module.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xueheng.hellodemo.R;
import com.xueheng.hellodemo.common.base.MyBaseAdapter;
import com.xueheng.hellodemo.common.utils.LogUtil;
import com.xueheng.hellodemo.module.home.entity.Fruit;

import java.util.List;


/**
 * Created by tsjdc on 2017/12/25.
 */

public class FruitAdapter extends MyBaseAdapter<Fruit>{


    public FruitAdapter(List<Fruit> list, Context context) {
        super(list, context);

    }


    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_main_lv,null);
            LogUtil.d(convertView);
            holder.tvName=convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Fruit fruit=list.get(position);
        LogUtil.d(fruit.getName());
        holder.tvName.setText(fruit.getName());
        return convertView;
    }

   class ViewHolder{
        TextView tvName;
   }
}
