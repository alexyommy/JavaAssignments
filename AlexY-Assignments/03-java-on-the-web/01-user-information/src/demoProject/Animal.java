package demoProject;

public class Animal {
	private String name;
	private String species;
	private int age;
	private int strength;
	
	public Animal() {
		
	}	
	
	public Animal(String name, String species, int age, int strength) {
		this.name = name;
		this.species = species;
		this.age = age;
		this.strength = strength;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
}
