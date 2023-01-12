package com.project.camping.theme;

import java.util.List;

import com.project.camping.main.MainDTO;

public interface ThemeMapper {

	List<MainDTO> getSearchCampingSiteByTheme(ThemeDTO t);
	
}
