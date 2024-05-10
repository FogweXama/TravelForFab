package com.travel.travel.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travel.travel.Domain.Journey;
import com.travel.travel.Service.JourneyService;

import java.util.List;

@RestController
@RequestMapping("/api/journeys")
public class JourneyResource {
    @Autowired
    private JourneyService journeyService;

    @PostMapping
    public Journey createJourney(@RequestBody Journey journey) {
        return journeyService.createJourney(journey);
    }

    @GetMapping
    public List<Journey> getAllJourneys() {
        return journeyService.getAllJourneys();
    }

    @GetMapping("/{id}")
    public Journey getJourneyById(@PathVariable Long id) {
        return journeyService.getJourneyById(id);
    }

    @PutMapping("/{id}")
    public Journey updateJourney(@PathVariable Long id, @RequestBody Journey journey) {
        return journeyService.updateJourney(id, journey);
    }

    @DeleteMapping("/{id}")
    public void deleteJourney(@PathVariable Long id) {
        journeyService.deleteJourney(id);
    }
}
