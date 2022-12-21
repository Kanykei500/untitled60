package service.impl;

import dao.DataBase;
import gender.Gender;
import model.Animal;
import model.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalServiceImpl implements GenericService<Animal> {
     DataBase animalss= new DataBase();
    @Override
    public String add(List<Animal> t) {
        this.animalss.getAnimals().addAll(t);
        return "Successfully Added";

    }
    @Override
    public Animal getById(Long id) {

        return animalss.getAnimals().stream().filter(x-> x.getId() == id).findAny().get();

    }


    @Override
    public String removeByName(String name) {
//        List<Animal>animals=animalss.getAnimals().stream().filter(x->x.getName().equals(name)).toList();
        Animal animal = animalss.getAnimals().stream().
                filter(x -> x.getName().equalsIgnoreCase(name)).findAny().get();
        animalss.getAnimals().remove(animal);
        return "Animal successfully removed!";

    }

    @Override
    public List<Animal> getAll() {
        return animalss.getAnimals();

    }

    @Override
    public List<Animal> sortByName() {
        System.out.println("write command:\n1-ascending" +
                "\n2-descending");
        Scanner scanner=new Scanner(System.in);
        int number= scanner.nextInt();
        switch (number){
            case 1:
                List<Animal>list=animalss.getAnimals().
                        stream().sorted(Comparator.comparing(Animal::getName)).toList();
                return list;
            case 2:
                List<Animal>list1=animalss.getAnimals().
                        stream().sorted(Comparator.comparing(Animal::getName).reversed()).toList();
                return list1;

            }



        return null;

    }

    @Override
    public List<Animal> filterByGender() {
        System.out.println("write command:\n1-ascending" +
                "\n2-descending");
        Scanner scanner=new Scanner(System.in);
        int number= scanner.nextInt();
        switch (number) {
            case 1:
                List<Animal> animals = animalss.getAnimals().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
                return animals;
            case 2:
                List<Animal> animals1 = animalss.getAnimals().stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
                return animals1;
        }
        return null;
    }

    @Override
    public List<Animal> clear() {
        animalss.getAnimals().clear();
        return animalss.getAnimals();
    }



}
