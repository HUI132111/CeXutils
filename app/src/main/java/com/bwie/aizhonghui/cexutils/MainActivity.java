package com.bwie.aizhonghui.cexutils;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private  String url="http://japi.juhe.cn/comic/book?key=0f4685e288b6ccd0e9115a1693e4f7ed";
    private String urlpost="http://japi.juhe.cn/comic/book";
   @ViewInject(R.id.tv)
    TextView Htv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        //inject； 依赖，注射，添加
        x.view().inject(this);
        Htv.setText("哈喽！世界");
         //initget();
         initpost();
         //initother();
    }

    private void initother() {
        RequestParams params=new RequestParams(url);
        params.addParameter("type","少年漫画");
        x.http().request(HttpMethod.PUT,params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("其他解析"+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    //post请求
    private void initpost() {
        RequestParams params=new RequestParams(url);
        params.addBodyParameter("key","0f4685e288b6ccd0e9115a1693e4f7ed");
        params.addBodyParameter("type","少年漫画");
        params.addBodyParameter("skip","18");
       // params.addHeader("head","android");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("post请求"+result);
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

   //get请求
    private void initget() {
        RequestParams params=new RequestParams(url);
        params.addQueryStringParameter("type","少年漫画");
        params.addQueryStringParameter("skip","17");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
                System.out.println("get请求"+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        }) ;

    }
}
