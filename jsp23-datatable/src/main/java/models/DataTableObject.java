package models;

import java.util.ArrayList;
import java.util.List;

public class DataTableObject {
	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private List<List<String>> data;
	
	public DataTableObject() {
		data = new ArrayList<List<String>>();
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<List<String>> getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Data [draw=" + draw + ", recordsTotal=" + recordsTotal + ", recordsFiltered=" + recordsFiltered
				+ ", data=" + data + "]";
	}	
	
}
