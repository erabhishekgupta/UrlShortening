package com.assignment.newsbyte.Service;



import com.assignment.newsbyte.Model.Url;
import com.assignment.newsbyte.Model.UrlDto;


public interface UrlService {

	
	    public Url generateShortLink(UrlDto urlDto);
	    public Url persistShortLink(Url url);
	    public Url getEncodedUrl(String url);
	    public  void  deleteShortLink(Url url);
}
