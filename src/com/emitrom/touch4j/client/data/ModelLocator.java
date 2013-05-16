package com.emitrom.touch4j.client.data;

/**
 * creates BaseModel object out of Java Beans
 */
public class ModelLocator {

	private ModelLocator() {

	}

	public static BeanModelFactory locate(Class<?> bean) {
		return BeanModelLookup.get().getFactory(bean);
	}
}
