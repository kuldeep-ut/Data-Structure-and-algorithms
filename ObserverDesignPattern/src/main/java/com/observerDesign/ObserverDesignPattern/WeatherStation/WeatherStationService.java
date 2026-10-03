package com.observerDesign.ObserverDesignPattern.WeatherStation;

import com.observerDesign.ObserverDesignPattern.ObserverDevices.Devices;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationService implements WeatherStation{
    private final List<Devices> observerDevice;
    WeatherStationService(List<Devices> observerDevice){
        this.observerDevice = new ArrayList<>();
    }
    @Override
    public void subscribe(Devices device){
        observerDevice.add(device);
    }
    @Override
    public void unsubscribe(Devices device){
        observerDevice.remove(device);
    }
    @Override
    public void notifyAllDevices(){
        for(Devices device : observerDevice){
            device.update();
        }
    }
}
