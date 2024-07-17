package com.bongus.plantify.domain.crawling

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class CrawlerTestController (
    private val webCrawlerService: WebCrawlerService
){
    @GetMapping
    fun crawler(@RequestParam keyword: String){
        webCrawlerService.crawlWebsite(keyword);
    }

}