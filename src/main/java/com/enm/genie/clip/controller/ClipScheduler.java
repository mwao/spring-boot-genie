package com.enm.genie.clip.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class ClipScheduler {

    @Scheduled(cron="0 0 16 26 * *") // 매 1분마다 실행
    public void youtubeApiCall() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now=new Date();
        String strDate=sdf.format(now);

        String apiUrl="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLjUVzlcpeN4R7L-EPRiek8ua2wugUo76V&maxResults=50&key=AIzaSyArnbKYeK6OYxJ3DVK9SxGb5hlBygGDFFU";
        URL url=new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        int resCode = conn.getResponseCode();

        System.out.println(resCode);
        System.out.println(conn.getResponseMessage());
        System.out.println(conn.getContent().toString());

        Object result = conn.getContent();
        int ch;
        while((ch=((InputStream)result).read()) != -1) {
            System.out.print((char) ch);
        }

//        log.info("now: "+strDate);
//        log.info("youtube api call 결과 : "+result.toString());

    }

}
