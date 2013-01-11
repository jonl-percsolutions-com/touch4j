/**************************************************************************
   Company.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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
import com.google.gwt.core.client.JavaScriptObject;

public class Company extends BaseModel {

    public Company() {
    }

    public Company(JavaScriptObject obj) {
        super(obj);
    }

    public Company(String name, String price) {
        setName(name);
        setPrice(price);
    }

    public Company(String name, String price, String change, String pct, String updated) {
        setName(name);
        setPrice(price);
        setChange(change);
        setPct(pct);
        setUpdated(updated);
    }

    public void setName(String name) {
        set("name", name);
    }

    public void setChange(String name) {
        set("change", name);
    }

    public String getName() {
        return "Company : " + this.get("name");
    }

    public void setPct(String name) {
        set("pct", name);
    }

    public void setUpdated(String name) {
        set("updated", name);
    }

    public void setPrice(String price) {
        set("price", price);
    }

    public static ArrayList<Company> getList() {
        ArrayList<Company> list = new ArrayList<Company>();
        list.add(new Company("3m Co", "71.72", "0.02", "0.03", "9/1/2010"));
        list.add(new Company("Alcoa Inc", "29.01", "0.42", "1.47", "9/1/2010"));
        list.add(new Company("Altria Group Inc", "83.81", "0.28", "0.34", "9/1/2010"));
        list.add(new Company("American Express Company", "52.55", "0.01", "0.02", "9/1/2010"));
        list.add(new Company("American International Group, Inc.", "64.13", "0.31", "0.49", "9/1/2010"));
        list.add(new Company("AT&#38;T Inc.", "31.61", "-0.48", "-1.54", "9/1/2010"));
        list.add(new Company("Boeing Co.", "75.43", "0.53", "0.71", "9/1/2010"));
        list.add(new Company("Caterpillar Inc.", "67.27", "0.92", "1.39", "9/1/2010"));
        list.add(new Company("Citigroup, Inc.", "49.37", "0.02", "0.04", "9/1/2010"));
        list.add(new Company("E.I. du Pont de Nemours and Company", "40.48", "0.51", "1.28", "9/1/2010"));
        list.add(new Company("Exxon Mobil Corp", "68.1", "-0.43", "-0.64", "9/1/2010"));
        return list;
    }

    public static Company from(BaseModel model) {
        return new Company(model.getJsObj());
    }

}
