package com.project.camping.main;

public class SearchDTO {
	private String searchValue;
	private String sido1;
	private String gugun1;
	
	public SearchDTO() {
		// TODO Auto-generated constructor stub
	}

	public SearchDTO(String searchValue, String sido1, String gugun1) {
		super();
		this.searchValue = searchValue;
		this.sido1 = sido1;
		this.gugun1 = gugun1;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSido1() {
		return sido1;
	}

	public void setSido1(String sido1) {
		this.sido1 = sido1;
	}

	public String getGugun1() {
		return gugun1;
	}

	public void setGugun1(String gugun1) {
		this.gugun1 = gugun1;
	}

	@Override
	public String toString() {
		return "SearchDTO [searchValue=" + searchValue + ", sido1=" + sido1 + ", gugun1=" + gugun1 + "]";
	}
	
	
}
