package com.weizi.wxmanager.base;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.weizi.wxmanager.R;
import com.youngmanster.collectionlibrary.base.IBaseActivity;
import com.youngmanster.collectionlibrary.mvp.BasePresenter;
import org.jetbrains.annotations.Nullable;

/**
 * Created by yangyan
 * on 2018/3/18.
 */

public abstract class BaseActivity<T extends BasePresenter> extends IBaseActivity {

    @BindView(R.id.common_toolbar)
    public Toolbar mCommonToolbar;

    @BindView(R.id.titleTv)
    public TextView titleTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(mCommonToolbar!=null){
            setupToolbar(mCommonToolbar);
            setTitle("");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
    /**
     * 设置Toolbar成ActionBar
     */
    protected void setupToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    /** ActionBar显示返回图标 */
    protected void showHomeAsUp(@DrawableRes int resId) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * 自定义Toolbar的title内容
     */
    protected void setTitleContent(String title) {
        if (titleTv != null) {
            titleTv.setVisibility(View.VISIBLE);
            titleTv.setText(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
