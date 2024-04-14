package com.covid.app.CovidApp.Controller;


import com.covid.app.CovidApp.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CovidData")
public class CovidController {
    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/citywise/{city}")
    public String  getCovidCases(@PathVariable String city){
        Integer covidData = covidDataService.getCovidData(city);

        return "Covid active cases in "+city+" are "+covidData;
    }
}
