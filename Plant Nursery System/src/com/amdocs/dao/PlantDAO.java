package com.amdocs.dao;
import java.util.List;

import com.amdocs.pojos.Plant;
import com.amdocs.Exception.PlantNotFoundException;


 public interface PlantDAO {
	
	public int addPlant(Plant plant);

	public int deletePlant(int plantId) throws PlantNotFoundException;

	public boolean updatePlantCost(int plantId, double cost) throws PlantNotFoundException;

	public List<Plant> showAllPlants();

	public List<Plant> searchByOriginCountryName(String originCountryName) throws PlantNotFoundException;

	public List<Plant> searchOutdoorPlantsWithSunlight()throws PlantNotFoundException;

	public int countPlantsByWaterSupplyFrequency(String waterSupplyFrequency)throws PlantNotFoundException;
	
	public List<Plant> getPlantList();

} 