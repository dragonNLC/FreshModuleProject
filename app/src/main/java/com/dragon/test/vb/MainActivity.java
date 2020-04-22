package com.dragon.test.vb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dragon.test.vb.databinding.ActivityMainBinding;
import com.dragon.test.vb.databinding.MergeLayoutBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding.tvHelloWorld.setText("通过反射来获取ViewBinding对象");
    }

}
