package facade;

public class SmartHomeFacade {
    private Lighting lighting;
    private MusicSystem musicSystem;
    private ClimateControl climateControl;

    public SmartHomeFacade(Lighting lighting, MusicSystem musicSystem, ClimateControl climateControl) {
        this.lighting = lighting;
        this.musicSystem = musicSystem;
        this.climateControl = climateControl;
    }

    public void startEveningRoutine() {
        lighting.on();
        musicSystem.playMusic();
        climateControl.setTemperature(22);
    }

    public void endEveningRoutine() {
        lighting.off();
        musicSystem.stopMusic();
    }
}
