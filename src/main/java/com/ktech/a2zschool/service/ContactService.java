package com.ktech.a2zschool.service;

import com.ktech.a2zschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private static Logger log = LoggerFactory.getLogger(ContactService.class);
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
//        TODO - Need to persist the data in DB table
        log.info(contact.toString());
        return isSaved;
    }
}
