package org.vinrays.corporate.application.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vinrays.corporate.application.dto.ContactDto;
import org.vinrays.corporate.application.mapper.ContactMapper;
import org.vinrays.corporate.application.model.ContactEntity;
import org.vinrays.corporate.application.service.ContactService;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class ContactController {

    @Autowired
    ContactService contactService;
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/contact")
    public ContactDto saveContact(@RequestBody ContactDto contactDto) throws MessagingException {
        ContactEntity contactEntity = ContactMapper.mapToEntity(contactDto);
        ContactEntity savedContactEntity = contactService.saveContactDetails(contactEntity);
        /*MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("test.test@gmail.com");
        helper.setTo("test.test@gmail.com");
        helper.setSubject("Contact Form Submission");
        helper.setText("Name: " + contactDto.getName() + "\nEmail: " + contactDto.getEmail() + "\nMessage: " + contactDto.getContact()+ "\nMessage: " + contactDto.getMessage());

        javaMailSender.send(message);*/
        return ContactMapper.mapToDto(savedContactEntity);
    }
}
