package com.project.camping.theme;

import java.util.List;
import java.util.Map;

import com.project.camping.main.MainDTO;

public interface ThemeMapper {

	List<MainDTO> getSearchCampingSiteByTheme(ThemeDTO t);

	List<MainDTO> getCampingSitesByArea(Map<String, String> map);
	
}
