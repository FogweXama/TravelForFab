package com.travel.travel.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.travel.Domain.CustomerJourney;
import com.travel.travel.Repository.CustomerJourneyRepository;


@Service
public class CustomerJourneyService {

    @Autowired
    private CustomerJourneyRepository customerJourneyRepository;

    public CustomerJourney createCustomerJourney(CustomerJourney customerJourney) {
        return customerJourneyRepository.save(customerJourney);
    }

    public List<CustomerJourney> getAllCustomerJourneys() {
        return customerJourneyRepository.findAll();
    }

    public CustomerJourney getCustomerJourneyById(Long customerJourneyID) {
        return customerJourneyRepository.findById(customerJourneyID).orElse(null);
    }

    public CustomerJourney updateCustomerJourney(Long customerJourneyID, CustomerJourney customerJourney) {
        customerJourney.setTicketID(customerJourneyID);
        return customerJourneyRepository.save(customerJourney);
    }

    public void deleteCustomerJourney(Long customerJourneyID) {
        customerJourneyRepository.deleteById(customerJourneyID);
    }
}
