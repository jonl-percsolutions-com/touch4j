/**************************************************************************
   ImageModel.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 **************************************************************************/
package com.emitrom.client;

import java.util.ArrayList;

import com.emitrom.platform.util.client.core.BaseModel;

public class ImageModel extends BaseModel {

	public ImageModel() {

	}

	public ImageModel(String name, String image, String cuteness) {
       setName(name);
       setImage(image);
       setCuteness(cuteness);
	}

	public void setName(String value) {
		set("name", value);
	}

	public void setImage(String value) {
		set("image", value);
	}

	public void setCuteness(String value) {
		set("cuteness", value);
	}
	
	
	public static ArrayList<ImageModel> getList(){
		ArrayList<ImageModel> models = new ArrayList<ImageModel>();
		models.add(new ImageModel("Ekambi Alain", "/images/kitten1.jpeg", "100"));
		models.add(new ImageModel("Ekambi Alain", "/images/kitten1.jpeg", "100"));
		return models;
	}
}
