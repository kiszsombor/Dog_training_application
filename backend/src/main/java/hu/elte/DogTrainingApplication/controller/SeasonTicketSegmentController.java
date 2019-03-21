package hu.elte.DogTrainingApplication.controller;

import hu.elte.DogTrainingApplication.api.SeasonTicketSegmentService;
import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author: Bajári LÚCIA
 *
 * @category controller
 *  * A SeasonTicketSegment Service kommunikációjáért felel.
 * @version 0.0.1
 */
@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/season_tickets_segment")
public class SeasonTicketSegmentController {
    @Autowired
    private SeasonTicketSegmentService seaonTicketSegmentService;

    /**
     * @return Iterable<SeasonTicketSegment>
     *     Az összes bérlet szegmens lekérdezése
     */
    @GetMapping("")
    public Iterable<SeasonTicketSegment> getAll() {
        return seaonTicketSegmentService.findAll();
    }

    /**
     * @param id
     * @return ResponseEntity<SeasonTicketSegment>
     *     Id alapján bérlet szegment lekérdezése
     */
    @GetMapping("/{id}")
    public ResponseEntity<SeasonTicketSegment> getSeasonTicketSegmentById(@PathVariable Integer id) {
        Optional<SeasonTicketSegment> optional= seaonTicketSegmentService.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
