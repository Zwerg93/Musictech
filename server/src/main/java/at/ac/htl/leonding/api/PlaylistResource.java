package at.ac.htl.leonding.api;

import at.ac.htl.leonding.models.PlaylistDOT;
import at.ac.htl.leonding.workloads.Playlist.PlaylistService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Produces("application/json")
@Path("playlist")
@Consumes("application/json")

public class PlaylistResource {
    private final PlaylistService playlistService;


    @GET
    //@Produces("application/")
    @Path("all")
    public Response getallPlaylist() {
        var allPlaylists = this.playlistService.getAll();
        return Response.ok(allPlaylists).build();
    }

    @POST
    @Transactional
    public Response addPlaylist(PlaylistDOT newPlaylist) {
        return Response.ok(this.playlistService.addPlaylist(
                newPlaylist.getName(),
                newPlaylist.getSongList()

        )).build();
    }


    public PlaylistResource(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
}
