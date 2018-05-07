package com.journaldev.retrofitintro.RetryPolicy;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Response;

class RetryCallback<T> implements CustomCallback<T> {

  private static final String TAG = RetryCallback.class.getSimpleName();
  private final Call<T> call;
  private int totalRetries = 0;
  private int retryCount = 0;

  RetryCallback(Call<T> call, int totalRetries) {
    this.call = call;
    this.totalRetries = totalRetries;
  }

  @Override
  public void onResponse(Call<T> call, Response<T> response) {
    if (!RetryHelper.isCallSuccess(response)) {
      if (retryCount++ < totalRetries) {
        Log.w(TAG, "Retry Network Call -  [" + retryCount + " / " + totalRetries + "}");
        retry();
      } else {
        Log.w(TAG, "Fail Response with - " + response.code());
        onFinalFail(response.code(), call, response);
      }
    } else {
      onFinalResponse(call, response);
    }
  }


  @Override
  public void onFailure(Call<T> call, Throwable t) {
    onFinalFailure(call, t);
  }

  @Override
  public void onFailResponse(int errorCode, Call<T> call, Response<T> response) {
    onFinalFail(response.code(), call, response);
  }

  public void onFinalResponse(Call<T> call, Response<T> response) {

  }

  public void onFinalFailure(Call<T> call, Throwable t) {

  }

  public void onFinalFail(int errorCode, Call<T> call, Response<T> response) {

  }

  private void retry() {
    call.clone().enqueue(this);
  }
}