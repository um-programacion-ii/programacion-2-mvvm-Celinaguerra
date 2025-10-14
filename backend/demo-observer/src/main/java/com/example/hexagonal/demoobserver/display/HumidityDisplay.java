package com.example.hexagonal.demoobserver.display;

import com.example.hexagonal.demoobserver.model.WeatherData;
import com.example.hexagonal.demoobserver.observer.Observer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HumidityDisplay implements Observer<WeatherData> {

    private float currentHumidity;

    public HumidityDisplay() {
        this.currentHumidity = 0.0f;
        log.info("Humidity Display Initialized");
    }

    @Override
    public void update(WeatherData weatherData) {
        if (weatherData != null) {
            this.currentHumidity = weatherData.getHumidity();
            display();
        } else {
            log.warn("Datos meteorológicos nulos");
        }
    }

    private void display() {
        log.info("Display de Humedad: {}%", String.format("%.1f", this.currentHumidity));
    }

    public float getCurrentHumidity() {
        return this.currentHumidity;
    }
}
