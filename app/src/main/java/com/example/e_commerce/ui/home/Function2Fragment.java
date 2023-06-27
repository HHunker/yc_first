package com.example.e_commerce.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.e_commerce.CommodityActivity;
import com.example.e_commerce.R;

public class Function2Fragment extends Fragment {
    public String[] name = {"数据三","数据四"};
    public String[] price = {"15","20"};
    public String[] detail = {"不知道啊自己想啊","别看我我和三一样"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_function2, container, false);

        // 获取 ListView 控件
        ListView listView = view.findViewById(R.id.list_view2);

        //实例化一个适配器
        MyBaseAdapter adapter=new MyBaseAdapter();
        //列表设置适配器
        listView.setAdapter(adapter);
        //列表元素的点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //创建Intent对象，参数就是从function1跳转到CommodityActivity
                Intent intent=new Intent(Function2Fragment.this.getContext(), CommodityActivity.class);
                //将歌曲名和歌曲的下标存入Intent对象
                intent.putExtra("name",name[position]);
                intent.putExtra("position",String.valueOf(position));
                intent.putExtra("price",price[position]);
                intent.putExtra("position",String.valueOf(position));
                intent.putExtra("detail",detail[position]);
                intent.putExtra("position",String.valueOf(position));
                //开始跳转
                startActivity(intent);
            }
        });


        return view;
    }

    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount(){return  name.length;}
        @Override
        public Object getItem(int i){return name[i];}
        @Override
        public long getItemId(int i){return i;}

        @Override
        public View getView(int i ,View convertView, ViewGroup parent) {
            //绑定好VIew，然后绑定控件
            View view=View.inflate(Function2Fragment.this.getContext(),R.layout.item_layout,null);
            TextView tv_name=view.findViewById(R.id.item_name);
            TextView tv_price=view.findViewById(R.id.item_price);
            TextView tv_detail=view.findViewById(R.id.item_detail);
            ImageView iv=view.findViewById(R.id.iv);
            //设置控件显示的内容，就是获取的名和图片等
            tv_name.setText(name[i]);
            tv_price.setText(price[i]);
            tv_detail.setText(detail[i]);
//            iv.setImageResource(icons[i]);
            return view;
        }
    }
}