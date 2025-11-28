package observer;

//Main class
public class ObserverPatternExample {
 public static void main(String[] args) {
     WeatherStation weatherStation = new WeatherStation();

     CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
     StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

     weatherStation.addObserver(currentConditionsDisplay);
     weatherStation.addObserver(statisticsDisplay);

     // Simulate a change in temperature
     weatherStation.setTemperature(25.5f);
     // Output:
     // Current Conditions Display: Temperature = 25.5
     // Statistics Display: Temperature = 25.5

     // Simulate another change in temperature
     weatherStation.setTemperature(30.0f);
     // Output:
     // Current Conditions Display: Temperature = 30.0
     // Statistics Display: Temperature = 30.0

     // Remove an observer
     weatherStation.removeObserver(currentConditionsDisplay);

     // Simulate another change in temperature
     weatherStation.setTemperature(28.0f);
     // Output:
     // Statistics Display: Temperature = 28.0
 }
}
