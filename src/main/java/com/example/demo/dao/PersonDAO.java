package com.example.demo.dao;

import com.example.demo.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Олег", "Oleg@gmail.com", "pass1"));
        people.add(new Person(++PEOPLE_COUNT, "Яша", "Yasha@gmail.com", "pass2"));
        people.add(new Person(++PEOPLE_COUNT, "Ян", "Yan@gmail.com", "pass3"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(people.size()+1);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        if (personToBeUpdated != null) {
            personToBeUpdated.setUsername(updatedPerson.getUsername());
            personToBeUpdated.setEmail(updatedPerson.getEmail());
            personToBeUpdated.setPassword(updatedPerson.getPassword());
        }
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
