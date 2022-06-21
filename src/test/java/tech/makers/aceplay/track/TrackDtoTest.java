package tech.makers.aceplay.track;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;

class TrackDtoTest {
  @Test
  void testConstructs() throws MalformedURLException {
    TrackDto subject = new TrackDto("Hello, world!", "Sarah", "https://example.org/track.mp3");
    assertEquals("Hello, world!", subject.getTitle());
    assertEquals("Sarah", subject.getArtist());
    assertEquals("https://example.org/track.mp3", subject.getPublicUrl().toString());
  }
}