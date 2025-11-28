package facade;

public class Demo {
public static void main(String[] args) {
	Lighting light= new Lighting();
	MusicSystem ms= new MusicSystem();
	ClimateControl cc= new ClimateControl();
	SmartHomeFacade shf= new SmartHomeFacade(light, ms, cc);
	shf.startEveningRoutine();
	System.out.println("________________");
	shf.endEveningRoutine();
}
}
