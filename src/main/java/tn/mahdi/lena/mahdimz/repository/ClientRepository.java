package tn.mahdi.lena.mahdimz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.mahdi.lena.mahdimz.Entity.Client;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

	// Derived query by unique identifiant
	Optional<Client> findByIdentifiant(String identifiant);

	// JPQL query: clients whose first visit is between two dates (inclusive)
	@Query("SELECT c FROM Client c WHERE c.datePremiereVisite BETWEEN :start AND :end ORDER BY c.datePremiereVisite ASC")
	List<Client> findClientsFirstVisitBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
