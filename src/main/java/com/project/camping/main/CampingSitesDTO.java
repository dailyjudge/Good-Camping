package com.project.camping.main;

import java.util.List;

public class CampingSitesDTO {
	private List<MainDTO> campingSites;
	
	public CampingSitesDTO() {
		// TODO Auto-generated constructor stub
	}

	public CampingSitesDTO(List<MainDTO> campingSites) {
		super();
		this.campingSites = campingSites;
	}

	public List<MainDTO> getCampingSites() {
		return campingSites;
	}

	public void setCampingSites(List<MainDTO> campingSites) {
		this.campingSites = campingSites;
	}
	
	
}
