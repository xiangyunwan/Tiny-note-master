package com.ggccnu.tinynote.util;

public interface HttpCallbackListener {

	void onFinish(String response);

	void onError(Exception e);

}
