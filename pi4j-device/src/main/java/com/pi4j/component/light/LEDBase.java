package com.pi4j.component.light;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Device Abstractions
 * FILENAME      :  LEDBase.java  
 * 
 * This file is part of the Pi4J project. More information about 
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2013 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.component.ComponentListener;
import com.pi4j.component.ObserveableComponentBase;

public abstract class LEDBase extends ObserveableComponentBase implements LED {
    
    @Override
    public abstract void on();

    @Override
    public abstract void off();

    @Override
    public abstract boolean isOn();

    @Override
    public boolean isOff() {
        return (!isOn());
    }
    
    @Override
    public void toggle(){
        if(isOn())
            off();
        else
            on();
    }
     
    @Override
    public void addListener(LightListener... listener) {
        super.addListener(listener);
    }

    @Override
    public synchronized void removeListener(LightListener... listener) {
        super.removeListener(listener);
    }

    protected synchronized void notifyListeners(LightStateChangeEvent event) {
        for(ComponentListener listener : super.listeners) {
            ((LightListener)listener).onStateChange(event);
        }
    }     
}