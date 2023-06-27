package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_commerce.ui.dashboard.DashboardFragment;
import com.example.e_commerce.util.ToastUtil;

public class CommodityActivity extends AppCompatActivity {
    public Button mbtback,mbtby;
    public String name,price,detail;
    public TextView cmname,cmprice,cmdetail;
    private Intent intent1,intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity);

        intent1 = getIntent();
        cmname = findViewById(R.id.cm_name);
        cmprice = findViewById(R.id.cm_price);
        cmdetail = findViewById(R.id.cm_detail);

        mbtback = findViewById(R.id.back);
        mbtby = findViewById(R.id.cm_by);

        name=intent1.getStringExtra("name");
        price=intent1.getStringExtra("price");
        detail=intent1.getStringExtra("detail");
        cmname.setText(name);
        cmprice.setText(price);
        cmdetail.setText(detail);

        mbtback.setOnClickListener(new View.OnClickListener() {
            Intent intent = null;
            @Override
            public void onClick(View v) {

                intent =new Intent(CommodityActivity.this, MainActivity.class);
                startActivities(new Intent[]{intent});
            }
        });

        mbtby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ok = "添加成功";
                ToastUtil.showMsg(CommodityActivity.this, ok);
            }
        });

    }

}