package com.bongus.plantify.domain.crawling

import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class WebCrawlerService {

    fun crawlWebsite(keyword: String): String {
        val result = StringBuilder()

        try {
            val cleanedKeyword = cleanKeyword(keyword)
            val url = "https://ko.wikipedia.org/wiki/$cleanedKeyword"
            val doc = Jsoup.connect(url)
//                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                .timeout(5000)
                .get()

            result.append("제가 보기에 이 사진 속의 식물은... $cleanedKeyword 입니다!\n" +
                    "다음은 $cleanedKeyword 에 대한 정보입니다.\n")

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

    private fun cleanKeyword(keyword: String): String {
        // 정규 표현식을 사용하여 알파벳과 숫자만 포함된 문자열로 변환
        return keyword.replace(Regex("[^A-Za-z0-9가-힣]"), "")
    }

}