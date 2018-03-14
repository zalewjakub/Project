package project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import project.model.Flat;
import project.repository.FlatRepository;

public class FlatConverter implements Converter<String, Flat> {
	@Autowired
	FlatRepository flatRepository;
	
	@Override
	public Flat convert(String id) {
		return flatRepository.findOne(Long.parseLong(id));

	}
}
