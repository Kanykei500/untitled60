package service.impl;

import dao.DataBase;
import gender.Gender;
import model.Animal;
import model.Person;
import service.GenericService;

import java.util.*;

public class PersonServiceImpl implements GenericService<Person> {

    DataBase peoplee=new DataBase();


    @Override
    public String add(List<Person> t) {
        //
        this.peoplee.getPeople().addAll(t);
        return "Successfully Added !";

    }

    @Override
    public Person getById(Long id) {

       return peoplee.getPeople().stream().filter(x->x.getId()==id).findAny().get();
    }

    @Override
    public String removeByName(String name) {

        Person person = peoplee.getPeople().stream().filter(x -> x.getName().equalsIgnoreCase(name)).findAny().get();
        peoplee.getPeople().remove(person);
         return "Successfully removed";
    }
    @Override
    public List<Person> getAll() {
        return peoplee.getPeople();
    }

    @Override
    public List<Person> sortByName() {
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        switch (number){
            case 1:
                List<Person>people=peoplee.getPeople().stream().
                        sorted(Comparator.comparing(Person::getName)).toList();
                return people;
            case 2:
                List<Person>people1=peoplee.getPeople().stream().
                        sorted(Comparator.comparing(Person::getName).reversed()).toList();
                return people1;
        }
        return null;
    }
    @Override
    public List<Person> filterByGender() {
        System.out.println("1:  Female");
        System.out.println("2: Male" +
                "");
         switch (new Scanner(System.in).nextInt()){
             case 1:
                 List<Person> peoplee1=peoplee.getPeople().stream().filter(x->x.getGender().equals(Gender.FEMALE)).toList();
            return peoplee1;
             case 2:
                 List<Person>personList = peoplee.getPeople().stream().filter(x->x.getGender().equals(Gender.MALE)).toList();
         return personList;
         }

        return null;
    }

    @Override
    public List<Person> clear() {
         peoplee.getPeople().clear();
        return peoplee.getPeople();

    }
}
