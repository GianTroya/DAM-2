package observer;

//Concrete Observer
class StatisticsDisplay implements Observer {
 private float temperature;

 @Override
 public void update(float temperature) {
     this.temperature = temperature;
     display();
 }

 private void display() {
     System.out.println("Statistics Display: Temperature = " + temperature);
 }
}
