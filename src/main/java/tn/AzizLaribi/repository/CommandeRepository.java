package tn.AzizLaribi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.AzizLaribi.Entity.Client;
import tn.AzizLaribi.Entity.Commande;
import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findByClient(Client client);

    List<Commande> findByClientAndDateCommandeBetween(Client client, LocalDate startDate, LocalDate endDate);

    List<Commande> findByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate);
}