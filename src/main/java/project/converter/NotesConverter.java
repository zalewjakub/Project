package project.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import project.model.Notes;
import project.repository.NotesRepository;

public class NotesConverter implements Converter<String, Notes> {
	@Autowired
	NotesRepository notesRepository;
	
	@Override
	public Notes convert(String id) {
		return notesRepository.findOne(Long.parseLong(id));
	}

}
