package com.starsinmybeard.SpotifySorter.dao;

import com.starsinmybeard.SpotifySorter.models.Stream;
import java.util.List;

public interface StreamDAO {


    public void insertStream(Stream stream);
    Stream getStream(int streamId);
    List<Stream> getAllStreams();

    Stream getStream();

    List<Stream> getStreamsFromArtist(String artistName);

    void insertStreamFromFile();
}
