/**
 Copyright (c) 2013 Emitrom LLC. All rights reserved.
 For licensing questions, please contact us at licensing@emitrom.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.emitrom.touch4j.client.core;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.core.java.util.Map_CustomFieldSerializerBase;

public class FastMap_CustomFieldSerializer {

	@SuppressWarnings("rawtypes")
	public static void deserialize(SerializationStreamReader streamReader,
			FastMap instance) throws SerializationException {
		Map_CustomFieldSerializerBase.deserialize(streamReader, instance);
	}

	@SuppressWarnings("rawtypes")
	public static void serialize(SerializationStreamWriter streamWriter,
			FastMap instance) throws SerializationException {
		Map_CustomFieldSerializerBase.serialize(streamWriter, instance);
	}
}
