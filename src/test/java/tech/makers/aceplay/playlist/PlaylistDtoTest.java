package tech.makers.aceplay.playlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// https://www.youtube.com/watch?v=L4vkcgRnw2g&t=1139s
class PlaylistDtoTest {
  @Test
  void testConstructs() {
    PlaylistDto subject = new PlaylistDto("Vale's running bangers", true);
    assertEquals("Vale's running bangers", subject.getName());
    assertEquals(true, subject.getCool());
  }
}
