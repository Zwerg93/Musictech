package at.ac.htl.leonding.api;

import at.ac.htl.leonding.workloads.song.Song;
import at.ac.htl.leonding.workloads.song.SongRepo;
import at.ac.htl.leonding.youtubeAPI.DownloadAPI;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;

@Produces("application/json")
@Path("youtube")
@Consumes("application/json")
public class YoutubeResource {
    private String postURL = "";
    private static final String DEVELOPER_KEY = "AIzaSyDDd_3IHYSGqMpzuybFRnirJrVeRIl4i5Y";

    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    @Inject
    SongRepo repo;

    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    @GET
    @Path("/download/{searchstring}")
    public Response getAllSongs(@PathParam("searchstring") String searchstring) throws GeneralSecurityException, IOException {
        DownloadAPI downloadAPI = new DownloadAPI();
        getYoutubeVideoIdsByString(searchstring);
        return Response.ok().build();
    }

    public void getYoutubeVideoIdsByString(String searchstring) throws GeneralSecurityException, IOException {
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Search.List request = youtubeService.search()
                .list("snippet");
        SearchListResponse response = request.setKey(DEVELOPER_KEY)
                .setMaxResults(10L)     // why not working?
                .setQ(searchstring)
                .execute();


        System.out.println(response);

        for (int i = 0; i < response.size() - 1; i++) {
            System.out.println(response.getItems().get(i).getId().get("kind"));
            if (response.getItems().get(i).getId().get("kind").equals("youtube#video")) {
                download((String) response.getItems().get(i).getId().get("videoId"), (String) response.getItems().get(i).getSnippet().get("title"));
            } else {
                System.out.println("you cant download a Youtube Channel :)");
            }
            //System.out.println();
        }

    }

    @Transactional
    public void download(String id, String title) {
        StringBuffer sbf1 = new StringBuffer();
        final HttpClient httpClient = new DefaultHttpClient();
        final HttpGet httpGet = new HttpGet("https://api.vevioz.com/api/button/mp3/" + id);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException ex) {
            System.out.println("erreor " + ex);
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            System.out.println("error " + ex);
        }
        String line = "";
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException ex) {
                System.out.println("error " + ex);
            }

            sbf1.append(line);

        }

        URL website = null;
        try {
            website = new URL(sbf1.substring(sbf1.indexOf(id) - 35, sbf1.indexOf(id) + 97));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        ReadableByteChannel rbc = null;
        try {
            rbc = Channels.newChannel(website.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/home/marcel/musictech/files/" + title + ".mp3");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            // postURL = "/api/uploadFile/download/" + title;
            postURL = "http://localhost:8080/uploadFile/download/" + title + ".mp3";

            System.out.println(postURL);
            Song song = new Song(title, postURL);

            repo.addSong(song);

            System.out.println(song);

            //repo.addSong(song);
            System.out.println("Donwload succes " + title);
            //  return song;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
