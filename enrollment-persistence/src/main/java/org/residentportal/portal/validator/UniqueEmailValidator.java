package org.residentportal.portal.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.residentportal.portal.annotation.UniqueEmail;
import org.residentportal.portal.repository.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    
	@Autowired
	private UserRepository ur;
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(ur==null)
		{
			return true;
		}
		return ur.findByEmail(email)==null;
	}

}
