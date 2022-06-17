package tech.makers.aceplay.playlist;

import com.fasterxml.jackson.annotation.JsonGetter;
import tech.makers.aceplay.track.Track;
import tech.makers.aceplay.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=448s
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @NotEmpty(message = "Name may not be empty")
  private String name;

  private Boolean cool;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Track> tracks;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  public Playlist() {
  }

  public Playlist(@NotEmpty String name) {
    this(name, false);
  }

  public Playlist(@NotEmpty String name, Boolean isCool) {
    this(name, isCool, null);
  }

  public Playlist(@NotEmpty String name, Boolean isCool, Set<Track> tracks) {
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
  public Set<Track> getTracks() {
    if (null == tracks) {
      return Set.of();
    }
    return tracks;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return String.format("Playlist[id=%d name='%s' cool='%s']", id, name, cool);
  }
}
