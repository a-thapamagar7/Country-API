package com.countryapplication.countryapplication;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryService {

    @Autowired
    private RestTemplate template = new RestTemplate();

    // method for listing the names of the country and the total number
    public ArrayList<String> findNames() {
        // arraylist to store the country names
        ArrayList<String> countrynames = new ArrayList<String>();
        // consuming the rest api of countries using rest template in countries class
        Countries[] forObject = template.getForObject("https://restcountries.com/v2/all", Countries[].class);
        // arraylist to store the objects of countries class
        List<Countries> countrylist = Arrays.asList(forObject);
        // iteraing in the countrylist array
        for (Countries country : countrylist) {
            // using getName method of countries class
            String name = country.getName();
            // checking if the country name is in the list
            if (!countrynames.contains(name)) {
                countrynames.add(name);
            }
        }
        return countrynames;
    }
    // method for searching name of the nations with inital letter
    public ArrayList<String> searchCountry(String firstLetter) {
        // arraylist to store the search results
        ArrayList<String> searchResult = new ArrayList<String>();
        // arraylist to store all the countries name
        ArrayList<String> allCountries = findNames();
        // iterating in the allCountries array
        for (String result : allCountries) {
            //checking if country name starts user input
            if ((result.toLowerCase()).startsWith(firstLetter.toLowerCase())) {
                searchResult.add(result);
            }
        }
        return searchResult;
    }
}
