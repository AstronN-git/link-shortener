package com.max.urlshortener.services;

import com.max.urlshortener.entities.Url;
import com.max.urlshortener.repositories.UrlRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Transactional
    public Url save (Url url) {
        return urlRepository.save(url);
    }

    @Transactional
    public Url getById (Long id) {
        return urlRepository
                .findById(id)
                .orElse(
                        new Url(-1L, "https://docs.microsoft.com/ru-ru/windows/win32/uxguide/images/mess-error-image15.png")
                );
    }
}
