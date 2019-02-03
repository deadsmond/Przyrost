package core;

import core.address.Address;
import core.address.AddressRepository;
import core.citizens.Citizen;
import core.citizens.CitizenRepository;

import core.estate.Estate;
import core.estate.EstateRepository;
import core.firm.*;
import core.partners.Partners;
import core.partners.PartnersRepository;
import core.workers.Workers;
import core.workers.WorkersRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j

public class Payload {
    @Bean
    CommandLineRunner initTableCitizens(CitizenRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Citizen("12345678910", "Karl", "Stefanovitsch", "01-01-1900", "M")));
            log.info("Preloading " + repository.save(new Citizen("12345678911", "Mark", "Tarasov", "31-06-1951", "M")));
        };
    }
    @Bean
    CommandLineRunner initTableAddress(AddressRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Address("Poznan", "Marcinkowskiego", "18", "2")));
            log.info("Preloading " + repository.save(new Address("Berlin", "Unter den Linden", "4", "11")));
        };
    }
    @Bean
    CommandLineRunner initTableEstate(EstateRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Estate("12345678910", 1)));
            log.info("Preloading " + repository.save(new Estate("12345678911", 2)));
        };
    }
    @Bean
    CommandLineRunner initTableFirm(FirmRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Firm("123aa", "TEch", 1)));
            log.info("Preloading " + repository.save(new Firm("444bb", "Ello", 2)));
        };
    }
    @Bean
    CommandLineRunner initTablePartners(PartnersRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Partners("12345678910", "12345678911")));
            log.info("Preloading " + repository.save(new Partners("12345678911", "12345678910")));
        };
    }
    @Bean
    CommandLineRunner initTableWorkers (WorkersRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Workers("12345678910", "123aa")));
            log.info("Preloading " + repository.save(new Workers("12345678911", "444bb")));
        };
    }
}
