package jujinsuo.yuanze.com.jujinsuo_v20.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;


import jujinsuo.yuanze.com.jujinsuo_v20.R;
import jujinsuo.yuanze.com.jujinsuo_v20.base.BaseActivity;
import jujinsuo.yuanze.com.jujinsuo_v20.tools.ToastUtils;
import jujinsuo.yuanze.com.jujinsuo_v20.widget.FragmentCallback;
import jujinsuo.yuanze.com.jujinsuo_v20.widget.TabView;

/**
 * 文件名：用户操作主界面
 * 作 者： Administrator
 * 时 间： 2016/3/17 10 15
 * 邮 箱： yuhaikun19920202@gmail.com
 */
public class UserHomeActivity extends BaseActivity implements TabView.OnTabChangeListener, FragmentCallback, View.OnClickListener {
    private Context umContex;
    //标题
//    private RelativeLayout transparentTitleLayout;
//    private RelativeLayout transparentTitleBackRl;
//    private TextView transparentTitleContentTv;
//    private RelativeLayout transparentTitleMoreRl;


    //    private ActivityManagerApplication activityManagerApplication;
    private FragmentManager mFragmentManager;
    private TabView viewTab;
    private View homeView2;
    private FrameLayout layoutContent;

    /**
     * 上一次的状态
     */
    private int mPreviousTabIndex = 0;
    /**
     * 当前状态
     */
    private int mCurrentTabIndex = 0;
    private View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);
//        umContext = this;
//        transparentTitleLayout = (RelativeLayout) findViewById(R.id.title_bar_layout);
//        transparentTitleBackRl = (RelativeLayout) findViewById(R.id.transparent_title_back_rl);
//        transparentTitleContentTv = (TextView) findViewById(R.id.transparent_title_content_tv);
//        transparentTitleMoreRl = (RelativeLayout) findViewById(R.id.transparent_title_more_rl);
//        transparentTitleBackRl.setOnClickListener(this);
        initData();
        initView();

    }

//    private void initTitle(int mCurrentTabIndex) {
//
//        switch (mCurrentTabIndex) {
//            case 0:
//                transparentTitleLayout.setVisibility(View.GONE);
//                break;
//            case 1:
//                transparentTitleLayout.setVisibility(View.VISIBLE);
//                transparentTitleLayout.setBackgroundResource(R.drawable.rectangle);
//                transparentTitleBackRl.setVisibility(View.VISIBLE);
//                transparentTitleContentTv.setText("理财列表");
//                break;
//            case 2:
//                transparentTitleLayout.setVisibility(View.VISIBLE);
//                transparentTitleLayout.setBackgroundResource(R.drawable.rectangle);
//                transparentTitleBackRl.setVisibility(View.VISIBLE);
//                transparentTitleContentTv.setText("借款");
//
//                break;
//            case 3:
//                transparentTitleLayout.setVisibility(View.VISIBLE);
//                transparentTitleBackRl.setVisibility(View.VISIBLE);
//                break;
//
//        }
//    }

    /**
     * 初始化View参数
     */
    public void initView() {
        viewTab.setOnTabChangeListener(this);
        viewTab.setCurrentTab(mCurrentTabIndex);
    }

    @Override
    public void bindEvent() {

    }

    protected void initData() {
//        activityManagerApplication = new ActivityManagerApplication(umContex);
//        activityManagerApplication.addDestoryActivity(this, "UserHomeActivity");//用于退出登录
//        activityManagerApplication.addActivity(this);
        mFragmentManager = getSupportFragmentManager();
        view = findViewById(R.id.view);
        viewTab = (TabView) findViewById(R.id.view_tab);
        homeView2 = findViewById(R.id.home_view2);
        layoutContent = (FrameLayout) findViewById(R.id.layout_content);

    }

    @Override
    public void onFragmentCallback(Fragment fragment, int id, Bundle args) {
        viewTab.setCurrentTab(1);
    }

    protected void setListener() {

    }


    @Override
    public void onTabChange(String tag) {
        if (tag != null) {
            if (tag.equals("home")) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 0;
//                initTitle(0);
//                FragmentTransaction ft = mFragmentManager.beginTransaction();
//                ft.replace(R.id.layout_content, new UserHomeFragment()).commitAllowingStateLoss();
                ToastUtils.show("home",0);
            } else if (tag.equals("service")) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 1;

//                FragmentTransaction ft = mFragmentManager.beginTransaction();
//                ft.replace(R.id.layout_content, new UserServiceFragment()).commitAllowingStateLoss();
//                initTitle(1);
                ToastUtils.show("service",0);
            } else if (tag.equals("personal")) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 2;

//                FragmentTransaction ft = mFragmentManager.beginTransaction();
//                ft.replace(R.id.layout_content, new UserPersonFragment()).commitAllowingStateLoss();
//                initTitle(2);
                ToastUtils.show("personal",0);
            } else if (tag.equals("settings")) {
                mPreviousTabIndex = mCurrentTabIndex;
                mCurrentTabIndex = 3;
//                FragmentTransaction ft = mFragmentManager.beginTransaction();
//                ft.replace(R.id.layout_content, new UserMoreFragment()).commitAllowingStateLoss();
//                initTitle(3);
                ToastUtils.show("settings",1);

            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.transparent_title_back_rl: //退到首页
//                if (mCurrentTabIndex != 0) {
//                    mPreviousTabIndex = mCurrentTabIndex;
//                    mCurrentTabIndex = 0;
////                    initTitle(mCurrentTabIndex);
//                    viewTab.setCurrentTab(mCurrentTabIndex);
////                    FragmentTransaction ft = mFragmentManager.beginTransaction();
////                    ft.replace(R.id.layout_content, new UserHomeFragment()).commitAllowingStateLoss();
//                }
//                break;


        }
    }
}


