package com.ktech.a2zschool.service;

import com.ktech.a2zschool.constants.A2ZSchoolContants;
import com.ktech.a2zschool.model.Contact;
import com.ktech.a2zschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        int result = contactRepository.saveContactMsg(contact);
        if(result>0){
            isSaved=true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(A2ZSchoolContants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId,String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,A2ZSchoolContants.CLOSE,updatedBy);
        if(result>0){
            isUpdated=true;
        }
        return isUpdated;
    }
}
