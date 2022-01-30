package de.vitale.texthonorar.rechner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextHonorarRechnerTest {
    private String INPUT_STRING = "blab la blab la bla picture. Bla bla picture blab la blab la blab la bla.";
    @Test
    public void Test_MainProgram() {
        //normal flow of program
        TextHonorarRechner textHonorarRechner = new TextHonorarRechner();
        textHonorarRechner.calculateRoyalty(INPUT_STRING);
    }


    //Test case for empty string
    @Test
    public void testInputStringLength_zero() {
        TextHonorarRechner textHonorarRechner = new TextHonorarRechner();
        String input = "";
        String result = textHonorarRechner.calculateRoyalty(input);
        Assertions.assertEquals("$0", result);
    }

    // Test case spaces as string
    @Test
    public void testInputStringLength_Spaces() {
        TextHonorarRechner textHonorarRechner = new TextHonorarRechner();
        String input = "  "  ;
        String result = textHonorarRechner.calculateRoyalty(input);
        Assertions.assertEquals("$0", result);
    }

    //Test case for success string
    @Test
    public void testInputSuccess() {
        TextHonorarRechner textHonorarRechner = new TextHonorarRechner();
        String result = textHonorarRechner.calculateRoyalty(INPUT_STRING);
        Assertions.assertEquals("$5.8", result);
    }

    //Test case for throwing exception if string is null.
    @Test
    public void testInputStringNull() {
        TextHonorarRechner textHonorarRechner = new TextHonorarRechner();
        String input = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            textHonorarRechner.calculateRoyalty(input);
        });
    }

    //Test case for cheating case
    @Test
    public void testInputStringCheating() {
        TextHonorarRechner textHonorarRechner = new TextHonorarRechner();
        String input = "Hello how are you? Hello how are you? Hello how are you?"  ;
        String result = textHonorarRechner.calculateRoyalty(input);
        Assertions.assertEquals("$0", result);
    }
}
