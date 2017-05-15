package me.larsfx.rc;

public enum Rides {
	
	SPEEDOFSOUND("Speed of Sound", 11, 0, "§c"),
	XPRESS("Xpress", 10, 1, "§c"),
	ELCONDOR("El Condor", 12, 2, "§c"),
	GOLIATH("Goliath", 13, 3, "§c"),
	ROBINHOOD("Robin Hood", 14, 4, "§c"),
	LOSTGRAVITY("Lost Gravity", 15, 5, "§c"),
	EXCALIBUR("Excalibur", 16, 6, "§c"),
	NEUROGEN("NeuroGen", 17, 7, "§c"),
	CRAZYRIVER("Crazy River", 19, 8, "§a"),
	ELRIOGRANDE("El Rio Grande", 20, 9, "§a"),
	MERLINSMAGICCASTLE("Merlins Magic Castle", 21, 10, "§a"),
	KARTBAAN("Kartbaan", 22, 11, "§a"),
	SPLASHBATTLE("Splash Battle", 28, 12, "§e"),
	PAVILLONDETHE("Pavillon De Thé", 31, 13, "§e"),
	LETOURDESJARDINS("Le Tour Des Jardins", 30, 14, "§e"),
	DRAKO("Drako", 29, 15, "§e");
	
	Rides(String name, int position, int ridecounter, String color) {
		this.name = name;
		this.position = position;
		this.color = color;
		this.ridecounter = ridecounter;
	}
	
	private String name;
	private int position;
	private int ridecounter;
	private String color;
	
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}

	public String getColor() {
		return color;
	}
	public int getRideCounter() {
		return ridecounter;
	}
}