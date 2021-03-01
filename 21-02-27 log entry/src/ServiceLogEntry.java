import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

public class ServiceLogEntry {

    public Map<String, Long> numberOfSessionsUrl(List<LogEntry> logEntryList) {
        return logEntryList.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl,
                        Collectors.counting()));
    }

    public Map<String, Integer> numberOfUniqueUsers(List<LogEntry> logEntryList) {
        return logEntryList.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl,
                        mapping(LogEntry::getLogin,
                        Collectors.collectingAndThen(toSet(), Set::size))));
    }
}
