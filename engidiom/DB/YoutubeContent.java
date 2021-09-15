package com.example.engidiom.DB;

import java.util.Comparator;

public class YoutubeContent {

    private int id;
    private int dateOfPost;
    private String title;
    private String SubTitle;
    private String imageVideoURL;
    private String videoURL;

    public YoutubeContent(int id, int dateOfPost, String title, String subTitle, String imageVideoURL, String videoURL) {
        this.id = id;
        this.dateOfPost = dateOfPost;
        this.title = title;
        this.SubTitle = subTitle;
        this.imageVideoURL = imageVideoURL;
        this.videoURL = videoURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(int dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
    }

    public String getImageVideoURL() {
        return imageVideoURL;
    }

    public void setImageVideoURL(String imageVideoURL) {
        this.imageVideoURL = imageVideoURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

   /* public static Comparator<YoutubeContent> YoutubeContenttitleAZComparator = new Comparator<YoutubeContent>() {
        @Override
        public int compare(YoutubeContent o1, YoutubeContent o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

    public static Comparator<YoutubeContent> YoutubeContenttitleZAComparator = new Comparator<YoutubeContent>() {
        @Override
        public int compare(YoutubeContent o1, YoutubeContent o2) {
            return o2.getTitle().compareTo(o1.getTitle());
        }
    };*/
    public static Comparator<YoutubeContent> YoutubeContenttitl날짜오름차순Comparator = new Comparator<YoutubeContent>() {
        @Override
        public int compare(YoutubeContent o1, YoutubeContent o2) {
            return o1.getDateOfPost() - o2.getDateOfPost();
        }
    };
    public static Comparator<YoutubeContent> YoutubeContenttitle날짜내림차순Comparator = new Comparator<YoutubeContent>() {
        @Override
        public int compare(YoutubeContent o1, YoutubeContent o2) {
            return o2.getDateOfPost() - o1.getDateOfPost();
        }
    };

    @Override
    public String toString() {
        return "YoutubeContent{" +
                "id=" + id +
                ", dateOfPost=" + dateOfPost +
                ", title='" + title + '\'' +
                ", SubTitle='" + SubTitle + '\'' +
                ", imageVideoURL='" + imageVideoURL + '\'' +
                ", videoURL='" + videoURL + '\'' +
                '}';
    }
}
