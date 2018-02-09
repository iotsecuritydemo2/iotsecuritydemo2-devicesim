package com.ibm.iotdemo.device;

import org.apache.commons.json.JSONObject;

public class MotionSimulationUtility implements SimulationUtilityInterface {

	protected float	oa;
	protected float	ob;
	protected float	og;
	
	@Override
	public Object[] getNextData() {

        oa = oa + (float) Math.random() * 10f - 5;
        ob = ob + (float) Math.random() * 10f - 5;
        og = og + (float) Math.random() * 10f - 5;

		if(oa > 500) oa = 500; if(oa < -500) oa = -500;
		if(ob > 500) ob = 500; if(ob < -500) ob = -500;
		if(og > 500) og = 500; if(og < -500) og = -500;

		return new Object[] { oa, ob, og };
    }
	
	@Override
	public JSONObject convertDataToJson(Object[] obj) {
		JSONObject jsonTop = new JSONObject();
		JSONObject jsonObj = new JSONObject();
		try{
			jsonObj.put("oa", obj[0]);
			jsonObj.put("ob", obj[1]);
			jsonObj.put("og", obj[2]);
			jsonTop.put("motion", jsonObj);
			jsonTop.put("event", "data");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonTop;
    }

	@Override
	public void reset() {
        oa = 0;
        ob = 0;
        og = 0;
	}

	public float getOa() {
		return oa;
	}

	public float getOb() {
		return ob;
	}

	public float getOg() {
		return og;
	}

}
