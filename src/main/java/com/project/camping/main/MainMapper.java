package com.project.camping.main;

import java.util.List;

public interface MainMapper {

	int insertCampingData(MainDTO m);

	int deleteAlldata();

	List<MainDTO> getAllCampingSite();
	
}
