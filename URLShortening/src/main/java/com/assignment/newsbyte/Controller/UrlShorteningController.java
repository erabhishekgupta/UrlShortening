package com.assignment.newsbyte.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.assignment.newsbyte.Model.Url;
import com.assignment.newsbyte.Model.UrlDto;
import com.assignment.newsbyte.Model.UrlErrorResponse;
import com.assignment.newsbyte.Model.UrlResponseDto;
import com.assignment.newsbyte.Service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.time.LocalDateTime;

@RestController
public class UrlShorteningController
{
    private UrlService urlService;
    public UrlShorteningController(UrlService urlService) {
    	this.urlService = urlService;
    }
    @CrossOrigin(origins = "http://localhost:5173") 
    @PostMapping("/generate")
     // Allow requests from your React frontend
    
    public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto)
    
    {  
    	System.out.println("Received URL DTO: " + urlDto);
    	System.out.println("Received URL: " + urlDto.getUrl());
        Url urlToRet = urlService.generateShortLink(urlDto);

        if(urlToRet != null)
        {
            UrlResponseDto urlResponseDto = new UrlResponseDto();
            urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
            urlResponseDto.setExpirationDate(urlToRet.getExpirationDate());
            urlResponseDto.setShortLink(urlToRet.getShortLink());
            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResponse urlErrorResponseDto = new UrlErrorResponse();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setError("There was an error processing your request. please try again.");
        return new ResponseEntity<UrlErrorResponse>(urlErrorResponseDto,HttpStatus.OK);

    }

    @GetMapping("/{shortLink}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {

        if(StringUtils.isEmpty(shortLink))
        {
            UrlErrorResponse urlErrorResponseDto = new UrlErrorResponse();
            urlErrorResponseDto.setError("Invalid Url");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponse>(urlErrorResponseDto,HttpStatus.OK);
        }
        Url urlToRet = urlService.getEncodedUrl(shortLink);

        if(urlToRet == null)
        {
            UrlErrorResponse urlErrorResponseDto = new UrlErrorResponse();
            urlErrorResponseDto.setError("Url does not exist or it might have expired!");
            urlErrorResponseDto.setStatus("400");
            return new ResponseEntity<UrlErrorResponse>(urlErrorResponseDto,HttpStatus.OK);
        }

        if(urlToRet.getExpirationDate().isBefore(LocalDateTime.now()) || urlToRet.getClickCount() >= urlToRet.getMaxClicks())
        {
            urlService.deleteShortLink(urlToRet);
            UrlErrorResponse urlErrorResponseDto = new UrlErrorResponse();
            urlErrorResponseDto.setError("Url Expired. Please try generating a fresh one.");
            urlErrorResponseDto.setStatus("200");
            return new ResponseEntity<UrlErrorResponse>(urlErrorResponseDto,HttpStatus.OK);
        }

        // Increment the click count
        urlToRet.setClickCount(urlToRet.getClickCount() + 1);
        urlService.persistShortLink(urlToRet);  // Save the updated click count

        // Redirect to the original URL
        response.sendRedirect(urlToRet.getOriginalUrl());
        return null;
    }
}