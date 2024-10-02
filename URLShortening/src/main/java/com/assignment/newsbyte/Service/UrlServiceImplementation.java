package com.assignment.newsbyte.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.newsbyte.Model.Url;
import com.assignment.newsbyte.Model.UrlDto;
import com.assignment.newsbyte.Repository.UrlRepository;
import com.google.common.hash.Hashing;

@Service  // Indicates that this class is a Spring Service
public class UrlServiceImplementation implements UrlService {
    
    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortLink(UrlDto urlDto) {
        // Ensure URL is not empty
        if (StringUtils.isNotEmpty(urlDto.getUrl())) {
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setClickCount(0);  // Initially, clicks will be 0
            urlToPersist.setMaxClicks(urlDto.getMaxClicks() != 0 ? urlDto.getMaxClicks() : 20);  // Default max clicks to 100 if not provided
            urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(), urlToPersist.getCreationDate()));
            
            // Persist the short link in the database
            Url urlToRet = persistShortLink(urlToPersist);

            if (urlToRet != null) {
                return urlToRet;
            }
        }
        // Return null if URL is empty or failed to persist
        return null;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if (StringUtils.isBlank(expirationDate)) {
            // Default expiration is 60 seconds from creation time if no expiration date is provided
            return creationDate.plusSeconds(1002);
        }
        try {
            // Parse the provided expiration date
            return LocalDateTime.parse(expirationDate);
        } catch (DateTimeParseException e) {
            // If parsing fails, fallback to 60 seconds from the creation date
            return creationDate.plusSeconds(60);
        }
    }

    private String encodeUrl(String url) {
        // Generate a short link by hashing the URL with the current time
        LocalDateTime time = LocalDateTime.now();
        return Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
    }

    @Transactional  // Ensures the database operation is handled in a transaction
    @Override
    public Url persistShortLink(Url url) {
        return urlRepository.save(url);
    }

    @Override
    public Url getEncodedUrl(String shortLink) {
        // Fetch the URL by its short link from the repository
        return urlRepository.findByShortLink(shortLink);
    }

    @Transactional  // Ensures the delete operation is handled in a transaction
    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);
    }
}
