package com.starsinmybeard.SpotifySorter.models;

public class Stream {

    private String ts;
    private String username;
    private String platform;
    private int ms_played;
    private String conn_country;
    private String ip_addr_decrypted;
    private String user_agent_decrypted;
    private String master_metadata_track_name;
    private String master_metadata_album_artist_name;
    private String master_metadata_album_album_name;
    private String spotify_track_uri;
    private String episode_name;
    private String episode_show_name;
    private String spotify_episode_uri;
    private String reason_start;
    private String reason_end;
    private boolean shuffle;
    private boolean skipped;
    private boolean offline;
    private String offline_timestamp;
    private boolean incognito_mode;

    public Stream(String ts, String username, String platform, int ms_played, String conn_country,
                  String ip_addr_decrypted, String user_agent_decrypted, String master_metadata_track_name,
                  String master_metadata_album_artist_name, String master_metadata_album_album_name,
                  String spotify_track_uri, String episode_name, String episode_show_name, String spotify_episode_uri,
                  String reason_start, String reason_end, boolean shuffle, boolean skipped, boolean offline,
                  String offline_timestamp, boolean incognito_mode) {
        String checkMasterMetaDataTrackName;
       String checkNullEpName;
       String checkNullEpShowName;
       String checkNullEpUri;
        this.ts = checkNotNull(ts);
        this.username = checkNotNull(username);
        this.platform = checkNotNull(platform);
        this.ms_played = ms_played;
        this.conn_country = checkNotNull(conn_country);
        this.ip_addr_decrypted = checkNotNull(ip_addr_decrypted);
        this.user_agent_decrypted = user_agent_decrypted;
        this.master_metadata_track_name = checkNotNull(master_metadata_track_name);

//        if(master_metadata_track_name != null){
//            checkMasterMetaDataTrackName = master_metadata_track_name.replaceAll("\"", "\'");
//        } else{checkMasterMetaDataTrackName = null;};
//        this.master_metadata_track_name = checkMasterMetaDataTrackName;
//        this.master_metadata_track_name = master_metadata_track_name;

        this.master_metadata_album_artist_name = checkNotNull(master_metadata_album_artist_name);
        this.master_metadata_album_album_name = checkNotNull(master_metadata_album_album_name);
        this.spotify_track_uri = checkNotNull(spotify_track_uri);

//        // Check if Stream was an episode - then remove double quotes for sql
//            if(episode_name != null){
//                checkNullEpName = episode_name.replaceAll("\"", "\'");
//            } else{checkNullEpName = null;};
        this.episode_name = checkNotNull(episode_name);


            if(episode_show_name != null){
                checkNullEpShowName = episode_show_name.replaceAll("\"", "\'");
            } else{checkNullEpShowName = null;};
        this.episode_show_name = checkNotNull(episode_show_name);

            if(spotify_episode_uri != null){
                checkNullEpUri = spotify_episode_uri.replaceAll("\"", "\'");
            } else{checkNullEpUri = null;};
        this.spotify_episode_uri = checkNotNull(spotify_episode_uri);

        this.reason_start = checkNotNull(reason_start);
        this.reason_end = checkNotNull(reason_end);
        this.shuffle = shuffle;
        this.skipped = skipped;
        this.offline = offline;
        this.offline_timestamp = checkNotNull(offline_timestamp);
        this.incognito_mode = incognito_mode;
    }

    public Stream(){

    }


    //Getters and Setters
    public String getTs() {return checkNotNull(ts);}
    public void setTs(String ts) {
        this.ts = ts;
    }
    public String getUsername() {
        return checkNotNull(username);
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPlatform() {
        return checkNotNull(platform);
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public int getMs_played() {
        return ms_played;
    }
    public void setMs_played(int ms_played) {
        this.ms_played = ms_played;
    }
    public String getConn_country() {
        return checkNotNull(conn_country);
    }
    public void setConn_country(String conn_country) {
        this.conn_country = conn_country;
    }
    public String getIp_addr_decrypted() {
        return checkNotNull(ip_addr_decrypted);
    }
    public void setIp_addr_decrypted(String ip_addr_decrypted) {
        this.ip_addr_decrypted = ip_addr_decrypted;
    }
    public String getUser_agent_decrypted() {
        return checkNotNull(user_agent_decrypted);
    }
    public void setUser_agent_decrypted(String user_agent_decrypted) {this.user_agent_decrypted = user_agent_decrypted;}
    public String getMaster_metadata_track_name() {
        return checkNotNull(master_metadata_track_name);
    }
    public void setMaster_metadata_track_name(String master_metadata_track_name) {this.master_metadata_track_name = master_metadata_track_name;}
    public String getMaster_metadata_album_artist_name() {
        return checkNotNull(master_metadata_album_artist_name);
    }
    public void setMaster_metadata_album_artist_name(String master_metadata_album_artist_name) {this.master_metadata_album_artist_name = master_metadata_album_artist_name;}
    public String getMaster_metadata_album_album_name() {
        return checkNotNull(master_metadata_album_album_name);
    }
    public void setMaster_metadata_album_album_name(String master_metadata_album_album_name) {this.master_metadata_album_album_name = master_metadata_album_album_name;}
    public String getSpotify_track_uri() {
        return checkNotNull(spotify_track_uri);
    }
    public void setSpotify_track_uri(String spotify_track_uri) {
        this.spotify_track_uri = spotify_track_uri;
    }
    public String getEpisode_name() {
        return checkNotNull(episode_name);
    }
    public void setEpisode_name(String episode_name) {
        this.episode_name = episode_name;
    }
    public String getEpisode_show_name() {
        return checkNotNull(episode_show_name);
    }
    public void setEpisode_show_name(String episode_show_name) {
        this.episode_show_name = episode_show_name;
    }
    public String getSpotify_episode_uri() {
        return checkNotNull(spotify_episode_uri);
    }
    public void setSpotify_episode_uri(String spotify_episode_uri) {
        this.spotify_episode_uri = spotify_episode_uri;
    }
    public String getReason_start() {
        return checkNotNull(reason_start);
    }
    public void setReason_start(String reason_start) {
        this.reason_start = reason_start;
    }
    public String getReason_end() {
        return checkNotNull(reason_end);
    }
    public void setReason_end(String reason_end) {
        this.reason_end = reason_end;
    }
    public boolean isShuffle() {
        return shuffle;
    }
    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }
    public boolean isSkipped() {
        return skipped;
    }
    public void setSkipped(boolean skipped) {
        this.skipped = skipped;
    }
    public boolean isOffline() {
        return offline;
    }
    public void setOffline(boolean offline) {
        this.offline = offline;
    }
    public String getOffline_timestamp() {
        return checkNotNull(offline_timestamp);
    }
    public void setOffline_timestamp(String offline_timestamp) {
        this.offline_timestamp = offline_timestamp;
    }
    public boolean isIncognito_mode() {
        return incognito_mode;
    }
    public void setIncognito_mode(boolean incognito_mode) {
        this.incognito_mode = incognito_mode;
    }

    public String checkNotNull(String string){
        if(string == null){
            return string = null;
        } else {
            return  string.replaceAll("\"", "\'");
        }
    };
}
