import gender.Gender;
import model.Animal;
import model.Person;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnimalServiceImpl animalService=new AnimalServiceImpl();
        PersonServiceImpl personService=new PersonServiceImpl();
        List<Animal> animals=List.of( new Animal(1L,"cat",1, Gender.FEMALE),
        new Animal(2L,"dog",2, Gender.MALE),
        new Animal(3L,"cow",3, Gender.FEMALE));

        List<Person>people=List.of(
                new Person(3L,"Kanykei",19,Gender.FEMALE),
                new Person(4L,"Aigerim",21,Gender.FEMALE),
                new Person(5L,"Adil",18,Gender.MALE));
        while (true){
            System.out.println("""
                  ~~~~~~Animals~~~~
                  1.ADD ANIMAL
                  2.Get by Id
                  3.Remove by name
                  4.Get all animals
                  5.Sort by name
                  6.Filter by gender
                  7.Clear animal
                  
                  
                  ~~~~~~~Person~~~~~~~
                  8.ADD PERSON
                  9.Ger by Id
                  10.Remove by name
                  11.Get all PERSON
                  12.Sort by name
                  13.Filter by gender
                  14.Clear person
                  
                  
                  
                  Write command:
                  
                    """);
            Scanner scanner=new Scanner(System.in);
            int number= scanner.nextInt();
            switch (number){
                case 1:
                    System.out.println(animalService.add(animals));
                    break;
                case 2:
                    System.out.println("id:");
                    long id=new Scanner(System.in).nextLong();
                    System.out.println(animalService.getById(id));
                    break;
                case 3:
                    System.out.println("Name:");
                    String name=new Scanner(System.in).nextLine();
                    System.out.println(animalService.removeByName(name));
                    break;
                case 4:
                    System.out.println(animalService.getAll());
                    break;

                case 5:
                    System.out.println(animalService.sortByName());
                    break;
                case 6:
                    System.out.println(animalService.filterByGender());
                    break;
                case 7:
                    System.out.println(animalService.clear());
                    break;
                case 8:
                    System.out.println(personService.add(people));
                    break;
                case 9:
                    System.out.println("ID:");
                    long id1=new Scanner(System.in).nextLong();
                    System.out.println(personService.getById(id1));
                    break;
                case 10:
                    System.out.println("Name:");
                    String name1=new Scanner(System.in).nextLine();
                    personService.removeByName(name1);
                    break;
                case 11:
                    System.out.println(personService.getAll());
                    break;
                case 12:
                    System.out.println(personService.sortByName());
                    break;
                case 13:
                    System.out.println(personService.filterByGender());
                    break;
                case 14:
                    System.out.println(personService.clear());
                    break;


            }
        }

    }
}