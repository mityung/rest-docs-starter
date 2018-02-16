package com.vojtechruzicka.springfoxexample.controllers;

import com.vojtechruzicka.springfoxexample.domain.Person;
import com.vojtechruzicka.springfoxexample.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/persons/")
public class PersonController {

    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
