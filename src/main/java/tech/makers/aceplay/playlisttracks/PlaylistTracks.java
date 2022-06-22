package tech.makers.aceplay.playlisttracks;

import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tech.makers.aceplay.playlist.Playlist;
import tech.makers.aceplay.track.Track;

@Entity
public class PlaylistTracks implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "playlist_id")
  private Playlist playlist;

  @ManyToOne
  @JoinColumn(name = "track_id")
  private Track track;

  @Column(name = "date_added")
  private LocalDateTime dateAdded;

  public PlaylistTracks() {
  }

  public PlaylistTracks(Playlist playlist, Track track) {
    this.playlist = playlist;
    this.track = track;
    this.dateAdded = LocalDateTime.now(Clock.systemUTC());
  }

  public Track getTrack() {
    return track;
  }

  public LocalDateTime getDateAdded() {
    return dateAdded;
  }
}