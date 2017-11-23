package com.spring;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.service.MailService;

import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
	

	
	@Autowired
	MailService  mailService;
	
	@Value("${email.from}")
	private String sendFrom;

	@Test
	public void testSendMail() throws AddressException, UnsupportedEncodingException, CannotSendEmailException {
			Collection<InternetAddress> to = new ArrayList<>();
			to.add(new InternetAddress("lang.tt16@gmail.com"));
			Map<String, Object> map = new HashMap<>();
			
			mailService.sendMail(to, "Test send mail","/mail_template/register.html", map,"logo.png");
	}
	
	@Test
	public void testGetFrom() {
		System.err.println(sendFrom);
	}

}
