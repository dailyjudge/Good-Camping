package com.project.camping.stuff;

import java.util.List;

public interface StuffMapper {

	int insertStuff(StuffDTO sDto);

	List<StuffDTO> getAllStuff(StuffDTO s);

	StuffDTO getDetailStuff(StuffDTO s);

	List<StuffDTO> getSearchStuff(StuffSearchDTO s);

}
