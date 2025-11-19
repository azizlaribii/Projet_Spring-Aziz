package tn.AzizLaribi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.AzizLaribi.Entity.Menu;
import tn.AzizLaribi.Entity.TypeMenu;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    // Derived query: by type and priceTotal greater than value
    List<Menu> findByTypeMenuAndPrixTotalGreaterThan(TypeMenu typeMenu, Float prixMin);

    // JPQL: menus of a type that contain at least one composant with price greater than value
    @Query("SELECT DISTINCT m FROM Menu m JOIN m.composants c WHERE m.typeMenu = :type AND c.prix > :prix")
    List<Menu> findMenusByTypeWithComposantPriceGreaterThan(@Param("type") TypeMenu type,
                                                            @Param("prix") Float prix);

    Optional<Menu> findByLibelleMenu(String libelleMenu);
}