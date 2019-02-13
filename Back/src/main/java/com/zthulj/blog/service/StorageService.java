package com.zthulj.blog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
    private final static Logger log = LoggerFactory.getLogger(StorageService.class.getName());

    @Value("${image.static.path}")
    private String test;

    public void storeImage(MultipartFile file){
        log.info("Will try to store file into the persistent and exposed folder");
    }
}
