package com.spring.service;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;

public interface MailService {
	public void sendMail(Collection<InternetAddress> to, String subject, String tempalte, Map<String, Object> model)
			throws AddressException, CannotSendEmailException, UnsupportedEncodingException;

	public void sendMail(Collection<InternetAddress> to, String subject, String tempalte, Map<String, Object> model,
			String pictureLink) throws AddressException, CannotSendEmailException, UnsupportedEncodingException;
}
