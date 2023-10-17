package org.vinrays.corporate.application.service;

import org.springframework.stereotype.Service;
import org.vinrays.corporate.application.model.ContactEntity;

public interface ContactService {
    public ContactEntity saveContactDetails(ContactEntity contactEntity);
}
