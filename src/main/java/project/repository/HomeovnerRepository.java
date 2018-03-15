package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.model.Homeovner;

public interface HomeovnerRepository extends JpaRepository<Homeovner, Long>{
	Homeovner findOneByLogin(String login);
	Homeovner findOneById(long id);
	List<Homeovner> findByLastName(String lastName);

}
