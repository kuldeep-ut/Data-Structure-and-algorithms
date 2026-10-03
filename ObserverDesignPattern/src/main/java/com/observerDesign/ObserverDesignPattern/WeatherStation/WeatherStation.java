package com.observerDesign.ObserverDesignPattern.WeatherStation;

import com.observerDesign.ObserverDesignPattern.ObserverDevices.Devices;

public interface WeatherStation {
    void notifyAllDevices();
    void unsubscribe(Devices device);
    void subscribe(Devices device);
}
