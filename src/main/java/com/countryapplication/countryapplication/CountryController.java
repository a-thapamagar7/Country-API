package com.countryapplication.countryapplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CountryController {
    
    @Autowired
    private CountryService countryService;
    
    // the countries total method returns country names and total number of countries
    @GetMapping("/display")
    public String CountriesTotal() {
        return "Countries : " + countryService.findNames() + "\n Total : " + countryService.findNames().size();
    }
    // the search countries method returns the result matching the request param 
    @GetMapping("/search")
    public String searchCountries(@RequestParam("param") String firstLetter){
        return "Parameter : " + firstLetter + "\nCountries : " + countryService.searchCountry(firstLetter) 
        + "\nTotal Country : " + countryService.findNames().size() + "\nResult Count : " +
        (countryService.searchCountry(firstLetter)).size();
    }
    
}
