package com.travel.travel.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travel.Domain.Journey;
import com.travel.travel.Repository.JourneyRepository;

@Service
public class JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    public Journey createJourney(Journey journey) {
        return journeyRepository.save(journey);
    }

    public List<Journey> getAllJourneys() {
        return journeyRepository.findAll();
    }

    public Journey getJourneyById(Long journeyID) {
        return journeyRepository.findById(journeyID).orElse(null);
    }

    public Journey updateJourney(Long journeyID, Journey journey) {
        journey.setJourneyID(journeyID);
        return journeyRepository.save(journey);
    }

    public void deleteJourney(Long journeyID) {
        journeyRepository.deleteById(journeyID);
    }
}
