package com.starsinmybeard.SpotifySorter.dao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starsinmybeard.SpotifySorter.models.Stream;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JdbcStreamDAO implements StreamDAO {
    private JdbcTemplate jdbcTemplate;
    List<Stream> listOfStreams = new ArrayList<>();

    //May NEED TO MAKE THIS PUBLIC
    //TODO may need to make this public
    public JdbcStreamDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void insertStream(Stream stream) {
        String sql = " INSERT into streams(ts, username, platform, ms_played, conn_country, ip_addr_decrypted, user_agent_decrypted, " +
                " master_metadata_track_name, master_metadata_album_artist_name, master_metadata_album_album_name, spotify_track_uri, " +
                " episode_name, episode_show_name, spotify_episode_uri, reason_start, reason_end, shuffle, " +
                " skipped, offline, offline_timestamp, incognito_mode) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";


        System.out.println(sql);
        //TODO may need to add boolean parse
        System.out.print(sql + stream.getTs() + " " + stream.getUsername() + " " + stream.getPlatform() + " " + stream.getMs_played() + " " + stream.getConn_country() +
                " " + stream.getIp_addr_decrypted() + " " + stream.getUser_agent_decrypted() +
                " " + stream.getMaster_metadata_track_name() + " " + stream.getMaster_metadata_album_artist_name() +
                " " + stream.getMaster_metadata_album_album_name() +
                " " + stream.getSpotify_track_uri() + " " + stream.getEpisode_name() +
                " " + stream.getEpisode_show_name() + " " + stream.getSpotify_episode_uri() +
                " " + stream.getReason_start() + " " + stream.getReason_end() + " " + stream.isShuffle() + " " + stream.isSkipped() + " " + stream.isOffline() +
                " " + stream.getOffline_timestamp() + " " + stream.isIncognito_mode());

        jdbcTemplate.execute(dropTableSqlCommand());
        jdbcTemplate.update(sql, stream.getTs(), stream.getUsername(), stream.getPlatform(),
                stream.getMs_played(), stream.getConn_country(), stream.getIp_addr_decrypted(), stream.getUser_agent_decrypted(),
                stream.getMaster_metadata_track_name(), stream.getMaster_metadata_album_artist_name(),
                stream.getMaster_metadata_album_album_name(),
                stream.getSpotify_track_uri(), stream.getEpisode_name(),
                stream.getEpisode_show_name(), stream.getSpotify_episode_uri(),
                stream.getReason_start(), stream.getReason_end(), stream.isShuffle(), stream.isSkipped(), stream.isOffline(),
                stream.getOffline_timestamp(), stream.isIncognito_mode());
    }

    @Override
    public Stream getStream(int streamId) {
        return null;
    }



    //Returns List of All Books
    @Override
    public List<Stream> getAllStreams() {
        List<Stream> results = new ArrayList<>();
        String sql = " SELECT  ts, username, platform, ms_played, conn_country, ip_addr_decrypted, user_agent_decrypted, " +
                " master_metadata_track_name, master_metadata_album_artist_name, master_metadata_album_album_name, spotify_track_uri, " +
                " episode_name, episode_show_name, spotify_episode_uri, reason_start, reason_end, shuffle, " +
                " skipped, offline, offline_timestamp, incognito_mode " +
                " from streams; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            Stream stream = mapRowToStream(rowSet);
            System.out.println(stream.getMaster_metadata_track_name());
            results.add(stream);
        }
        return results;
    }



    @Override
    public Stream getStream(){
        Stream newStream = new Stream();
        String sql = " SELECT * from streams; ";
        return newStream;
    }




    @Override
    public List<Stream> getStreamsFromArtist(String artistName) {
        List<Stream> results = new ArrayList<>();

        String sql = " SELECT  ts, username, platform, ms_played, conn_country, ip_addr_decrypted, user_agent_decrypted, " +
                " master_metadata_track_name, master_metadata_album_artist_name, master_metadata_album_album_name, spotify_track_uri, " +
                " episode_name, episode_show_name, spotify_episode_uri, reason_start, reason_end, shuffle, " +
                " skipped, offline, offline_timestamp, incognito_mode " +
                " from streams " +
                " WHERE master_metadata_album_artist_name = ?; ";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, artistName);

        while (rowSet.next()){
            Stream stream = mapRowToStream(rowSet);
            System.out.println(stream.getMaster_metadata_track_name());
            results.add(stream);
        }

        return results;
    }





    @Override
    public void insertStreamFromFile(){
        try{
            System.out.println("67");
            listOfStreams = Arrays.asList(mapper.readValue(new File
                    ("/Users/nickworley/Java/spotify-project/Backend/SpotifySorter/endsong0.json"), Stream[].class));
        } catch (IOException e){
            System.out.println("71");
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace());
        }
        for(int i = 0; i < listOfStreams.size(); i++){
            System.out.println("74");
            Stream newStream = listOfStreams.get(i);
            insertStream(newStream);
        }
    }



    private Stream mapRowToStream(SqlRowSet streamToMap){
        Stream stream = new Stream();
        stream.setTs(streamToMap.getString("ts"));
        stream.setUsername(streamToMap.getString("username"));
        stream.setPlatform(streamToMap.getString("platform"));
        stream.setMs_played(streamToMap.getInt("ms_played"));
        stream.setConn_country(streamToMap.getString("conn_country"));
        stream.setIp_addr_decrypted(streamToMap.getString("ip_addr_decrypted"));
        stream.setUser_agent_decrypted(streamToMap.getString("user_agent_decrypted"));
        stream.setMaster_metadata_track_name(streamToMap.getString("master_metadata_track_name"));
        stream.setMaster_metadata_album_artist_name(streamToMap.getString("master_metadata_album_artist_name"));
        stream.setMaster_metadata_album_album_name(streamToMap.getString("master_metadata_album_album_name"));
        stream.setSpotify_track_uri(streamToMap.getString("spotify_track_uri"));
        stream.setEpisode_name(streamToMap.getString("episode_name"));
        stream.setEpisode_show_name(streamToMap.getString("episode_show_name"));
        stream.setSpotify_episode_uri(streamToMap.getString("spotify_episode_uri"));
        stream.setReason_start(streamToMap.getString("reason_start"));
        stream.setReason_end(streamToMap.getString("reason_end"));
        stream.setShuffle(streamToMap.getBoolean("shuffle"));
        stream.setSkipped(streamToMap.getBoolean("skipped"));
        stream.setOffline(streamToMap.getBoolean("offline"));
        stream.setOffline_timestamp(streamToMap.getString("offline_timestamp"));
        stream.setIncognito_mode(streamToMap.getBoolean("incognito_mode"));
        return stream;
    };

    private String dropTableSqlCommand(){
         String dropTable =
                        "DROP table if exists streams; " +
                        " CREATE TABLE streams( " +
                        " stream_id serial NOT NULL, " +
                        " tts varchar(50), " +
                        " username varchar(50), " +
                        " platform varchar(100), " +
                        " ms_played int, " +
                        " conn_country varchar(20), " +
                        " ip_addr_decrypted varchar (25), " +
                        " user_agent_decrypted varchar (200), " +
                        " master_metadata_track_name varchar(200), " +
                        " master_metadata_album_artist_name varchar(200), " +
                        " master_metadata_album_album_name varchar(400), " +
                        " spotify_track_uri varchar(100), " +
                        " episode_name varchar(200), " +
                        " episode_show_name varchar(200), " +
                        " spotify_episode_uri varchar(100), " +
                        " reason_start varchar(30), " +
                        " reason_end varchar(30), " +
                        " shuffle BOOLEAN, " +
                        " skipped BOOLEAN, " +
                        " offline BOOLEAN, " +
                        " offline_timestamp varchar(40), " +
                        " incognito_mode BOOLEAN " +
                        " ); ";
         return dropTable;
    }


}
