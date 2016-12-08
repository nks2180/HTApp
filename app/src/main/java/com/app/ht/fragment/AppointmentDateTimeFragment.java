package com.app.ht.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.ht.R;
import com.app.ht.adapter.DateTimeSlotAdapter;
import com.app.ht.component.ApplicationComponent;
import com.app.ht.model.AppointmentDateSlot;
import com.app.ht.utils.HTLogger;
import com.app.ht.utils.HtUtils;
import com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by niranjan on 12/7/16.
 */

public class AppointmentDateTimeFragment extends BaseFragment implements RecyclerViewExpandableItemManager.OnGroupExpandListener, RecyclerViewExpandableItemManager.OnGroupCollapseListener {

    AppointmentDateSlot mDateSlot;
    @BindView(R.id.recyclerVw_slots)
    RecyclerView recyclerVwSlots;

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mWrappedAdapter;
    private RecyclerViewExpandableItemManager mRecyclerViewExpandableItemManager;

    private static final String SAVED_STATE_EXPANDABLE_ITEM_MANAGER = "RecyclerViewExpandableItemManager";

    public AppointmentDateTimeFragment() {

    }

    public static AppointmentDateTimeFragment newInstance(AppointmentDateSlot dateSlot) {
        AppointmentDateTimeFragment dateTimeFragment = new AppointmentDateTimeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(HtUtils.EXTRA_APPOINTMENT_DATETIME_OBJ, dateSlot);
        dateTimeFragment.setArguments(bundle);
        return dateTimeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HTLogger.d("onCreate called");
        if (getArguments() != null && getArguments().containsKey(HtUtils.EXTRA_APPOINTMENT_DATETIME_OBJ))
            mDateSlot = (AppointmentDateSlot) getArguments().getSerializable(HtUtils.EXTRA_APPOINTMENT_DATETIME_OBJ);
    }

    @Override
    protected void initializePresenter() {

    }

    @Override
    protected void injectComponent(ApplicationComponent component) {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadDataIntoUI(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    int getFragmentLayout() {
        return R.layout.fragment_datetime_slots;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    private void loadDataIntoUI(Bundle savedInstanceState){
        mLayoutManager = new LinearLayoutManager(getContext());

        final Parcelable eimSavedState = (savedInstanceState != null) ? savedInstanceState.getParcelable(SAVED_STATE_EXPANDABLE_ITEM_MANAGER) : null;
        mRecyclerViewExpandableItemManager = new RecyclerViewExpandableItemManager(eimSavedState);
        mRecyclerViewExpandableItemManager.setOnGroupExpandListener(this);
        mRecyclerViewExpandableItemManager.setOnGroupCollapseListener(this);

        final DateTimeSlotAdapter myItemAdapter = new DateTimeSlotAdapter(mDateSlot);
        mWrappedAdapter = mRecyclerViewExpandableItemManager.createWrappedAdapter(myItemAdapter);

        GeneralItemAnimator animator = new RefactoredDefaultItemAnimator();
        animator.setSupportsChangeAnimations(false);

        recyclerVwSlots.setLayoutManager(mLayoutManager);
        recyclerVwSlots.setAdapter(mWrappedAdapter);
        recyclerVwSlots.setItemAnimator(animator);
        recyclerVwSlots.setHasFixedSize(false);

        mRecyclerViewExpandableItemManager.attachRecyclerView(recyclerVwSlots);
    }

    @Override
    public void onGroupExpand(int groupPosition, boolean fromUser) {
        HTLogger.d("onGroupExpand groupPosition: ", String.valueOf(groupPosition));
    }

    @Override
    public void onGroupCollapse(int groupPosition, boolean fromUser) {
        HTLogger.d("onGroupCollapse groupPosition: ", String.valueOf(groupPosition));
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mRecyclerViewExpandableItemManager != null) {
            outState.putParcelable(
                    SAVED_STATE_EXPANDABLE_ITEM_MANAGER,
                    mRecyclerViewExpandableItemManager.getSavedState());
        }
    }
}
