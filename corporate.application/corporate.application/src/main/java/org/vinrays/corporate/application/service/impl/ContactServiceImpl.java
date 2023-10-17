package org.vinrays.corporate.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vinrays.corporate.application.model.ContactEntity;
import org.vinrays.corporate.application.repository.ContactRepository;
import org.vinrays.corporate.application.service.ContactService;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Override
    public ContactEntity saveContactDetails(ContactEntity contactEntity) {
        return contactRepository.save(contactEntity);
    }
}
