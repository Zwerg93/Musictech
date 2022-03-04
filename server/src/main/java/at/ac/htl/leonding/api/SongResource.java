package at.ac.htl.leonding.api;


import at.ac.htl.leonding.models.SongDOT;
import at.ac.htl.leonding.workloads.Song.Song;
import at.ac.htl.leonding.workloads.Song.SongService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Produces("application/json")
@Path("song")
@Consumes("application/json")
public class SongResource {
    private final SongService songService;

    public SongResource(SongService songService) {
        this.songService = songService;
    }

    @GET
    @Path("all")
    public Response getAllSongs() {
        var allSongs = this.songService.getAll();
        return Response.ok(allSongs).build();
    }

    @POST
    @Transactional
    public Response addSong(SongDOT newSong) {
        return Response.ok(this.songService.addSong(newSong.getName(),
                newSong.getArtist(),
                newSong.getUrl())).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Song song = this.songService.getSong(id);
        return (song == null
                ? Response.status(404)
                : Response.ok(song))
                .build();
    }


}
