/**
 * 
 */
package com.ibm.iotdemo.device;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.json.JSONObject;

/**
 * @author joypatra
 *
 */
public class ComboSimulationUtility implements SimulationUtilityInterface {

	protected AccelerationSimulationUtility accelUtil;
	protected MotionSimulationUtility motionUtil;
	protected CoordinatesSimulationUtility coordUtil;
	
   /*
    * This is also useful to understand how a single event data looks like when
    * retrieved from the demo server.
    */
    /*
     * The Payload_d class assumes a certain set of sensors for the device to keep it
     * simple to convert to the JSON payload.
     * In reality, this should contain a dynamic array of sensors and sensor data, that
     * will be dynamically converted to the JSON payload to be sent to the server.
     */
    private class Payload_d {
        public long timestampMillis = 1455909252026L;
        public float ACCELEROMETER_0 = -7.814f;
        public float ACCELEROMETER_1 = 1.992f;
        public float ACCELEROMETER_2 = 9.194f;
        public float PROXIMITY_0 = 1f;
        public float PROXIMITY_1 = 0f;
        public float PROXIMITY_2 = 0f;
        public float LIGHT_0 = 6f;
        public float LIGHT_1 = 0f;
        public float LIGHT_2 = 0f;
        public float MAGNETOMETER_0 = -1.812f;
        public float MAGNETOMETER_1 = 31.938f;
        public float MAGNETOMETER_2 = -22.812f;
        public float ORIENTATION_0 = 20.156f;
        public float ORIENTATION_1 = -9.359f;
        public float ORIENTATION_2 = -39.734f;
        public float AKM_Software_Virtual_Gyroscope_sensor__0 = 0.722f;
        public float AKM_Software_Virtual_Gyroscope_sensor__1 = 1.297f;
        public float AKM_Software_Virtual_Gyroscope_sensor__2 = -0.051f;
        public float AKM_Rotation_vector_sensor_0 = 0.009f;
        public float AKM_Rotation_vector_sensor_1 = 0.256f;
        public float AKM_Rotation_vector_sensor_2 = -0.187f;
        public float AKM_Rotation_vector_sensor_3 = 0f;
        public float AKM_Rotation_vector_sensor_4 = -1f;
        public float AKM_Gravity_sensor_0 = -4.794f;
        public float AKM_Gravity_sensor_1 = -0.763f;
        public float AKM_Gravity_sensor_2 = 8.526f;
        public float AKM_Linear_acceleration_sensor_0 = -3.024f;
        public float AKM_Linear_acceleration_sensor_1 = 2.751f;
        public float AKM_Linear_acceleration_sensor_2 = 0f;
        public float LOCATION_0 = 22.5656f;
        public float LOCATION_1 = 88.5757f;
        
