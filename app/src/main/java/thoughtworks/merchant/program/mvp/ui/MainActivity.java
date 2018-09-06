package thoughtworks.merchant.program.mvp.ui;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;

import thoughtworks.merchant.program.R;
import thoughtworks.merchant.program.mvp.presenter.MvpPresenter;
import thoughtworks.merchant.program.mvp.impl.MvpView;
import thoughtworks.merchant.program.mvp.ui.base.BaseMainActivity;
import thoughtworks.merchant.program.utils.IoUtils;
import thoughtworks.merchant.program.utils.InputFilterUtils;

/**
 * 主页
 *
 * @author LiaoBo
 */
public class MainActivity extends BaseMainActivity implements MvpView {

    private MvpPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        initParams();
    }


    @Override
    protected void initParams() {
        super.initParams();
        //初始化Presenter
        mPresenter = new MvpPresenter();
        mPresenter.attachView(this);
        //限制输入
        et_input.setFilters(new InputFilter[]{InputFilterUtils.limintSpecialCharacter(), InputFilterUtils.limintChinese()});
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开View引用
        mPresenter.detachView();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btn_input:
                inputClick();
                break;
            case R.id.btn_output:
                outputClick();
                break;
        }
    }

    /**
     * 导入文本内容
     */
    public void inputClick() {
        String txt = IoUtils.readInRaw(this, R.raw.test);
        et_input.setText(txt);
    }

    /**
     * 点击输出按钮处理
     */
    public void outputClick() {
        tv_output.setText(""); //置空
        String content = et_input.getText().toString();
        mPresenter.getData(content);
    }

    @Override
    public void showData(Object data) {
        if (TextUtils.isEmpty(data.toString())) {
            return;
        }
        tv_output.append(data.toString());
        tv_output.append("\n");
    }

    @Override
    public void showErr(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        tv_output.append(msg);
        tv_output.append("\n");
    }


}