package hu.elte.DogTrainingApplication.service;

import hu.elte.DogTrainingApplication.api.SeasonTicketSegmentService;
import hu.elte.DogTrainingApplication.entities.SeasonTicketSegment;
import hu.elte.DogTrainingApplication.repository.SeasonTicketSegmentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: Bajári LÚCIA
 * @category Service
 * @version 0.0.1
 * ImplementĂˇlja a SeasonTicketSegmentService interface-t
 */

@Service
@Log4j2
public class SeasonTicketSegmentServiceImpl implements SeasonTicketSegmentService {


    @Autowired
    private SeasonTicketSegmentRepository seasonTicketSegmentRepository;


    @Override
    public Iterable<SeasonTicketSegment> findAll() {
        return seasonTicketSegmentRepository.findAll();
    }

    @Override
    public Optional<SeasonTicketSegment> findById(Integer id) {
        return seasonTicketSegmentRepository.findById(id);
    }

    @Override
    public void save(SeasonTicketSegment seasonTicketSegment) {
        seasonTicketSegmentRepository.save(seasonTicketSegment);
    }
}
