package com.project.camping.main;

import java.util.List;
import java.util.Map;

import com.project.camping.account.AccountDTO;

public interface MainMapper {

	int insertCampingData(MainDTO m);

	int deleteAlldata();

	List<MainDTO> getAllCampingSite();

	List<MainDTO> searchCampingSite(SearchDTO s);

	MainDTO getCampingSite(MainDTO m);

	List<ReviewDTO> getReviews(MainDTO m);

	int deleteReview(ReviewDTO r);

	int updateReview(ReviewDTO r);

	int createReview(ReviewDTO r);

	int getReviewCount(MainDTO mDTO);

	SiteViewDTO getSiteViewCount(MainDTO mDTO);

	int checkVisitedUser(Map<String, String> map);

	int upSiteReviewCount(Map<String, String> map);

	int createSiteView(MainDTO m);

	int upSiteViewCount(MainDTO m);
	
}
