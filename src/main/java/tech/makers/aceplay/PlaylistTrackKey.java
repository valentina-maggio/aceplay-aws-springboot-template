package tech.makers.aceplay;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PlaylistTrackKey implements Serializable {

  @Column(name = "playlist_id")
  Long playlistId;

  @Column(name = "track_id")
  Long trackId;

  public PlaylistTrackKey(Long playlistId, Long trackId) {
    this.playlistId = playlistId;
    this.trackId = trackId;
  }

  public Long getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(Long playlistId) {
    this.playlistId = playlistId;
  }

  public Long getTrackId() {
    return trackId;
  }

  public void setTrackId(Long trackId) {
    this.trackId = trackId;
  }

}