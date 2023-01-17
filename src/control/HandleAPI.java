/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.google.gson.Gson;
import data.JsonResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *
 * @author Administrator
 */
public class HandleAPI {
    public static JsonResult getJsonData(String city) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        JsonResult data = null;
        Request res = new Request.Builder().url("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&APPID=bffca17bcb552b8c8e4f3b82f64cccd2&units=metric").build();
        try {
            Response response = client.newCall(res).execute();
            ResponseBody body = response.body();
            data = gson.fromJson(body.string(), JsonResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
