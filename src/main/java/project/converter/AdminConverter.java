package project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import project.model.Admin;
import project.repository.AdminRepository;

public class AdminConverter implements Converter<String, Admin> {
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Admin convert(String id) {
		return adminRepository.findOne(Long.parseLong(id));

	}
}
