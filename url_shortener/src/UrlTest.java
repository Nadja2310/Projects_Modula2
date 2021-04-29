import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlTest {
    Url urlShortener=new Url();
    @Test
    public void shortUrlToId_test(){
        String res = urlShortener.get_shortURL("https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html");
        assertEquals("bxcDY298", res);
    }

    @Test
    public void shortUrl_test_shorInputAddress(){
        String res = urlShortener.get_shortURL("do.de\345");
        assertEquals("2UMRZskU", res);

    }
}