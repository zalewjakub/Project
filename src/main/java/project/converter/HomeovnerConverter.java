package project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import project.model.Homeovner;
import project.repository.HomeovnerRepository;

public class HomeovnerConverter implements Converter<String, Homeovner> {
	@Autowired
	HomeovnerRepository homeovnerRepository;
	
	@Override
	public Homeovner convert(String id) {
		return homeovnerRepository.findOne(Long.parseLong(id));
	}

}
