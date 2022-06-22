package tech.makers.aceplay.track;

import tech.makers.aceplay.user.User;
import javax.persistence.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

import tech.makers.aceplay.playlisttracks.PlaylistTracks;

// https://www.youtube.com/watch?v=5r3QU09v7ig&t=2999s
@Entity
public class Track {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty(message = "Title may not be empty")
  private String title;

  @NotEmpty(message = "Artist may not be empty")
  private String artist;

  private URL publicUrl;

  @OneToMany(mappedBy = "track")
  private Set<PlaylistTracks> playlists;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  public Track() {
  }

  public Track(@NotEmpty String title, @NotEmpty String artist, URL publicUrl) {
    this.title = title;
    this.artist = artist;
    this.publicUrl = publicUrl;
  }

  public Track(@NotEmpty String title, @NotEmpty String artist, String publicUrl) throws MalformedURLException {
    this(title, artist, new URL(publicUrl));
  }

  public String toString() {
    return String.format(
        "Track[id=%d title='%s' artist='%s' publicUrl='%s']", id, title, artist, publicUrl);
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public URL getPublicUrl() {
    return publicUrl;
  }

  public void setPublicUrl(String publicUrl) throws MalformedURLException {
    this.publicUrl = new URL(publicUrl);
  }

  public void setPublicUrl(URL publicUrl) {
    this.publicUrl = publicUrl;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
