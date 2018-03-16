package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{
	
	List<Notes>  findById(long id);
	@Query(value="SELECT * FROM notes WHERE homeovner_id= ?1 ORDER BY created DESC LIMIT 1", nativeQuery=true)
	Notes findUsingCreationTime(long id);
	
	Notes findOneByHomeovner_Id(long homeovnerId);
	List<Notes> findAllByHomeovner_Id(long Id);

}