        /* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return convertDataToJson().toString();
		}

		public JSONObject convertDataToJson() {
        		JSONObject jsonObj = new JSONObject();
        		
            Field[] fields = this.getClass().getDeclaredFields();
            
            Arrays.sort(fields, new Comparator<Field>() {
				@Override
				public int compare(Field o1, Field o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}
			});

            for(Field field: fields) {
                String fieldName = field.getName();

                if(fieldName.startsWith("this") || fieldName.startsWith("$") || fieldName.startsWith("serialVersion"))
                    continue;


            		try {
					jsonObj.put(fieldName, field.getFloat(this));
				} catch (IllegalArgumentException | IllegalAccessException | org.apache.commons.json.JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            return jsonObj;
        }
    }

   public static final String DUMMY_DEVICE_DATA = "{\n" +
           "               \"timestampMillis\":1455909252026,\n" +
           "               \"ACCELEROMETER_0\":-7.814,\n" +
           "               \"ACCELEROMETER_1\":1.992,\n" +
           "               \"ACCELEROMETER_2\":9.194,\n" +
           "               \"PROXIMITY_0\":1,\n" +
           "               \"PROXIMITY_1\":0,\n" +
           "               \"PROXIMITY_2\":0,\n" +
           "               \"LIGHT_0\":6,\n" +
           "               \"LIGHT_1\":0,\n" +
           "               \"LIGHT_2\":0,\n" +
           "               \"MAGNETOMETER_0\":-1.812,\n" +
           "               \"MAGNETOMETER_1\":31.938,\n" +
           "               \"MAGNETOMETER_2\":-22.812,\n" +
           "               \"ORIENTATION_0\":20.156,\n" +
           "               \"ORIENTATION_1\":-9.359,\n" +
           "               \"ORIENTATION_2\":-39.734,\n" +
           "               \"AKM Software Virtual Gyroscope sensor _0\":0.722,\n" +
           "               \"AKM Software Virtual Gyroscope sensor _1\":1.297,\n" +
           "               \"AKM Software Virtual Gyroscope sensor _2\":-0.051,\n" +
           "               \"AKM Rotation vector sensor_0\":0.009,\n" +
           "               \"AKM Rotation vector sensor_1\":0.256,\n" +
           "               \"AKM Rotation vector sensor_2\":-0.187,\n" +
           "               \"AKM Rotation vector sensor_3\":0,\n" +
           "               \"AKM Rotation vector sensor_4\":-1,\n" +
           "               \"AKM Gravity sensor_0\":-4.794,\n" +
           "               \"AKM Gravity sensor_1\":-0.763,\n" +
           "               \"AKM Gravity sensor_2\":8.526,\n" +
           "               \"AKM Linear acceleration sensor_0\":-3.024,\n" +
           "               \"AKM Linear acceleration sensor_1\":2.751,\n" +
           "               \"AKM Linear acceleration sensor_2\":0.667,\n" +
           "               \"LOCATION_0\":22.672,\n" +
           "               \"LOCATION_1\":88.442\n" +
           "}";

    Payload_d[] data = new Payload_d[] { new Payload_d() };
	JSONObject jsonData;
	
	public ComboSimulationUtility() {
		// TODO Auto-generated constructor stub
		accelUtil = new AccelerationSimulationUtility();
		coordUtil = new CoordinatesSimulationUtility(data[0].LOCATION_0, data[0].LOCATION_1);
		motionUtil = new MotionSimulationUtility();
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.iotdemo.device.SimulationUtilityInterface#getNextData()
	 */
	@Override
	public Object[] getNextData() {
		// TODO Auto-generated method stub
		data[0].timestampMillis = System.currentTimeMillis();
		
		Object[] accelData = accelUtil.getNextData();
		
		data[0].ACCELEROMETER_0 = (float) accelData[0];
		data[0].ACCELEROMETER_1 = (float) accelData[1];
		data[0].ACCELEROMETER_2 = (float) accelData[2];

		Object[] coordData = coordUtil.getNextData();
		
		data[0].LOCATION_0 = (float) coordData[0];
		data[0].LOCATION_1 = (float) coordData[1];
		
		Object[] motionData = motionUtil.getNextData();
		
		data[0].AKM_Linear_acceleration_sensor_0 = (float) motionData[0];
		data[0].AKM_Linear_acceleration_sensor_1 = (float) motionData[1];
		data[0].AKM_Linear_acceleration_sensor_2 = (float) motionData[2];
		
		return data;
	}

	private float toFloat(Object dataPoint) {
		return ((Double) dataPoint).floatValue();
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.iotdemo.device.SimulationUtilityInterface#convertDataToJason(java.lang.Object[])
	 */
	@Override
	public JSONObject convertDataToJson(Object[] obj) {
		// TODO Auto-generated method stub
		return ((Payload_d) obj[0]).convertDataToJson();
	}

	/* (non-Javadoc)
	 * @see com.ibm.iotdemo.device.SimulationUtilityInterface#reset()
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		accelUtil.reset();
		coordUtil.reset();
		motionUtil.reset();
	}

}
