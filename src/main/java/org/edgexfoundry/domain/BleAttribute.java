/*******************************************************************************
 * Copyright 2016-2017 Dell Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @microservice: device-bluetooth
 * @author: Tyler Cox, Dell
 * @version: 1.0.0
 *******************************************************************************/

package org.edgexfoundry.domain;

import com.google.gson.Gson;
import org.edgexfoundry.support.logging.client.EdgeXLogger;
import org.edgexfoundry.support.logging.client.EdgeXLoggerFactory;

public class BleAttribute {
	
	private final static EdgeXLogger logger = EdgeXLoggerFactory.getEdgeXLogger(BleAttribute.class);
	
	// Replace these attributes with the BLE
	// specific metadata needed by the BLE Driver
	
	private String uuid;
	
	public BleAttribute(Object attributes) {
		try {
			Gson gson = new Gson();
			String jsonString = gson.toJson(attributes);
			BleAttribute thisObject = gson.fromJson(jsonString, this.getClass());
			
			this.setUuid(thisObject.getUuid());
			
		} catch (Exception e) {
			logger.error("Cannot Construct BleAttribute: " + e.getMessage());
		}
	}
	
	
	public String getUuid()
	{
		return uuid;
	}
	
	
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
}
