package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{


}
