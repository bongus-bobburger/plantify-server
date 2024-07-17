package com.bongus.plantify.domain.crawling

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

@Service
class WebCrawlerService {

    fun crawlWebsite(keyword: String): String {
        val result = StringBuilder()

        try {
            val cleanedKeyword = cleanKeyword(keyword)
            val url = "https://ko.wikipedia.org/wiki/$cleanedKeyword"
            val doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                .timeout(5000)
                .get()

            result.append("제가 보기에 이 사진 속의 식물은... $cleanedKeyword 입니다!\n" +
                    "다음은 $cleanedKeyword 에 대한 정보입니다.\n")

            // 테이블에서 이미지 가져오기
            val infoboxImages = extractImageUrls(doc)
            if (infoboxImages.isNotEmpty()) {
                result.append("Images:\n")
                for (image in infoboxImages) {
                    result.append(image).append("")
                }
            }

            // 원하는 HTML 요소를 선택하여 데이터 추출 가능
            val paragraphs = doc.select("div.mw-parser-output > p")
            for (paragraph in paragraphs) {
                result.append(paragraph.text()).append("\n")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result.toString()
    }

    private fun extractImageUrls(doc: Document): List<String> {
        val imageUrls = mutableListOf<String>()
        try {
            // span 태그에서 mw:File 속성을 가진 요소 선택
            val fileSpans = doc.select("span[typeof='mw:File']")
            val fileSpans2 = doc.select("span[typeof='mw:File/Thumb']")
            for (fileSpan in fileSpans) {
                // a 태그에서 href 속성 값 가져오기
                val aTag = fileSpan.selectFirst("a[href^='https://commons.wikimedia.org/wiki/File']")
                val href = aTag?.attr("href")
                if (!href.isNullOrBlank()) {
                    imageUrls.add(href)
                }
            }
            for (fileSpan in fileSpans2) {
                // a 태그에서 href 속성 값 가져오기
                val aTag = fileSpan.selectFirst("a[href^='https://commons.wikimedia.org/wiki/File']")
                val href = aTag?.attr("href")
                if (!href.isNullOrBlank()) {
                    imageUrls.add(href)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return imageUrls
    }


    private fun cleanKeyword(keyword: String): String {
        // 정규 표현식을 사용하여 알파벳과 숫자만 포함된 문자열로 변환
        return keyword.replace(Regex("[^A-Za-z0-9가-힣]"), "")
    }
}