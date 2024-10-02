package com.assignment.newsbyte.Model;

import jakarta.persistence.Entity;


public class UrlDto {

	
	    private String url;
	    private String expirationDate;  //optional
	    private int maxClicks;  // Add maxClicks field

	    public UrlDto(String url, String expirationDate , int maxClicks ) {
	        this.url = url;
	        this.expirationDate = expirationDate;
	        this.maxClicks= maxClicks;
	    }

	    public int getMaxClicks() {
			return maxClicks;
		}

		public void setMaxClicks(int maxClicks) {
			this.maxClicks = maxClicks;
		}

		public UrlDto() {
	    }

	    public String getUrl() {
	        return url;
	    }

	    public void setUrl(String url) {
	        this.url = url;
	    }

	    public String getExpirationDate() {
	        return expirationDate;
	    }

	    public void setExpirationDate(String expirationDate) {
	        this.expirationDate = expirationDate;
	    }

	    @Override
		public String toString() {
			return "UrlDto [url=" + url + ", expirationDate=" + expirationDate + ", maxClicks=" + maxClicks + "]";
		}
}
