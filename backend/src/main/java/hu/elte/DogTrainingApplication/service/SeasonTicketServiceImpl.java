package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.SeasonTicketService;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.repository.SeasonTicketRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: Bajári LÚCIA
 * @category Service
 * @version 0.0.1
 * Implementalja a SeasonTicketService interface-t
 */

@Log4j2
@Service
public class SeasonTicketServiceImpl implements SeasonTicketService {

    @Autowired
    private SeasonTicketRepository seasonTicketRepository;

    @Override
    public Iterable<SeasonTicket> findAll() {
        return seasonTicketRepository.findAll();
    }

    @Override
    public Optional<SeasonTicket> findById(Integer id) {
        return seasonTicketRepository.findById(id);
    }

    @Override
    public SeasonTicket save(SeasonTicket seasonTicket) {

        return seasonTicketRepository.save(seasonTicket);
    }

    @Override
    public void delete(Integer id) {
        seasonTicketRepository.deleteById(id);
    }
}