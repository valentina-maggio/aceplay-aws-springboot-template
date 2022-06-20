package tech.makers.aceplay.track;

import org.junit.jupiter.api.Test;
import tech.makers.aceplay.track.Track;
import java.util.Set;
import java.net.MalformedURLException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.youtube.com/watch?v=L4vkcgRnw2g&t=798s
class TrackTest {
  @Test
  void testConstructs() throws MalformedURLException {
    Track subject = new Track("Hello, world!", "Sarah", "https://example.org/track.mp3");
    assertEquals("Hello, world!", subject.getTitle());
    assertEquals("Sarah", subject.getArtist());
    assertEquals("https://example.org/track.mp3", subject.getPublicUrl().toString());
    assertEquals(null, subject.getId());
  }

  @Test
  void testToString() throws MalformedURLException {
    Track subject = new Track("Hello, world!", "Sarah", "https://example.org/track.mp3");
    assertEquals(
        "Track[id=null title='Hello, world!' artist='Sarah' publicUrl='https://example.org/track.mp3']",
        subject.toString());
  }

  @Test
  void testSetPublicUrl() throws MalformedURLException {
    Track subject = new Track();
    subject.setPublicUrl("https://example.org/track.mp3");
    assertEquals("https://example.org/track.mp3", subject.getPublicUrl().toString());
  }

  @Test
  void testEmptyTrackTitle() throws MalformedURLException {
    Track subject = new Track("", "TestArtist", "https://example.com");
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Track>> violations = validator.validate(subject);
    assertEquals(1, violations.size());

  }

  @Test
  void testEmptyArtist() throws MalformedURLException {
    Track subject = new Track("TestTitle", "", "https://example.com");
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<Track>> violations = validator.validate(subject);
    assertEquals(1, violations.size());

  }
}