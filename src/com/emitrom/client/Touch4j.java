/**************************************************************************
   Touch4j.java is part of Touch4j 3.0.  Copyright 2012 Emitrom LLC

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

import com.emitrom.gwt4.touch.client.core.EventObject;
import com.emitrom.gwt4.touch.client.core.TouchEntryPoint;
import com.emitrom.gwt4.touch.client.core.config.Dock;
import com.emitrom.gwt4.touch.client.core.handlers.button.TapHandler;
import com.emitrom.gwt4.touch.client.data.Store;
import com.emitrom.gwt4.touch.client.ui.Button;
import com.emitrom.gwt4.touch.client.ui.CheckBox;
import com.emitrom.gwt4.touch.client.ui.DatePickerField;
import com.emitrom.gwt4.touch.client.ui.Email;
import com.emitrom.gwt4.touch.client.ui.FieldSet;
import com.emitrom.gwt4.touch.client.ui.FormPanel;
import com.emitrom.gwt4.touch.client.ui.NumberField;
import com.emitrom.gwt4.touch.client.ui.Password;
import com.emitrom.gwt4.touch.client.ui.Select;
import com.emitrom.gwt4.touch.client.ui.SelectOption;
import com.emitrom.gwt4.touch.client.ui.Slider;
import com.emitrom.gwt4.touch.client.ui.Spinner;
import com.emitrom.gwt4.touch.client.ui.Text;
import com.emitrom.gwt4.touch.client.ui.TextArea;
import com.emitrom.gwt4.touch.client.ui.Toggle;
import com.emitrom.gwt4.touch.client.ui.ToolBar;
import com.emitrom.gwt4.touch.client.ui.Url;
import com.emitrom.gwt4.touch.client.ui.ViewPort;
import com.emitrom.gwt4.touch.ux.rating.client.Rating;
import com.emitrom.platform.util.client.core.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

public class Touch4j extends TouchEntryPoint {

	public interface Driver extends SimpleBeanEditorDriver<Person, PersonEditor> {
	}

	private static Driver driver = GWT.create(Driver.class);
	PersonEditor editor;
	private static Person person;

	@Override
	public void onLoad() {

		editor = new PersonEditor();
		driver.initialize(editor);

		person = new Person();
		person.setName("Emitrom");
		person.setCool(true);
		person.setActive(1);
		person.setAge(2);
		person.setWallet(10);
		person.setRating(4);
		person.setSpinner(5);
		person.setBirthday(JsDate.create(2011, 8, 22));

		/**
		 * Push domain data to the UI.
		 */
		driver.edit(person);

		ViewPort vp = ViewPort.get();
		vp.add(editor);

		RootPanel.get().add(vp);

	}

	public static class Person {

		private String name;
		private String password;
		private boolean cool;
		private int active;
		private int age;
		private String email;
		private String search;
		private String biography;
		private String website;
		private String select;
		private JsDate birthday;
		private double wallet;
		private double spinner;
		private int rating;

		public Person() {
		}

		public boolean isCool() {
			return cool;
		}

		public void setCool(boolean cool) {
			this.cool = cool;
		}

		public int getActive() {
			return active;
		}

		public void setActive(int active) {
			this.active = active;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}

		public String getBiography() {
			return biography;
		}

		public void setBiography(String biography) {
			this.biography = biography;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public String getSelect() {
			return select;
		}

		public void setSelect(String select) {
			this.select = select;
		}

		public JsDate getBirthday() {
			return birthday;
		}

		public void setBirthday(JsDate birthday) {
			this.birthday = birthday;
		}

		public double getWallet() {
			return wallet;
		}

		public void setWallet(double wallet) {
			this.wallet = wallet;
		}

		public double getSpinner() {
			return spinner;
		}

		public void setSpinner(double spinner) {
			this.spinner = spinner;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}
		
	}

	public static class PersonEditor extends Composite implements Editor<Person> {

		private FormPanel formPanel = new FormPanel();
		private ToolBar toolbar;
		private Button saveButton;

		Text<String> name;
		Password password;
		CheckBox cool;
		Toggle active;
		Slider age;
		Email email;
		TextArea biography;
		Url website;
		Select<String> select;
		DatePickerField birthday;
		NumberField<Double> wallet;
		Spinner<Double> spinner;
		Rating rating;

		public PersonEditor() {
			initWidget(formPanel);
			init();
			addHandlers();
		}

		private void init() {

			FieldSet fieldset = new FieldSet();
			
			name = new Text<String>();
			name.setLabel("Name");
			
			password = new Password();
			password.setLabel("Password");
			
			cool = new CheckBox();
			cool.setLabel("Cool");

			active = new Toggle();
			active.setLabel("Active");

			age = new Slider();
			age.setLabel("Age");
			age.setMaxValue(100);
			
			email = new Email();
			email.setLabel("Email");
			
			biography = new TextArea();
			biography.setLabel("Biography");

			website = new Url();
			website.setLabel("Website");
			
	        select = new Select<String>();
	        select.setOptions(RankModel.getOptions());
	        select.setName("rank");
	        select.setLabel("Rank");
	        
	        birthday = new DatePickerField();
	        birthday.setLabel("Birthday");
	        
	        wallet = new NumberField<Double>();
	        wallet.setLabel("Wallet");
	        
	        spinner = new Spinner<Double>();
	        spinner.setLabel("Spinner");
	        
	        rating = new Rating();
	        rating.setLabel("Rating");
			
	        fieldset.add(rating);
			fieldset.add(name);
			fieldset.add(password);
			fieldset.add(cool);
			fieldset.add(active);
			fieldset.add(age);
			fieldset.add(email);
			fieldset.add(biography);
			fieldset.add(website);
			fieldset.add(select);
			fieldset.add(birthday);
			fieldset.add(wallet);
			fieldset.add(spinner);
			
			formPanel.add(fieldset);

			toolbar = new ToolBar(Dock.TOP);
			saveButton = new Button("Save");
			toolbar.add(saveButton);

			formPanel.add(toolbar);

		}

		private void addHandlers() {

			/**
			 * Testing Data Binding.
			 */
			saveButton.addTapHandler(new TapHandler() {
				@Override
				public void onTap(Button button, EventObject event) {
					/**
					 * Push UI data to the Domain object.
					 */
					driver.flush();
					System.out.println("Name: " + person.getName());
					System.out.println("Password: " + person.getPassword());
					System.out.println("Is cool?: " + person.isCool());
					System.out.println("Active: " + person.getActive());					
					System.out.println("Age: " + person.getAge());
					System.out.println("Email: " + person.getEmail());
					System.out.println("Biography: " + person.getBiography());
					System.out.println("Website: " + person.getWebsite());
					System.out.println("Select: " + person.getSelect());
					System.out.println("Birthday: " + person.getBirthday().getFullYear());
					System.out.println("Wallet: " + person.getWallet() == null ? "Nothing" : person.getWallet());
					System.out.println("Spinner: " + person.getSpinner());
					System.out.println("Rating:" + person.getRating());
				}
			});
			
		}

	}
	
	public static class RankModel extends BaseModel {

	    public static final String TITLE = "title";
	    public static final String RANK = "rank";

	    public RankModel() {
	        setTitle("");
	        setRank("");
	    }

	    private void setRank(String string) {
	        set(RANK, string);
	    }

	    public RankModel(String rank) {
	        setTitle(rank);
	    }

	    public RankModel(String title, String rank) {
	        setTitle(title);
	        setRank(rank);
	    }

	    private void setTitle(String rank) {
	        set(TITLE, rank);
	    }

	    public static ArrayList<RankModel> createRanks() {
	        ArrayList<RankModel> ranks = new ArrayList<RankModel>();
	        ranks.add(new RankModel("Master", "master"));
	        ranks.add(new RankModel("Student", "padawan"));
	        ranks.add(new RankModel("Instructor", "teacher"));
	        ranks.add(new RankModel("Assistant", "aid"));
	        return ranks;
	    }

	    public static ArrayList<SelectOption> getOptions() {
	        ArrayList<SelectOption> ranks = new ArrayList<SelectOption>();
	        ranks.add(new SelectOption("Master", "master"));
	        ranks.add(new SelectOption("Student", "padawan"));
	        ranks.add(new SelectOption("Instructor", "teacher"));
	        ranks.add(new SelectOption("Assistant", "aid"));
	        return ranks;
	    }

	    public static Store getStore() {
	        return new Store(createRanks());
	    }

	}

}