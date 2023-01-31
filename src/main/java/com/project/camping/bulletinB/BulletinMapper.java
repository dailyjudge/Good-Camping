package com.project.camping.bulletinB;

import java.util.List;

public interface BulletinMapper {

	ComuDTO selectAllWhere(String comu_groupid);

	int getBoardCount(ComuDTO cd);

	int writeToBoard(ComuDTO cd);

	List<ComuDTO> getBoards();

	ComuDTO getThisBoard(String comu_no);

	void updateThisBoard(String comu_no);

	int UpdateThisBoard(ComuDTO cd);

	void deleteBoard(String comu_no);


}
