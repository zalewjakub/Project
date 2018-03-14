package project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import project.model.Building;
import project.repository.BuildingRepository;

public class BuildingConverter implements Converter<String, Building> {
	@Autowired
	BuildingRepository buildingRepository;
	
	@Override
	public Building convert(String id) {
		return buildingRepository.findOne(Long.parseLong(id));
	}

}
