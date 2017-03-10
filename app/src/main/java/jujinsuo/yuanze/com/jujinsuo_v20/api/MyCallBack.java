package jujinsuo.yuanze.com.jujinsuo_v20.api;


import jujinsuo.yuanze.com.jujinsuo_v20.reponse.HttpExceptionBean;

/**
 * 发送请求后的回调接口
 */

interface MyCallBack<T>  {
   void onCompleted();
   void onError(HttpExceptionBean mHttpExceptionBean);
   void onNext(T t);
}
