package com.project.camping.main;

public class facilityDTO {
	private String image;
	private String desc;
	
	public facilityDTO() {
		// TODO Auto-generated constructor stub
	}

	public facilityDTO(String image, String desc) {
		super();
		this.image = image;
		this.desc = desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "facilityDTO [image=" + image + ", desc=" + desc + "]";
	}
	
	
}
