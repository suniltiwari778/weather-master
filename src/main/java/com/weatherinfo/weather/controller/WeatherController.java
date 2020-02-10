package com.weatherinfo.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.weatherinfo.weather.dao.WeatherDAO;
import com.weatherinfo.weather.entity.CityWeather;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class WeatherController {
	
	@Autowired
    private WeatherDAO weatherDAO;
	
	@GetMapping("/api/weather/city-name")
	@ResponseBody
	public CityWeather getCityWeatherByName(@RequestParam String cityName){
		
		return weatherDAO.findByCityName(cityName);
		
	}
	
	@GetMapping("/api/weather/all-city")
	@ResponseBody
	public List<CityWeather> getCityWeather(){
		
		return (List<CityWeather>) weatherDAO.findAll();
		
	}

}
