package com.amdocs.dao;

import java.util.ArrayList;

import java.util.List;
import com.amdocs.pojos.Plant;
import com.amdocs.Exception.PlantNotFoundException;


public class PlantDAOImpl implements PlantDAO{
	
	
	
	List<Plant> plantList=new ArrayList<>();

	@Override
	public int addPlant(Plant plant) {
		plantList.add(plant);
		System.out.println(plantList);
		// TODO Auto-generated method stub
		return plant.getPlantId();
	}

	@Override
	public int deletePlant(int plantId) throws PlantNotFoundException {
		for(Plant i:plantList){
			if(i.getPlantId()==plantId){
				plantList.remove(i);
				return 1;
			}
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updatePlantCost(int plantId, double cost) throws PlantNotFoundException { //receive//
		for(Plant i: plantList){
		if(i.getPlantId()==plantId){
			i.setCost(cost);
			return true;
		}
		
		// TODO Auto-generated method stub
		}
		return false;
	}
		

	@Override
	public List<Plant> showAllPlants() {
		
		for(int i=0;i<plantList.size();i++){
			Plant a=plantList.get(i);
			
			System.out.println(a.toString());
		}
		// TODO Auto-generated method stub
		return plantList;
	}

	@Override
	public List<Plant> searchByOriginCountryName(String originCountryName) throws PlantNotFoundException {
		List<Plant> x=new ArrayList<Plant>();
		
		for(Plant i: plantList){
			if(i.getOriginCountyName().equals(originCountryName)){
				x.add(i);
			}
			
		}
		
		// TODO Auto-generated method stub
		return x;
	}

	public List<Plant> searchOutdoorPlantsWithSunlight() throws PlantNotFoundException {
		List<Plant> x=new ArrayList<Plant>();
		
		
		for(Plant i: plantList){
			if(i.isSunlightRequired()==true && i.getPlantType().equalsIgnoreCase("Outdoor")){
				x.add(i);
				
			}
		}
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int countPlantsByWaterSupplyFrequency(String waterSupplyFrequency) throws PlantNotFoundException {
		
		int x=0;
		for(Plant i: plantList){
			if(i.getWaterSupplyFrequency().equals(waterSupplyFrequency)){
				x=x+1;
			}
		}
		// TODO Auto-generated method stub
		return x;
	}
	
	@Override
	public List<Plant> getPlantList() {
		return this.plantList;
	}
	

}