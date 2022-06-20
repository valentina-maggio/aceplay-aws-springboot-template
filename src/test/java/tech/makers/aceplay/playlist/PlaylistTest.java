package tech.makers.aceplay.playlist;

import org.junit.jupiter.api.Test;
import tech.makers.aceplay.playlist.Playlist;

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
}
