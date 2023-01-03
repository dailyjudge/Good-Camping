package com.project.camping.main;

import java.util.List;

public interface MainMapper {

	int insertCampingData(MainDTO m);

	int deleteAlldata();

	List<MainDTO> getAllCampingSite();

	List<MainDTO> searchCampingSite(SearchDTO s);

	MainDTO getCampingSite(MainDTO m);
	
}
