package tech.makers.aceplay.playlist;

import com.fasterxml.jackson.annotation.JsonGetter;
import tech.makers.aceplay.track.Track;
import tech.makers.aceplay.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import tech.makers.aceplay.playlisttracks.PlaylistTracks;
import java.util.Collections;
import java.util.List;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=448s
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty(message = "Name may not be empty")
  private String name;

  private Boolean cool;

  @OneToMany(mappedBy = "playlist")
  @OrderBy(value = "dateAdded")
  private List<PlaylistTracks> tracks;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  public void setUser(User user) {
    this.user = user;
  }

  public Playlist() {
  }

  public Playlist(@NotEmpty String name) {
    this(name, false);
  }

  public Playlist(@NotEmpty String name, Boolean isCool) {
    this(name, isCool, null);
  }

  public Playlist(@NotEmpty String name, Boolean isCool, List<PlaylistTracks> tracks) {
    this.name = name;
    this.tracks = tracks;
    this.cool = isCool;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getCool() {
    return cool;
  }

  public Long getId() {
    return id;
  }

  @JsonGetter("tracks")
  public List<PlaylistTracks> getTracks() {
    if (null == tracks) {
      return List.of();
    }
    return tracks;
  }

  @Override
  public String toString() {
    return String.format("Playlist[id=%d name='%s' cool='%s']", id, name, cool);
  }
}
