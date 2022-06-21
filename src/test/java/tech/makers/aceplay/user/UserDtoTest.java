package tech.makers.aceplay.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDtoTest {
  @Test
  void testConstructs() {
    UserDto subject = new UserDto("test user", "test password");
    assertEquals("test user", subject.getUsername());
    assertEquals("test password", subject.getPassword());
  }
}
