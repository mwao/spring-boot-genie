package com.enm.genie.youtube.service;

import com.enm.genie.youtube.provider.YoutubeProvider;
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
import com.google.api.services.youtube.model.Thumbnail;
import com.google.api.services.youtube.model.Video;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@MapperScan(basePackages = "com.enm.genie.youtube.dao")
public class YoutubeService implements YoutubeProvider {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final long NUMBER_OF_VIDEOS_RETURNED = 1;
    private static YouTube youtube;

    private static String key="AIzaSyArnbKYeK6OYxJ3DVK9SxGb5hlBygGDFFU";

    private static String playlistId="PLjUVzlcpeN4SZ5hmi7FsSnDNQ2cCXqI4D"; // 플레이리스트 id

    @Autowired
    private YoutubeDAO youtubeDAO;

    Logger logger= LoggerFactory.getLogger(getClass());

    private static void prettyPrint(Iterator<Video> iteratorSearchResults, YoutubeDTO youTubeDto) {

        System.out.println("\n=============================================================");
        System.out.println("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            System.out.println(" There aren't any results for your query.");
        }

        while (iteratorSearchResults.hasNext()) {

            Video singleVideo = iteratorSearchResults.next();

            // Double checks the kind is video.
            if (singleVideo.getKind().equals("youtube#video")) {
                Thumbnail thumbnail = (Thumbnail) singleVideo.getSnippet().getThumbnails().get("default");

                System.out.println(" Video Id" + singleVideo.getId());
                System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
                System.out
                        .println(" contentDetails Duration: " + singleVideo.getContentDetails().getDuration());
                System.out.println(" Thumbnail: " + thumbnail.getUrl());
                System.out.println("\n-------------------------------------------------------------\n");

                youTubeDto.setThumbnailPath(thumbnail.getUrl());
                youTubeDto.setTitle(singleVideo.getSnippet().getTitle());
                youTubeDto.setVideoId(singleVideo.getId());

            }
        }
    }

    private static void prettyPrint(int size, Iterator<PlaylistItem> playlistEntries) {
        System.out.println("=============================================================");
        System.out.println("\t\tTotal Videos Uploaded: " + size);
        System.out.println("=============================================================\n");

        while (playlistEntries.hasNext()) {
            PlaylistItem playlistItem = playlistEntries.next();
            System.out.println(" video name  = " + playlistItem.getSnippet().getTitle());
            System.out.println(" video id    = " + playlistItem.getContentDetails().getVideoId());
            System.out.println(" upload date = " + playlistItem.getSnippet().getPublishedAt());
            System.out.println("\n-------------------------------------------------------------\n");
        }
    }
    @Override
    public YoutubeDTO get() {
        YoutubeDTO youTubeDto = new YoutubeDTO();

        try {
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-video-duration-get").build();

            //내가 원하는 정보 지정할 수 있어요. 공식 API문서를 참고해주세요.
            YouTube.Videos.List videos = youtube.videos().list("id,snippet,contentDetails");
            videos.setKey(key);
            videos.setId("PwU2zn7h_Qg");
            videos.setMaxResults(NUMBER_OF_VIDEOS_RETURNED); //조회 최대 갯수.
            List<Video> videoList = videos.execute().getItems();

            if (videoList != null) {
                prettyPrint(videoList.iterator(), youTubeDto);
            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return youTubeDto;
    }

    @Override
    public List<PlaylistItem> getlist() {



        List<PlaylistItem> playlistItemList=new ArrayList<PlaylistItem>();


        try {
            youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-myuploads-sample").build();

//            //내가 원하는 정보 지정할 수 있어요. 공식 API문서를 참고해주세요.
//            YouTube.Videos.List videos = youtube.videos().list("id,snippet,contentDetails");
//            videos.setKey(key);
//            videos.setId("PwU2zn7h_Qg");
//            videos.setMaxResults(NUMBER_OF_VIDEOS_RETURNED); //조회 최대 갯수.
//            List<Video> videoList = videos.execute().getItems();

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

            saveYoutube(playlistItemList.size(),playlistItemList.iterator());
//
//            if (playlistItemList != null) {
//                prettyPrint(playlistItemList.size(), playlistItemList.iterator());
//            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }


        return playlistItemList;
    }


    //@Scheduled(cron="0 0 16 26 * *")
    public void saveYoutube(int size, Iterator<PlaylistItem> playlistEntries) throws Exception{
        System.out.println("=============================================================");
        System.out.println("\t\tTotal Videos Uploaded: " + size);
        System.out.println("=============================================================\n");

        List<YoutubeDTO> youtubeDTOList=new ArrayList<YoutubeDTO>();
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
        }
        youtubeDAO.saveYoutube(youtubeDTOList);
    }
    public void saveYoutube(List<PlaylistItem> playlistItems) throws Exception{

//        if(boardDTO.getBoardseq()==0) // 신규
//        {
//            boardDTO.setProgramseq(0);
//            boardDTO.setDeleteYn("N");
//            boardDAO.saveBoard(boardDTO);
//        }
//        else //수정
//        {
//            boardDAO.updateBoard(boardDTO);
//        }
//        youtubeDAO.saveYoutube(playlistItems);

    }
}