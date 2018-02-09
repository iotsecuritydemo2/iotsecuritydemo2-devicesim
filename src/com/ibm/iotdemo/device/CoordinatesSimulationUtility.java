package com.ibm.iotdemo.device;

import org.apache.commons.json.JSONObject;

public class CoordinatesSimulationUtility implements SimulationUtilityInterface {

	protected float 	latitudeInitial;
	protected float	longitudeInitial;
	
	protected float	latitude;
	protected float	longitude;
	
	public CoordinatesSimulationUtility(float latitudeInitial, float longitudeInitial) {
		this.latitudeInitial = latitudeInitial;
		this.longitudeInitial = longitudeInitial;
		
		latitude = latitudeInitial;
		longitude = longitudeInitial;
	}
	
	@Override
	public Object[] getNextData() {

		latitude = latitude + (float) (Math.random() - 0.5f)/1000;
		
		if(latitude > 90) latitude = 90;
		if(latitude < -90) latitude = -90; 
		
		longitude = longitude + (float) (Math.random() - 0.2f)/1000;

		if(longitude > 180) longitude = 180;
		if(longitude < -180) longitude = -180; 

        return new Object[] { latitude, longitude };
	}

	@Override
	public JSONObject convertDataToJson(Object[] obj) {
		JSONObject jsonTop = new JSONObject();
		JSONObject jsonObj = new JSONObject();
		try{
			jsonObj.put("latitude", obj[0]);
			jsonObj.put("longitude", obj[1]);
			jsonTop.put("coordinates", jsonObj);
			jsonTop.put("event", "data");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonTop;
    }
	
	@Override
	public void reset() {
		latitude = latitudeInitial;
		longitude = longitudeInitial;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

}
