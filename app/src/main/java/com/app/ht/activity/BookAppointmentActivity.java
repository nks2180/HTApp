package com.app.ht.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.app.ht.R;
import com.app.ht.adapter.AppointmentDatePagerAdapter;
import com.app.ht.component.ApplicationComponent;
import com.app.ht.customViews.HFTextView;
import com.app.ht.model.AppointmentDateSlot;
import com.app.ht.presenter.BookAppointmentPresenter;
import com.app.ht.presenter.BookAppointmentView;
import com.app.ht.utils.HtUtils;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;

import static android.view.View.GONE;

/**
 * Created by niranjan on 12/6/16.
 */

public class BookAppointmentActivity extends BaseViewPresenterActivity<BookAppointmentPresenter> implements BookAppointmentView, ViewPager.OnPageChangeListener {

    @Inject
    BookAppointmentPresenter bookAppointmentPresenter;

    @BindView(R.id.txtVw_monthName)
    HFTextView txtVwMonthName;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager_dateSlots)
    ViewPager viewPagerDateSlots;
    @BindView(R.id.prgrs_loading)
    ProgressBar prgrsLoading;
    @BindView(R.id.lnrlyt_tab)
    LinearLayout lnrlytTab;

    AppointmentDatePagerAdapter mAdapter;
    ArrayList<AppointmentDateSlot> mDateTimeSlots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPagerDateSlots.addOnPageChangeListener(this);
        getSupportActionBar().setTitle(R.string.choose_date_time);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setMonthTitleString(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setMonthTitleString(int position) {
        AppointmentDateSlot dateTimeSlot = mDateTimeSlots.get(position);
        Date date = HtUtils.parseDateString("yyyy-MM-dd", dateTimeSlot.getDate());
        txtVwMonthName.setText(HtUtils.getMonthFromDate(date));
    }

    @Override
    protected int getMainLayout() {
        return R.layout.activity_book_appointment;
    }

    @Override
    public void injectComponent(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    @Override
    public void initializePresenter() {
        super.initializePresenter(bookAppointmentPresenter, this);
    }


    @Override
    public void onSlotsResponeCame(ArrayList<AppointmentDateSlot> dateTimeSlots) {
        prgrsLoading.setVisibility(GONE);
        lnrlytTab.setVisibility(View.VISIBLE);
        mDateTimeSlots = dateTimeSlots;
        setUpTabLayout();
    }

    private void setUpTabLayout() {
        mAdapter = new AppointmentDatePagerAdapter(getSupportFragmentManager(), mDateTimeSlots);

        viewPagerDateSlots.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(viewPagerDateSlots);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            setUpTab(mDateTimeSlots.get(i).getDate(), i);
        }
    }

    private void setUpTab(String dateStr, int position) {
        View tabView = LayoutInflater.from(this).inflate(R.layout.layout_tab, null);
        HFTextView txtVw_date = (HFTextView) tabView.findViewById(R.id.txtVw_date);
        HFTextView txtVw_day = (HFTextView) tabView.findViewById(R.id.txtVw_day);
        Date date = HtUtils.parseDateString("yyyy-MM-dd", dateStr);
        txtVw_date.setText(HtUtils.getDateOfMonth(date));
        txtVw_day.setText(HtUtils.getDayOfWeek(date));
        tabLayout.getTabAt(position).setCustomView(tabView);
        if (position == 0) {
            setMonthTitleString(0);
        }
    }

}
