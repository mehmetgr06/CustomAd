package com.mehmet.customad.Models;

public class AdImagePojo{
	private String image;
	private String title;
	private boolean full;

	public String getTitle() {
		return title;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setFull(boolean full){
		this.full = full;
	}

	public boolean isFull(){
		return full;
	}

	@Override
 	public String toString(){
		return 
			"AdImagePojo{" + 
			"image = '" + image + '\'' + 
			",full = '" + full + '\'' + 
			",title = '" + title + '\'' +
			"}";
		}
}
