package com.app.ht.presenter;

import android.content.Context;
import android.util.Log;

import com.app.ht.executor.ParsingExecutor;
import com.app.ht.model.AppointmentDateSlot;
import com.app.ht.retrofit.ApiController;
import com.app.ht.retrofit.ApiDataReceiveCallback;
import com.app.ht.retrofit.NetworkConstants;
import com.app.ht.retrofit.RequestBuilder;
import com.bluelinelabs.logansquare.LoganSquare;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

/**
 * Created by niranjan on 12/6/16.
 */

public class BookAppointmentPresenter extends BasePresenterImpl<BookAppointmentView> implements ApiDataReceiveCallback {

    @Inject
    ApiController apiController;

    @Inject
    ParsingExecutor parsingExecutor;

    @Inject
    BookAppointmentPresenter(Context baseContext) {
        super(baseContext);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        fetchDateSlots();
    }

    private void fetchDateSlots() {
        RequestBuilder requestBuilder = new RequestBuilder(NetworkConstants.API_FETCH_APPOINTMENT_SLOTS);
        requestBuilder.setExtraParameters(NetworkConstants.getSlotDefaultParams());
        apiController.hitApi(requestBuilder, this);
    }

    @Override
    public void onDataReceived(String response, int type) {
        Log.i("Response", response);
        view.onSlotsResponeCame(parseJSonResponse(response));
    }

    private ArrayList<AppointmentDateSlot> parseJSonResponse(String response) {
        ArrayList<AppointmentDateSlot> dateTimeSlots = new ArrayList<>();
        try {
            JSONObject slotsObj = new JSONObject(response.trim()).getJSONObject("slots");
            Iterator<?> keys = slotsObj.keys();

            while (keys.hasNext()) {
                String dateKey = (String) keys.next();
                if (slotsObj.get(dateKey) instanceof JSONObject) {
                    AppointmentDateSlot dateSlot = LoganSquare.parse(slotsObj.getJSONObject(dateKey).toString(), AppointmentDateSlot.class);
                    dateSlot.setDate(dateKey);
                    dateTimeSlots.add(dateSlot);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dateTimeSlots;
    }

    @Override
    public void onError(int type) {

    }

}
