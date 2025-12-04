package tn.AzizLaribi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.AzizLaribi.Entity.Client;
import tn.AzizLaribi.Entity.Commande;
import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
        @Query("SELECT c FROM Commande c " +
                "WHERE YEAR(c.dateCommande) = :year " +
                "ORDER BY c.note DESC")
        List<Commande> findByYearOrderByNote(@Param("year") int year);

    @Query("SELECT c.menu.libelleMenu, COUNT(c) " +
            "FROM Commande c " +
            "GROUP BY c.menu.libelleMenu " +
            "ORDER BY COUNT(c) DESC")
    List<Object[]> findMostOrderedMenu();

    List<Commande> findByClient(Client client);

    List<Commande> findByClientAndDateCommandeBetween(Client client, LocalDate startDate, LocalDate endDate);

    List<Commande> findByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate);
}
