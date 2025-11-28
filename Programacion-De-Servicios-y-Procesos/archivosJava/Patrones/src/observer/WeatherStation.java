package observer;

import java.util.*;
//Subject (Observable)
class WeatherStation {
 private List<Observer> observers = new ArrayList<>();
 private float temperature;
 public void addObserver(Observer observer) {
     observers.add(observer);
 }
 public void removeObserver(Observer observer) {
     observers.remove(observer);
 }
 public void setTemperature(float temperature) {
     this.temperature = temperature;
     notifyObservers();
 }
 private void notifyObservers() {
     for (Observer observer : observers) {
         observer.update(temperature);
     }
 }
}
