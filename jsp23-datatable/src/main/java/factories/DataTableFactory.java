package factories;

import java.util.ArrayList;

import models.DataTableObject;

public abstract class DataTableFactory {
	@SuppressWarnings("serial")
	public static DataTableObject createDataTableObject() {
		DataTableObject dataTableObject = new DataTableObject();
		
		dataTableObject.getData().add(new ArrayList<String>() {{add("Sylvaro"); add("Latrial"); add("11112222"); add("sylvaro@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Nemesys"); add("Jozeiros"); add("22223333"); add("nemesys@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Sebethera"); add("Cairis"); add("33334444"); add("sebethera@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Timitrion"); add("Darri"); add("44445555"); add("timitrion@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Natifer"); add("Matnu"); add("55556666"); add("natifer@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Rymona"); add("Crale"); add("66667777"); add("rymona@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Demetrio"); add("Adyarus"); add("77778888"); add("demetrio@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Dromeda"); add("Yindan"); add("88889999"); add("dromeda@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Bershan"); add("Yladi"); add("99990000"); add("bershan@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Akra"); add("Vaer"); add("00009999"); add("akra@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Rhenibelle"); add("Dithas"); add("99998888"); add("rhenibelle@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Sorina"); add("Saadin"); add("88887777"); add("sorina@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Aslaois"); add("Druddeon"); add("77776666"); add("aslaois@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Vania"); add("Quimmer"); add("66665555"); add("vania@email.com");}});
		dataTableObject.getData().add(new ArrayList<String>() {{add("Callister"); add("Tayne"); add("55554444"); add("callister@email.com");}});
		
		dataTableObject.setDraw(1);
		dataTableObject.setRecordsTotal(dataTableObject.getData().size());
		dataTableObject.setRecordsFiltered(dataTableObject.getData().size());
		
		return dataTableObject;
	}

}
