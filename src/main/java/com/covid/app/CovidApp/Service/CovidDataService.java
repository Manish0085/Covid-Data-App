package com.covid.app.CovidApp.Service;


import com.covid.app.CovidApp.Utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class CovidDataService {


    Scanner sc = new Scanner(System.in);
    @Autowired
    RestTemplate restTemplate;

    public Integer getCovidData(String cityName){

        Map<String, String > stateCity = new HashMap();

        stateCity.put("Agra", "Uttar Pradesh");
        stateCity.put("Hapur", "Uttar Pradesh");
        stateCity.put("Bulandshahar", "Uttar Pradesh");
        stateCity.put("Meerut", "Uttar Pradesh");




        Map<String, Object> map = restTemplate.getForObject(Util.COVID_API_URL, Map.class);
        Map<String, Object> cityObjMap = (Map<String, Object>) map.get(stateCity.get(cityName));
        Map<String, Object> districtData = (Map<String, Object>) cityObjMap.get("districtData");
        Map<String, Object> city = (Map<String, Object>) districtData.get(cityName);
        Integer active = (Integer) city.get("active");
        return active;
    }

}
