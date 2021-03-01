import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ServiceLogEntryTest {
    ServiceLogEntry serviceLogEntry = new ServiceLogEntry();

    @Test
    public void numberOfSessionsUrl() {
        LogEntry user1 = new LogEntry("user1", "url1");
        LogEntry user2 = new LogEntry("user2", "url1");
        LogEntry user3 = new LogEntry("user3", "url2");
        LogEntry user1_2 = new LogEntry("user1", "url3");
        Map<String, Long> res = serviceLogEntry.numberOfSessionsUrl(Arrays.asList(user1, user2, user1_2, user3));
        assertEquals(2, res.get("url1"));
        assertEquals(1, res.get("url2"));
        assertEquals(1, res.get("url3"));
    }

    @Test
    public void numberOfUniqueUsers() {
        LogEntry user1 = new LogEntry("user1", "url1");
        LogEntry user1_2 = new LogEntry("user1", "url1");
        LogEntry user1_url2 = new LogEntry("user1", "url2");
        LogEntry user2 = new LogEntry("user2", "url2");
        LogEntry user2_1 = new LogEntry("user2", "url2");
        LogEntry user3 = new LogEntry("user3", "url2");
        LogEntry user4 = new LogEntry("user4", "url3");
        Map<String, Integer> res = serviceLogEntry.numberOfUniqueUsers(
                Arrays.asList(user1, user2, user1_2, user3, user1_url2, user4, user2_1));
        assertEquals(1, res.get("url1"));
        assertEquals(3, res.get("url2"));
        assertEquals(1, res.get("url3"));
    }
}