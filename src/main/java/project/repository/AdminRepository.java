package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findOneByLogin(String login);
}
