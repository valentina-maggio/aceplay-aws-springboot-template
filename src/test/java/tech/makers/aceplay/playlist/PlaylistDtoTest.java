package tech.makers.aceplay.playlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistDtoTest {
  @Test
  void testConstructs() {
    PlaylistDto subject = new PlaylistDto("Vale's running bangers", true);
    assertEquals("Vale's running bangers", subject.getName());
    assertEquals(true, subject.getCool());
  }
}
