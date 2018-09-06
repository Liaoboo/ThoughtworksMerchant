package thoughtworks.merchant.program.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import thoughtworks.merchant.program.R;

/**
 * Created by Administrator on 2018/4/21.
 */

public abstract class BaseMainActivity extends BaseActivity implements View.OnClickListener {
    protected EditText et_input;
    protected TextView tv_output;
    protected Button btn_input, btn_output;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化组件
     */
    protected void initViews() {
        et_input = (EditText) findViewById(R.id.et_input);
        tv_output = (TextView) findViewById(R.id.tv_output);
        btn_output = (Button) findViewById(R.id.btn_output);
        btn_input = (Button) findViewById(R.id.btn_input);
    }

    /**
     * 参数设置
     */
    protected void initParams() {
    }

    /**
     * 监听设置
     */
    protected void initListeners() {
        btn_input.setOnClickListener(this);
        btn_output.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
    }

}
