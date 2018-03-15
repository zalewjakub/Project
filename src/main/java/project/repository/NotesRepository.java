package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{
	
	List<Notes>  findById(long id);
//	Notes findOneByHomeovner_Id(long homeovnerId);

}
