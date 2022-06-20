package tech.makers.aceplay.trackaddedtime;

import javax.persistence.*;
import tech.makers.aceplay.playlist.Playlist;
import tech.makers.aceplay.track.Track;
import tech.makers.aceplay.PlaylistTrackKey;

@Entity
public class TrackAddedTime {
  @EmbeddedId
  PlaylistTrackKey id;

  @ManyToOne
  @MapsId("playlistId")
  @JoinColumn(name = "playlist_id")
  Playlist playlist;

  @ManyToOne
  @MapsId("trackId")
  @JoinColumn(name = "track_id")
  Track track;

  long time;

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public Track getTrack() {
    return track;
  }

  public void setTrack(Track track) {
    this.track = track;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }
}