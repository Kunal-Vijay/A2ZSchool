package com.ktech.a2zschool.service;

import com.ktech.a2zschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
//@RequestScope
@SessionScope
public class ContactService {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ContactService() {
        System.out.println("Contact Service bean initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
//        TODO - Need to persist the data in DB table
        log.info(contact.toString());
        return isSaved;
    }
}
