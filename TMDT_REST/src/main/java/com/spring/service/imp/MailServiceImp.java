package com.spring.service.imp;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.service.MailService;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.ImageType;
import it.ozimov.springboot.mail.model.InlinePicture;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultInlinePicture;
import it.ozimov.springboot.mail.service.EmailService;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;

@Service
public class MailServiceImp implements MailService {

	@Autowired
	private EmailService emailService;
	@Value("${email.from}")
	private String sendFrom;

	@Override
	public void sendMail(Collection<InternetAddress> to, String subject, String tempalte, Map<String, Object> model)
			throws AddressException, CannotSendEmailException, UnsupportedEncodingException {
		Email email = DefaultEmail.builder().from(new InternetAddress(sendFrom)).to(to).subject(subject).body("")
				.encoding("UTF-8").build();
		emailService.send(email, tempalte, model);
	}

	@Override
	public void sendMail(Collection<InternetAddress> to, String subject, String tempalte, Map<String, Object> model,
			String pictureLink) throws AddressException, CannotSendEmailException, UnsupportedEncodingException {
		Email email = DefaultEmail.builder().from(new InternetAddress(sendFrom)).to(to).subject(subject).body("")
				.encoding("UTF-8").build();
		String path = this.getClass().getResource("/static/images/").getFile();
		File file = new File(path + pictureLink);
		InlinePicture inlinePicture = DefaultInlinePicture.builder().file(file).imageType(ImageType.PNG).templateName(file.getName()).build();
		emailService.send(email, tempalte, model, inlinePicture);
	}
}
