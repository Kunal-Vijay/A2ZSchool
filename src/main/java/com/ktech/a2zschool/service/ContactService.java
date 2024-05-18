package com.ktech.a2zschool.service;

import com.ktech.a2zschool.constants.A2ZSchoolContants;
import com.ktech.a2zschool.model.Contact;
import com.ktech.a2zschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
        Contact savedContact = contactRepository.save(contact);
        if(null!=savedContact && savedContact.getContactId()>0){
            isSaved=true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findOpenMsgs(
                A2ZSchoolContants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        int rows = contactRepository.updateMsgStatus(A2ZSchoolContants.CLOSE,contactId);
        if(rows>0){
            isUpdated=true;
        }
        return isUpdated;
    }
}
