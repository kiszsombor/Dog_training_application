package hu.elte.DogTrainingApplication.controller;

import hu.elte.DogTrainingApplication.api.SeasonTicketService;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.wrapper.DogAndSeasonTicketWrapper;
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
//TODO: hiányzik a bérletek módosításáért felelős @PutMapping

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
     * @param wrapper
     * Új bérlet felvételéhez
     */
    @PostMapping("/save")
    public SeasonTicket post(@RequestBody DogAndSeasonTicketWrapper wrapper) {
        wrapper.setDog(wrapper.getSeasonTicket(),wrapper.getDog());
        System.out.println("DOG: "+wrapper.getDog());
        return seaonTicketService.save(wrapper.getSeasonTicket());
    }


    /**
     * @param id
     * @param wrapper
     * Put: id alapján meghatározott bérlet adatainak módosításáért felelős metódus
     */
    @PutMapping("/modify/{id}")
    public void put(@PathVariable Integer id, @RequestBody DogAndSeasonTicketWrapper wrapper) {
        wrapper.getSeasonTicket().setId(id);
        System.out.println("DOG: "+wrapper.getDog());
        wrapper.setDog(wrapper.getSeasonTicket(),wrapper.getDog());

        SeasonTicket oldSeasonTicket = seaonTicketService.findById(id).get();

        //System.out.println(("Old season ticket: "+oldSeasonTicket.toString()));
        System.out.println(("Old-seasontick: "+oldSeasonTicket));
        oldSeasonTicket.setSeasonTicket(wrapper.getSeasonTicket().getStartDate(),wrapper.getSeasonTicket().getEndDate(),wrapper.getSeasonTicket().getSpentTime(),
                wrapper.getSeasonTicket().getPaid(),wrapper.getSeasonTicket().getDog(),wrapper.getSeasonTicket().getSeasonTicketSegments());
        System.out.println(("Old-seasontick-after: "+oldSeasonTicket));

        seaonTicketService.save(oldSeasonTicket);

    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public SeasonTicket deleteSeasonTicket(@PathVariable("id") Integer id) {
        try {
            return seaonTicketService.deleteById(id);
        } catch (Exception e) {
            log.error("Nem sikerült a season ticket lekérdezése {}", e.getMessage());
            return null;
        }
    }
}