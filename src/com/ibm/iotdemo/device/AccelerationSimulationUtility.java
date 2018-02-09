package com.ibm.iotdemo.device;

import org.apache.commons.json.JSONObject;

public class AccelerationSimulationUtility implements SimulationUtilityInterface {

	protected float	ax;
	protected float	ay;
	protected float	az;
	
	@Override
	public Object[] getNextData() {
		
        ax = (float) Math.random() * 5.0f - 2.5f;
        ay = (float) Math.random() * 5.0f - 2.5f;
        az = (float) Math.random() * 5.0f - 2.5f;
        
        return new Object[] { ax, ay, az };
    }
    
	@Override
	public JSONObject convertDataToJson(Object[] obj) {
		JSONObject jsonTop = new JSONObject();
		JSONObject jsonObj = new JSONObject();
		try{
			jsonObj.put("ax", obj[0]);
			jsonObj.put("ay", obj[1]);
			jsonObj.put("az", obj[2]);
			jsonTop.put("acceleration", jsonObj);
			jsonTop.put("event", "data");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonTop;
    }	
	
	@Override
	public void reset() {
        ax = 0;
        ay = 0;
        az = 0;
	}

	public float getAx() {
		return ax;
	}

	public float getAy() {
		return ay;
	}

	public float getAz() {
		return az;
	}

}

