package com.example.Sprinkfoodapp.service;

import java.io.File;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Sprinkfoodapp.dto.BaseRequest;
import com.example.Sprinkfoodapp.model.EmailDetails;
import com.example.Sprinkfoodapp.model.User;
import com.example.Sprinkfoodapp.repository.UserRepository;


@Service
public class EmailServiceImpl implements EmailService{
 
	String forgottoken=null;
	String emailUserOne=null;
	
	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	
	 @Value("${spring.mail.username}") 
	 private String sender;
	 
	 @Override
	 public String sendSimpleMail(EmailDetails details) {
		 try {
			 
	            SimpleMailMessage mailMessage= new SimpleMailMessage();
	 
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(details.getRecipient());
	            mailMessage.setText(details.getMsgBody());
	            mailMessage.setSubject(details.getSubject());
	 
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 
	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
	
	
	
	
	
	@Override
	public String forgot(String email,HttpServletRequest request)
	{
		
		
		User u=null;
		
		
		
		
		
		try {
			u= userRepository.findByEmail(email);
			System.out.println(u.getEmail());
			emailUserOne=u.getEmail();
		} catch (NullPointerException e) {
		   return "We didn't find an account for that e-mail address";
		}
		if(u.getEmail().equals(email))
		{
			
			
			
			String token=UUID.randomUUID().toString();
			
			forgottoken=token;
			String appUrl = request.getScheme() + "://" + request.getServerName();
			try {
				
				SimpleMailMessage passwordResetEmail= new SimpleMailMessage();
				passwordResetEmail.setFrom(sender);
				passwordResetEmail.setTo("lingamurthy5364@gmail.com");
				passwordResetEmail.setSubject("Password Reset Request");
				passwordResetEmail.setText("To reset your password, click the link below:\n" + appUrl
						+ "/reset?token=" + token);
				
				
				javaMailSender.send(passwordResetEmail);
				
			}  catch (Exception e) {
	             System.out.println("Error while Sending Mail");;
	        }
			
			return appUrl;
			
		}
		
		return "We didn't find an account for that e-mail address";
	}

	/*
	 * 
	 * public void reset(User u) {
	 * 
	 * 
	 * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	 * u.setPassword(encoder.encode(u.getPassword()));
	 * 
	 * userRepository.save(u); }
	 */
}
