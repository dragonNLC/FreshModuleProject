package com.dragon.test.vb;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    protected T mViewBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(mViewBinding.getRoot());
    }

    private void init() {
        ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
        if (pt != null && pt.getActualTypeArguments().length > 0) {
            Class<T> tp = (Class<T>) pt.getActualTypeArguments()[0];
            try {
                Method method = tp.getDeclaredMethod("inflate", LayoutInflater.class);
                method.setAccessible(true);
                mViewBinding = (T) method.invoke(null, getLayoutInflater());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
