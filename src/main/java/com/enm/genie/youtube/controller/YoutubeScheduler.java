package com.enm.genie.youtube.controller;

import com.enm.genie.youtube.dao.YoutubeDAO;
import com.enm.genie.youtube.dto.YoutubeDTO;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Component
//@RestController
//@RequestMapping("/youtubescheduled")
public class YoutubeScheduler {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final long NUMBER_OF_VIDEOS_RETURNED = 1;
    private static YouTube youtube;

    private static String key="AIzaSyArnbKYeK6OYxJ3DVK9SxGb5hlBygGDFFU";

    //    private static String playlistId="PLjUVzlcpeN4SZ5hmi7FsSnDNQ2cCXqI4D"; // 플레이리스트 id
    private static String playlistId="PLjUVzlcpeN4RjpMtu_youlnBIgNJuG6z4"; // 플레이리스트 id (로드투킹덤)

    @Autowired
    private YoutubeDAO youtubeDAO;

    Logger logger= LoggerFactory.getLogger(getClass());

    // 1초에 한번 실행된다.
/*    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedRateTask() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }*/

    //    @GetMapping("/test")
//    @Scheduled(cron = "0 0/10 * * * *") // 매 10분마다 실행
    @Scheduled(cron = "0 0 12 * * *") //12:00 마다 실행
    public void youtubeScheduler() throws Exception{


        System.out.println("youtubeScheduler start.");
        List<PlaylistItem> playlistItemList=new ArrayList<PlaylistItem>();


        try {
            System.out.println("youtubeScheduler try 문");
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-myuploads-sample").build();

            YouTube.PlaylistItems.List playlistItem=youtube.playlistItems().list("id,contentDetails,snippet");
            playlistItem.setKey(key);
            playlistItem.setPlaylistId(playlistId);

            String nextToken="";

            do{

                playlistItem.setPageToken(nextToken);

                PlaylistItemListResponse playlistItemResult=playlistItem.execute();

                playlistItemList.addAll(playlistItemResult.getItems());
                nextToken=playlistItemResult.getNextPageToken();

            }while(nextToken!=null);

//            prettyPrint(playlistItemList.size(),playlistItemList.iterator());

            System.out.println("youtubeScheduler save 문");
            saveYoutube(playlistItemList.size(),playlistItemList.iterator());
//
//            if (playlistItemList != null) {
//                prettyPrint(playlistItemList.size(), playlistItemList.iterator());
//            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
            logger.error("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
            logger.error("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }


//        return playlistItemList;

    }
    public void saveYoutube(int size, Iterator<PlaylistItem> playlistEntries) throws Exception{
        logger.info("=============================================================");
        logger.info("\t\tTotal Videos Uploaded: " + size);
        logger.info("=============================================================\n");
        System.out.println("=============================================================");
        System.out.println("\t\tTotal Videos Uploaded: " + size);
        System.out.println("=============================================================\n");

        List<YoutubeDTO> youtubeDTOList=new ArrayList<YoutubeDTO>();
        try{
        while (playlistEntries.hasNext()) {
            PlaylistItem playlistItem = playlistEntries.next();
            YoutubeDTO youtubeDTO=new YoutubeDTO();
//            System.out.println(" video name  = " + playlistItem.getSnippet().getTitle());
//            System.out.println(" video id    = " + playlistItem.getContentDetails().getVideoId());
//            System.out.println(" upload date = " + playlistItem.getSnippet().getPublishedAt());
//            System.out.println("\n-------------------------------------------------------------\n");
            youtubeDTO.setTitle(playlistItem.getSnippet().getTitle());
            youtubeDTO.setThumbnailPath(playlistItem.getSnippet().getThumbnails().getStandard().getUrl());
            youtubeDTO.setVideoId(playlistItem.getContentDetails().getVideoId());
            youtubeDTO.setDescription(playlistItem.getSnippet().getDescription());
            youtubeDTO.setPlayUrl("https://www.youtube.com/watch?v="+playlistItem.getContentDetails().getVideoId());
            youtubeDTOList.add(youtubeDTO);
            logger.info("video id : "+youtubeDTO.getVideoId());
            logger.info("video title : "+youtubeDTO.getTitle());
            logger.info("video thumbnail : "+youtubeDTO.getThumbnailPath());
            logger.info("video playUrl : "+youtubeDTO.getPlayUrl());
        }}catch (Exception e){
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
            logger.error("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        }
        youtubeDAO.saveYoutubeScheduled(youtubeDTOList);
    }

    /*@Scheduled(cron="0 0 16 26 * *") // 매 1분마다 실행
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

    }*/
}
