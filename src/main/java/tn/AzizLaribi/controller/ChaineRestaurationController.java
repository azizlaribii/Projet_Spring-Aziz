package tn.AzizLaribi.controller;

import org.springframework.web.bind.annotation.*;
import tn.AzizLaribi.Entity.ChaineRestauration;
import tn.AzizLaribi.services.IChaineRestaurationService;

import java.util.List;

@RestController
@RequestMapping("/chaines")
public class ChaineRestaurationController {

    private final IChaineRestaurationService chaineRestaurationService;

    public ChaineRestaurationController(IChaineRestaurationService chaineRestaurationService) {
        this.chaineRestaurationService = chaineRestaurationService;
    }

    // GET all chaines
    @GetMapping
    public List<ChaineRestauration> getAllChaines() {
        return chaineRestaurationService.retrieveAllChaines();
    }

    // GET chaine by id
    @GetMapping("/{id}")
    public ChaineRestauration getChaine(@PathVariable Long id) {
        return chaineRestaurationService.retrieveChaine(id);
    }

    // POST create new chaine
    @PostMapping
    public ChaineRestauration createChaine(@RequestBody ChaineRestauration chaine) {
        return chaineRestaurationService.addChaine(chaine);
    }

    // PUT update chaine
    @PutMapping
    public ChaineRestauration updateChaine(@RequestBody ChaineRestauration chaine) {
        return chaineRestaurationService.updateChaine(chaine);
    }

    // DELETE chaine by id
    @DeleteMapping("/{id}")
    public void deleteChaine(@PathVariable Long id) {
        chaineRestaurationService.removeChaine(id);
    }
}
