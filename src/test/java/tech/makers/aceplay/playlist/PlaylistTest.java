package tech.makers.aceplay.playlist;

import org.junit.jupiter.api.Test;
import tech.makers.aceplay.playlist.Playlist;
import tech.makers.aceplay.track.Track;
import tech.makers.aceplay.track.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// https://www.youtube.com/watch?v=L4vkcgRnw2g&t=1099s
class PlaylistTest {

  // @Autowired
  // private TrackRepository trackRepository;

  @Test
  void testConstructs() {
    Playlist subject = new Playlist("Hello, world!", false, Set.of());
    assertEquals("Hello, world!", subject.getName());
    assertEquals(false, subject.getCool());
    assertEquals(Set.of(), subject.getTracks());
    assertEquals(null, subject.getId());
  }

  @Test
  void testToString() {
    Playlist subject = new Playlist("Hello, world!", true);
    assertEquals(
        "Playlist[id=null name='Hello, world!' cool='true']",
        subject.toString());
  }

  @Test
  public void whenEmptyName_thenOneConstraintViolation() {
    Playlist subject = new Playlist("", false, Set.of());
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Playlist>> violations = validator.validate(subject);

    assertEquals(1, violations.size());
  }

  // @Test
  // public void returnsPlaylistTracksByLastTrackAdded() throws
  // MalformedURLException {

  // Track track1 = new Track("Title1", "Artist1", "https://example.org/");
  // Track track2 = new Track("Title2", "Artist2", "https://example.org/");
  // Track track3 = new Track("Title3", "Artist3", "https://example.org/");

  // Playlist subject = new Playlist("Hello, world!", false, Set.of(track1,
  // track2, track3));

  // assertEquals(3, subject.getTracks().size());
  // assertEquals(track1, subject.getTracks().iterator().next());
  // assertEquals(track2, subject.getTracks().iterator().next());
  // assertEquals(track3, subject.getTracks().iterator().next());
  // }
}