import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogEntry {
    private final String ipAddress; //— IP-адрес клиента.
    private final LocalDateTime dateTime; //— дата и время запроса.
    private final HttpMethod httpMethod; //— HTTP-метод (GET, POST и т.д.).
    private final String requestPath; //— запрошенный путь.
    private final int responseCode; //— код ответа сервера.
    private final int bytesTransferred; //— размер отданных данных.
    private final String referer; //— путь к странице, с которой пришёл запрос.
    private final UserAgent userAgent; //— информация о браузере или клиенте.


    public LogEntry(String logLine) throws Exception {

        String logEntryPattern = "^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}) (\\d+) \"([^\"]+)\" \"([^\"]+)\"";
        int NUM_FIELDS = 9;
        Pattern LOG_PATTERN = Pattern.compile(logEntryPattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

        Matcher matcher = LOG_PATTERN.matcher(logLine);
        if (!matcher.matches() || NUM_FIELDS != matcher.groupCount()) {
            throw new Exception("Problem with Expression Parsing");
        }
        this.ipAddress = matcher.group(1);
        dateTime = LocalDateTime.parse(matcher.group(4), formatter);
        String requestLine = matcher.group(5);
        String[] requestParts = requestLine.split(" ");
        this.httpMethod = HttpMethod.valueOf(requestParts[0].toUpperCase());
        this.requestPath = requestParts[1];
        this.responseCode = Integer.parseInt(matcher.group(6));
        this.bytesTransferred = Integer.parseInt(matcher.group(7));
        this.referer = matcher.group(8);
        if (!matcher.group(9).equals("-")) {
            String userAgentString = matcher.group(9);
            this.userAgent = parseUserAgent(userAgentString);
        } else {
            this.userAgent = new UserAgent("none", "none");
        }

    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getBytesTransferred() {
        return bytesTransferred;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }


    @Override
    public String toString() {
        return "LogParser{" +
                "ipAddress='" + ipAddress + '\'' +
                ", date='" + dateTime + '\'' +
                ", method='" + httpMethod + '\'' +
                ", url='" + requestPath + '\'' +
                ", statusCode=" + responseCode +
                ", bytesSent=" + bytesTransferred +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }


    public static class UserAgent {
        String botName;
        String osType;
        String browserName;

        public UserAgent(String browserName, String osType) {
            this.browserName = browserName;
            this.osType = osType;
        }

        public UserAgent(String browserName, String osType, String botName) {
            this.browserName = browserName;
            this.osType = osType;
            this.botName = botName;
        }

        public String getName() {
            return browserName;
        }

        public String getType() {
            return osType;
        }

        @Override
        public String toString() {
            return String.format("UserAgent name: %s, type: %s, bot: %s", browserName, osType, botName);
        }

    }

    public UserAgent parseUserAgent(String userAgentString) {

        String botName;
        String browserName;
        String osType;

        browserName = extractBrowserName(userAgentString);
        osType = extractOsType(userAgentString);
        if (userAgentString.toLowerCase().contains("compatible")) {
            browserName = "compatible";
            botName = extractBotName(userAgentString);
        } else {
            botName = null;
        }
        return new UserAgent(browserName, osType, botName);
    }

    private static String extractBotName(String userAgentString) {
        String botName = "unknown";
        List<String> substringsInBrackets = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\(([^)]+)\\)");//Pattern для поиска подстрок в скобках
        Matcher matcher = pattern.matcher(userAgentString);
        while (matcher.find()) {
            substringsInBrackets.add(matcher.group(1));
        }
        for (String substring : substringsInBrackets) {
            if (substring.toLowerCase().contains("compatible")) {
                String[] parts = substring.split(";");
                if (parts.length >= 2) {
                    String fragment = parts[1].replace(" ", "");
                    botName = fragment.substring(0, fragment.indexOf("/"));
                }
            }
        }
        return botName;
    }

    private static String extractBrowserName(String userAgentString) {
        String[] browsers = {"Chrome", "Firefox", "Safari", "Edge", "Opera", "Internet Explorer"};
        for (String browser : browsers) {
            if (userAgentString.contains(browser)) {
                return browser;
            }
        }
        return "Unknown Browser";
    }

    private static String extractOsType(String userAgentString) {
        // Примерный паттерн для извлечения типа ОС
        if (userAgentString.contains("Windows")) {
            return "Windows";
        } else if (userAgentString.contains("Linux")) {
            return "Linux";
        } else if (userAgentString.contains("Android")) {
            return "Android";
        } else if (userAgentString.contains("Mac OS")) {
            return "Mac OS";
        } else {
            return "Unknown OS";
        }
    }


    enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    }

}
