package com.project.camping.main;

import java.util.List;

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
	
}
