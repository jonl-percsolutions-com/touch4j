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
