package org.vinrays.corporate.application.mapper;

import org.vinrays.corporate.application.dto.ContactDto;
import org.vinrays.corporate.application.model.ContactEntity;

public class ContactMapper {
    public static ContactDto mapToDto(ContactEntity contactEntity)
    {
        ContactDto contactDto = new ContactDto(
                contactEntity.getId(),
                contactEntity.getName(),
                contactEntity.getEmail(),
                contactEntity.getContact(),
                contactEntity.getMessage()
        );
        return contactDto;
    }

    public static ContactEntity mapToEntity(ContactDto contactDto)
    {
        ContactEntity contactEntity = new ContactEntity(
                contactDto.getId(),
                contactDto.getName(),
                contactDto.getEmail(),
                contactDto.getContact(),
                contactDto.getMessage()
        );
        return contactEntity;
    }
}
