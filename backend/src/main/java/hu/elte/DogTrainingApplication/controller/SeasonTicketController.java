package hu.elte.DogTrainingApplication.controller;

import hu.elte.DogTrainingApplication.api.SeasonTicketService;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author: Bajári LÚCIA
 * @category: controller
 *
 * A SeasonTicketService kommunikációjáért felel.
 */
@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/season_tickets")
public class SeasonTicketController {
    @Autowired
    private SeasonTicketService seaonTicketService;

    /**
     * @return Iterable<SeasonTicket>
     *     Összes bérlet lekérdezése
     */
    @GetMapping("")
    public Iterable<SeasonTicket> getAll() {
        return seaonTicketService.findAll();
    }

    /**
     * @param id
     * @return ResponseEntity<SeasonTicket>
     *     Bérlet lekérdezése id alapján.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SeasonTicket> getSeasonTicketById(@PathVariable Integer id) {
        Optional<SeasonTicket> optional= seaonTicketService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param seaonTicket
     * Új bérlet felvételéhez
     */
    @PostMapping("/save")
    public void post(@RequestBody SeasonTicket seaonTicket) {
        seaonTicketService.save(seaonTicket);
    }

}