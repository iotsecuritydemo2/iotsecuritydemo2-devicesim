package com.ibm.iotdemo.device;

import org.apache.commons.json.JSONObject;

public interface SimulationUtilityInterface {
	public Object[] getNextData();
	public JSONObject convertDataToJson(Object[] obj);
	public void reset();
}
