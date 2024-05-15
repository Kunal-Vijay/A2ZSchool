package com.ktech.a2zschool.service;

import com.ktech.a2zschool.constants.A2ZSchoolContants;
import com.ktech.a2zschool.model.Contact;
import com.ktech.a2zschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public ContactService() {
        System.out.println("Contact Service bean initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(A2ZSchoolContants.OPEN);
        contact.setCreatedBy(A2ZSchoolContants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);
        if(null!=savedContact && savedContact.getContactId()>0){
            isSaved=true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(A2ZSchoolContants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId,String updatedBy){
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(A2ZSchoolContants.CLOSE);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if(null!=updatedContact&&updatedContact.getUpdatedBy()!=null){
            isUpdated=true;
        }
        return isUpdated;
    }
}
