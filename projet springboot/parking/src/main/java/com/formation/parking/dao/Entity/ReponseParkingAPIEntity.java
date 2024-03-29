package com.formation.parking.dao.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReponseParkingAPIEntity {

	@JsonProperty(value = "records")
	private List<RecordEntity> records;

	public List<RecordEntity> getRecords() {
		return records;
	}

	public void setRecords(List<RecordEntity> records) {
		this.records = records;
	}
}
