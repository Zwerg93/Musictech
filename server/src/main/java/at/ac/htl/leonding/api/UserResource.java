package at.ac.htl.leonding.api;

import at.ac.htl.leonding.models.UserDOT;
import at.ac.htl.leonding.workloads.playlist.Playlist;
import at.ac.htl.leonding.workloads.playlist.PlaylistRepo;
import at.ac.htl.leonding.workloads.song.SongRepo;
import at.ac.htl.leonding.workloads.user.User;
import at.ac.htl.leonding.workloads.user.UserRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Produces("application/json")
@Path("user")
@Consumes("application/json")
public class UserResource {

    @Inject
    UserRepo repouser;
    @Inject
    PlaylistRepo playlistRepo;
    @Inject
    SongRepo songRepo;

    @POST
    @Transactional
    public Response addUser(UserDOT newUser) {
        User user = new User(newUser.getUsername(), newUser.getName(), newUser.getLastname(), newUser.getEmail(), newUser.getPassword());
        repouser.persist(user);

        return Response.ok(user).build();
    }

    @POST
    @Transactional
    @Path("add/{id}")
    public Response addPlaylist(@PathParam("id") Long id, String name) {

        User user = this.repouser.findById(id);

        Playlist playlist = new Playlist(name);

        this.playlistRepo.persist(playlist);
        System.out.println(user.toString());


        this.repouser.addPlaylist(user,playlist);




        System.out.println(user.playlistList.size() + " test");


        return Response.ok().build();
    }


    @GET
    @Path("all")
    public Response getallUser() {
        var allUser = repouser.listAll();
        return Response.ok(allUser).build();
    }

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") Long id) {
        User user = repouser.findById(id);
        return (user == null
                ? Response.status(404)
                : Response.ok(user))
                .build();
    }

    @POST
    @Path("autorize/{username}/{value}")
    public Response login(@PathParam("value") String password,
                          @PathParam("username") String username) {
        //repo.getPassword(username);
        System.out.println(repouser.getPassword(username) + " " + password);

        if (repouser.getPassword(username).equals(password)) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }


    }

}
