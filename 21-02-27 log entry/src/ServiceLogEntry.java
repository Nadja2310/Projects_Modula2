import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServiceLogEntry {

    public Map<String, Long> numberOfSessionsUrl(List<LogEntry> logEntryList) {
        return logEntryList.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl,
                        Collectors.counting()));
    }

    public Map<String, Map<String, Long>> numberOfUniqueUsers(List<LogEntry> logEntryList) {
        return logEntryList.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl,
                        Collectors.groupingBy(LogEntry::getLogin,
                                Collectors.counting())));
    }
}
