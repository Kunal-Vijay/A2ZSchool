package com.ktech.a2zschool.service;

import com.ktech.a2zschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContactService {
//    private static Logger log = LoggerFactory.getLogger(ContactService.class);
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
//        TODO - Need to persist the data in DB table
        log.info(contact.toString());
        return isSaved;
    }
}
