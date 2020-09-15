package com.example.mechinetest2.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.location.Address;
import android.location.Geocoder;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mechinetest2.Network.Api_interface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Myfunction {

    public static boolean isNetworkAvailable(Activity c) {
        boolean state;
        ConnectivityManager cmg = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cmg.getActiveNetworkInfo();
        state = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        if (state) {
            return true;
        } else {
            Toast.makeText(c, "No Internet Connection Available! Please Check your Connection", Toast.LENGTH_SHORT).show();
            return false;
        }
    }







    public static Api_interface ApisWithConverter() {
        okhttp3.OkHttpClient.Builder clientBuilder =
                new okhttp3.OkHttpClient.Builder()
                        .connectTimeout(40, TimeUnit.SECONDS)
                        .readTimeout(40, TimeUnit.SECONDS)
                        .writeTimeout(40, TimeUnit.SECONDS);

        Retrofit.Builder builder = new Retrofit.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder = clientBuilder.addInterceptor(interceptor);


        Retrofit retrofit = builder
                .baseUrl(Api_interface.base_url)
                .addConverterFactory(GsonConverterFactory.create())//add okHttp client
                .client(clientBuilder.build())
                .build();
        return retrofit.create(Api_interface.class);
    }
}
