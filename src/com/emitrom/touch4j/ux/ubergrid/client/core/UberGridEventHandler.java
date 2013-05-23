package com.emitrom.touch4j.ux.ubergrid.client.core;

import com.emitrom.touch4j.ux.ubergrid.client.data.UberGridModel;

public interface UberGridEventHandler {
    public void onEvent(UberGridModel record, int rownIndex, int cellIndex);
}
