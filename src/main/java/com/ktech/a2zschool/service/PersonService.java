package com.ktech.a2zschool.service;


import com.ktech.a2zschool.constants.A2ZSchoolContants;
import com.ktech.a2zschool.model.Person;
import com.ktech.a2zschool.model.Roles;
import com.ktech.a2zschool.repository.PersonRepository;
import com.ktech.a2zschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(A2ZSchoolContants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}