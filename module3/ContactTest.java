

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; 
 
public class ContactTest { 

  private Contact contactAda;
  private Contact contactAlan;

  @BeforeEach
  void setUp() {
    contactAda = new Contact("Ada Lovelace", "+1 617 555 0101");
  }
 
  @Test 
  void constructor_setsNameCorrectly() { 
    assertEquals("Ada Lovelace", contactAda.getName());
  } 
 
  @Test
  void constructor_setsPhoneCorrectly() { 
    assertEquals("+1 617 555 0101", contactAda.getPhone());
  } 
 
  @Test
  void getName_returnsExactString_notTransformed() { 
    Contact c = new Contact("Grace Hopper", "555-0000"); 
    assertEquals("Grace Hopper", c.getName());
  } 
 
  @Test
  void toString_containsName() { 
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("Alan Turing"));
  } 
 
  @Test
  void toString_containsPhone() {
    Contact c = new Contact("Alan Turing", "555-0001");
    assertTrue(c.toString().contains("555-0001"));
  }

  @Test
  void contactsWithSameName_areIndependent() {
    Contact contactAlan1 = new Contact("Alan Turing", "+1 617 555 0001");
    Contact contactAlan2 = new Contact("Alan Turing", "+1 617 555 0002");

    contactAlan1.setPhone("+1 617 555 0000");

    assertEquals("+1 617 555 0000", contactAlan1.getPhone());
    assertEquals("+1 617 555 0002", contactAlan2.getPhone());
  }
} 