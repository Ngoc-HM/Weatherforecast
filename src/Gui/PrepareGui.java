/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import control.HandleAPI;
import data.DailyWeather;
import data.JsonResult;
import data.Weather;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class PrepareGui {

    private WeatherApp weather;
    private JsonResult result;
    private ArrayList<Weather> listResult;
    private int idx = 0;

    public PrepareGui() {
        weather = new WeatherApp();
        prepare();
    }

    public WeatherApp getWeather() {
        return weather;
    }

    private void prepare() {
        weather.getBtn_find().setActionCommand("find");
        weather.getBtn_find().addActionListener(new ButtonClick());

        weather.getBtn_next().setActionCommand("next");
        weather.getBtn_next().addActionListener(new ButtonClick());

        weather.getBtn_pre().setActionCommand("pre");
        weather.getBtn_pre().addActionListener(new ButtonClick());
    }

    private void show() {

        String date = " Ngày: " + result.getList()[idx].getDt_txt();
        String city = " Thành phố: " + result.getCity().getName();
        String nation = " Quốc gia: " + result.getCity().getCountry();
        String weath = " Thời tiết: " + result.getList()[idx].getWeather()[0].getDescription();
        String nhietDo = " Nhiệt độ: " + result.getList()[idx].getMain().getTemp() + " độ C";
        String apXuat = " Ap xuất: " + result.getList()[idx].getMain().getPresure();
        String doAm = " Độ ẩm: " + result.getList()[idx].getMain().getHumidity();
        String winSpeed = " Tốc độ gió: " + result.getList()[idx].getWind().getSpeed();
        String clouds = " Mây: " + result.getList()[idx].getClouds().getAll() + "%";

        weather.getLb_apXuat().setText(apXuat);
        weather.getLb_city().setText(city);
        weather.getLb_cloud().setText(clouds);
        weather.getLb_date().setText(date);
        weather.getLb_doAm().setText(doAm);
        weather.getLb_nation().setText(nation);
        weather.getLb_nhietDo().setText(nhietDo);
        weather.getLb_weather().setText(weath);
        weather.getLb_windSpeed().setText(winSpeed);
    }

    public class ButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            if (command.equals("find")) {
                find();
                idx = 0;
            } else if (command.equals("next")) {
                idx = idx == 39 ? idx : idx + 1;
            } else if (command.equals("pre")) {
                idx = idx == 0 ? idx : idx - 1;
            }
            show();
        }

        private void find() {
            result = HandleAPI.getJsonData((String) weather.getCb_city().getSelectedItem());
        }
    }
}
