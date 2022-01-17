package com.formation.parking.Services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.parking.Models.Parking;
import com.formation.parking.Services.ParkingService;
import com.formation.parking.dao.ParkingAPIDAO;
import com.formation.parking.dao.Entity.RecordEntity;
import com.formation.parking.dao.Entity.ReponseParkingAPIEntity;

@Service
public class ParkingServicesImpl implements ParkingService {
	@Autowired
	public ParkingAPIDAO parkingAPIDAO;

	@Override
	public List<Parking> getListeParkings() {
		ReponseParkingAPIEntity reponse = parkingAPIDAO.getListeParkings();
		return transformEntityToModel(reponse);
	
	}

	private List<Parking> transformEntityToModel(ReponseParkingAPIEntity reponse) {
		List<Parking> resultat = new ArrayList<Parking>();
		for (RecordEntity record : reponse.getRecords()) {
			Parking parking = new Parking();
			parking.setNom(record.getFields().getGrpNom());
			parking.setStatus(getLibelleStatut(record));
			parking.setNbPlacesDispo(record.getFields().getGrpDisponible());
			parking.setNbPlacesTotal(record.getFields().getGrpExploitation());
			parking.setHeureMaj(getHeureMaj(record));
			resultat.add(parking);
		}
		return resultat;
	
	}

	private String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
		OffsetDateTime dateMajWithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
		return dateMajWithOffsetPlus2.getHour() + "h" + dateMajWithOffsetPlus2.getMinute();
	}
	
	private String getLibelleStatut(RecordEntity record) {
		switch (record.getFields().getGrpStatut()) {
			case "1": {
				return "FERME";
			}
			case "2": {
				return "ABONNES";
			}
			case "5": {
				return "OUVERT";
			}
		}
		return "Données non disponibles";
	}

}

