package demoProject;

import java.util.ArrayList;

public class AnimalController {
	public static void main(String[] args) {
		Animal dog = new Animal("Buster", "dog", 4, 56);
		Animal cat = new Animal("mittens", "cat", 3, 56);
		
		System.out.println("Spring tool Suite is great!");
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
		
		myAnimals.add(dog);
		myAnimals.add(cat);
		
		
		for(Animal a : myAnimals) {
			System.out.println(a.getSpecies());
		}
		
		for(int a = 0; a < myAnimals.size(); a++) {
			a.getSpecies();
		}
		
		<c:forEach items="${myAnimals}" var="a">
		%${a.getSpecies);
	}
}
