package com.amdocs.main;
import java.util.List;

import java.util.Scanner;

import com.amdocs.dao.PlantDAO;
import com.amdocs.dao.PlantDAOImpl;
import com.amdocs.pojos.Plant;
import com.amdocs.Exception.PlantNotFoundException;



public class PlantMenuDriven {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PlantDAO dao=new PlantDAOImpl(); 
		//PlantDAOImpl daoimpl=new PlantDAOImpl();//
		do {
			
			System.out.println("1. Add new plant\r\n"
					+ "2. Update plant cost\r\n"
					+ "3. Delete plant\r\n"
					+ "4. Show all plants\r\n"
					+ "5. Find plant by origin country name\r\n"
					+ "6. Find outdoor plants which requires sunlight\r\n"
					+ "7. Count plants by water supply frequency\r\n"
					+ "8. Exit\r\n"
					+ "");
			
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("To Add new plant");
				
				System.out.println("Enter Plant Id");
				 int plantId=sc.nextInt();
				 System.out.println("Enter plantName");
				 String plantName=sc.next();
				 System.out.println("Enter originCountryName");
				 String originCountryName=sc.next();
				 System.out.println("Enter sunlightRequired");
				 boolean sunlightRequired=sc.nextBoolean();
				 System.out.println("Enter waterSupplyFrequency: Daily || Alternate Days || weekly");
				 String waterSupplyFrequency=sc.next();
				 System.out.println("Enter plantType: Indoor || Outdoor");
				 String plantType=sc.next();
				 System.out.println("Planttype is: ");
				 System.out.println("Enter cost");
				 double cost=sc.nextDouble();
				 Plant plant=new Plant(plantId,plantName,originCountryName,sunlightRequired,waterSupplyFrequency,plantType,cost);
				 dao.addPlant(plant);
				 System.out.println(dao.getPlantList());
				 System.out.println("Plant Added Successfully");
				
				break;
				
			case 2:
				System.out.println("Update Plant cost");
				plantId=sc.nextInt();
				cost=sc.nextDouble();
				
				
				boolean flag=false;
				 
				 
				try {
					flag=dao.updatePlantCost(plantId, cost);
					
					if(!flag){
						throw new PlantNotFoundException("Plant not found");
					}else{
						System.out.println("Plant updated successfully");
					}
				} catch (PlantNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 3:
				System.out.println("Delete Plant Id");
				 plantId=sc.nextInt();
				 System.out.println(plantId);
				 
				 try{
					 int x=dao.deletePlant(plantId);
					 if(x==0){
						 throw new PlantNotFoundException("Plant not found");
					 }else{
						 System.out.println("Plant deleted successfully");
					 	}
					 } catch (PlantNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
				 }
				 
				 
				break;
				
			case 4:
				System.out.println("View all plants");
				dao.showAllPlants();
				
				break;
				
			case 5:
				System.out.println("Search By Origin Country Name");
				String countryName=sc.next();
				
				try{
					 List<Plant> y=dao.searchByOriginCountryName(countryName);
					 
					 if(y.size()==0){
						 throw new PlantNotFoundException("Origin Country Name not found");
					 }else{
						 System.out.println("Plant Origin Country Name exists");
					 	}
					 } catch (PlantNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
				 }
				break;	
			
				
			case 6:
				System.out.println("Outdoor plants which requires sunlight");
				try {
					List<Plant> z=dao.searchOutdoorPlantsWithSunlight();
					if(z.size()==0){
						throw new PlantNotFoundException("There are no outdoor plants that require sunlight");
					}else{
						System.out.println("There are outdoor plants that require sunlight");
						for(Plant plant1:z){
							System.out.println(plant1);
						}
					}
				} catch (PlantNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 7:
				System.out.println("Count plants by water supply frequency");
				String waterFrequency=sc.next();
				
				
				try {
					int a=dao.countPlantsByWaterSupplyFrequency(waterFrequency);
					if(a==0){
						throw new PlantNotFoundException("Plants without Water Supply Frequency");
					}else{
						System.out.println("Plants with Water Supply Frequency");
					}
				} catch (PlantNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 8:
				System.out.println("Exit");
				System.exit(0);
				break;
			}
			
		}
		while(true);

	}

}
