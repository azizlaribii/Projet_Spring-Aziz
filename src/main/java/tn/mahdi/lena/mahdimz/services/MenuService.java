package tn.mahdi.lena.mahdimz.services;

import org.springframework.stereotype.Service;
import tn.mahdi.lena.mahdimz.Entity.Menu;
import tn.mahdi.lena.mahdimz.repository.MenuRepository;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> retrieveAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu retrieveMenu(Long idMenu) {
        return menuRepository.findById(idMenu).orElse(null);
    }

    @Override
    public void removeMenu(Long idMenu) {
        menuRepository.deleteById(idMenu);
    }

    @Override
    public List<Menu> findByTypeMenuAndPrixTotalGreaterThan(tn.mahdi.lena.mahdimz.Entity.TypeMenu type, Float prixMin) {
        return menuRepository.findByTypeMenuAndPrixTotalGreaterThan(type, prixMin);
    }

    @Override
    public List<Menu> findMenusByTypeWithComposantPriceGreaterThan(tn.mahdi.lena.mahdimz.Entity.TypeMenu type, Float prix) {
        return menuRepository.findMenusByTypeWithComposantPriceGreaterThan(type, prix);
    }
}
