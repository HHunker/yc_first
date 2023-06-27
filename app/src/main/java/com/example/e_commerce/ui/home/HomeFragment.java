package com.example.e_commerce.ui.home;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.e_commerce.R;
import com.example.e_commerce.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private TextView tv1, tv2, tv3;
    private EditText searchEditText;

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tv1 = view.findViewById(R.id.button1);
        tv2 = view.findViewById(R.id.button2);
        tv3 = view.findViewById(R.id.button3);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);

//        initView();//初始化数据

        fm = requireActivity().getSupportFragmentManager();
        //fm可以理解为Fragment显示的管理者，ft就是它的改变者
        ft = fm.beginTransaction();

        //默认情况下就显示1
        ft.replace(R.id.content, new Function1Fragment());
        //提交改变的内容
        ft.commit();

        searchEditText = view.findViewById(R.id.search_edit_text);
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String searchText = searchEditText.getText().toString();
                    // 处理搜索
                    return true;
                }
                return false;
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    //控件的点击事件
    public void onClick(View v) {
        ft = fm.beginTransaction();
        //切换选项卡
        int id = v.getId();
        if (id == R.id.button1) {
            ft.replace(R.id.content, new Function1Fragment());
        } else if (id == R.id.button2) {
            ft.replace(R.id.content, new Function2Fragment());
        } else if (id == R.id.button3) {
            ft.replace(R.id.content, new Function3Fragment());
        }
        ft.commit();
    }

//    private void initView() {
//        //初始化控件
//        tv1 = getActivity().findViewById(R.id.button1);
//        tv2 = getActivity().findViewById(R.id.button2);
//        tv3 = getActivity().findViewById(R.id.button3);
//        tv1.setOnClickListener(this);
//        tv2.setOnClickListener(this);
//        tv3.setOnClickListener(this);
//    }
}
