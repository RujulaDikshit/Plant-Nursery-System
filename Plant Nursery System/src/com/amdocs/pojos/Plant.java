package com.amdocs.pojos;


public class Plant {

	private int plantId;
	private String plantName;
	private double cost;
	private String originCountyName;
	private boolean sunlightRequired;
	private String waterSupplyFrequency;
	private String plantType;
	
	public Plant(int plantId,String plantName,String originCountyName,boolean sunlightRequired,
			String waterSupplyFrequency,String plantType,double cost){
		
		this.plantId=plantId;
		this.plantName=plantName;
		this.originCountyName=originCountyName;
		this.sunlightRequired=sunlightRequired;
		this.waterSupplyFrequency=waterSupplyFrequency;
		this.plantType=plantType;
		this.cost=cost;
		
	}

	

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}
	

	public String getOriginCountyName() {
		return originCountyName;
	}

	public void setOriginCountyName(String originCountyName) {
		this.originCountyName = originCountyName;
	}

	public boolean isSunlightRequired() {
		return sunlightRequired;
	}

	public void setSunlightRequired(boolean sunlightRequired) {
		this.sunlightRequired = sunlightRequired;
	}

	public String getWaterSupplyFrequency() {
		return waterSupplyFrequency;
	}

	public void setWaterSupplyFrequency(String waterSupplyFrequency) {
		this.waterSupplyFrequency = waterSupplyFrequency;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}
	
	

	public String getPlantName() {
		return plantName;
	}


	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}



	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", cost=" + cost + "]";
	}
	

}
