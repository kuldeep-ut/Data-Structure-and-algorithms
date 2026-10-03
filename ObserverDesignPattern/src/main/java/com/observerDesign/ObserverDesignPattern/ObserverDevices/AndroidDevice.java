package com.observerDesign.ObserverDesignPattern.ObserverDevices;

import com.observerDesign.ObserverDesignPattern.WeatherStation.WeatherStation;

public class AndroidDevice implements Devices{
    private final WeatherStation weatherStation;

    public AndroidDevice(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.subscribe(this);
    }

    @Override
    public void update() {
        System.out.println("There is an update from Weather station");
    }
}
