package project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.model.Flat;

public interface FlatRepository extends JpaRepository<Flat, Long>{

	List<Flat> findByBuilding_Id(long buildingId);
}
