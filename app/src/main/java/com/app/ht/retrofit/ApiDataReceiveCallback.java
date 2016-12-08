package com.app.ht.retrofit;

public interface ApiDataReceiveCallback {
	void onDataReceived(String response, int type);
	void onError(int type);
}
