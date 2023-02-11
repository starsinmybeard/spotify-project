package com.starsinmybeard.SpotifySorter.controllers;
import com.starsinmybeard.SpotifySorter.dao.JdbcStreamDAO;
import com.starsinmybeard.SpotifySorter.dao.StreamDAO;
import com.starsinmybeard.SpotifySorter.models.Stream;
import jakarta.annotation.security.PermitAll;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class StreamsController {
    private StreamDAO streamDAO;
    public StreamsController(JdbcStreamDAO jdbcStreamDAO){
        this.streamDAO = jdbcStreamDAO;
    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Stream> getAllStreams(){
        return this.streamDAO.getAllStreams();
    };


    @RequestMapping(path = "/", method = RequestMethod.POST)
    public void fillDatabase(){
        this.streamDAO.insertStreamFromFile();
    };

    @RequestMapping(path = "/Stream/{streamId}", method = RequestMethod.GET)
    public Stream getStream(@PathVariable int streamId) {
        Stream streamToReturn = new Stream();
        streamToReturn = streamDAO.getStream(streamId);
        return streamToReturn;
    };


    @RequestMapping(path = "/{artistName}", method = RequestMethod.GET)
    public List<Stream> getStreamsFromArtist(@PathVariable String artistName){

        return this.streamDAO.getStreamsFromArtist(artistName);
    };

}
