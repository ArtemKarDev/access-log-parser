import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogEntry {
    private String ipAddress; //— IP-адрес клиента.
//    private String dateTime; //— дата и время запроса.
//    private String httpMethod; //— HTTP-метод (GET, POST и т.д.).
//    private String requestPath; //— запрошенный путь.
//    private int responseCode; //— код ответа сервера.
//    private int responseSize; //— размер отданных данных.
//    private String referer; //— путь к странице, с которой пришёл запрос.
    private UserAgent userAgent; //— информация о браузере или клиенте.

    public LogEntry(String ipAddress){
        this.ipAddress = ipAddress;
    }
    public LogEntry(String ipAddress, UserAgent userAgent){
        this(ipAddress);
        this.userAgent = userAgent;
    }

    @Override
    public String toString(){
        return String.format("IP: %s | User-Agent: %s", ipAddress, userAgent);
    }

    public String getUserAgentName(){
        return userAgent != null ? userAgent.agentName : "unknown";
    }
    public Object getEntry(String fieldName){
        switch (fieldName.toLowerCase()){
            case "ipaddress" : return ipAddress;
            case "useragent" : return userAgent;
            default: throw new IllegalArgumentException("Поле с именем "+ fieldName + " не найдено!");
        }
    }

    public static LogEntry parse(String logLine){
        try {
            String[] parts = logLine.split(" ");
            String ipAddress = parts[0];

            Pattern pattern = Pattern.compile("\"([^\"]*)\""); //Pattern для поиска подстрок в кавычках
            Matcher matcher = pattern.matcher(logLine);
            String lastQuotedSubstring = null;
            while (matcher.find()) {
                lastQuotedSubstring = matcher.group(1);
            }
            if (lastQuotedSubstring != null) {
                UserAgent userAgent = UserAgent.parse(lastQuotedSubstring);
                return new LogEntry(ipAddress, userAgent);
            } else {
                return new LogEntry(ipAddress);
            }

        } catch (Exception e){
            throw new IllegalArgumentException("Некорректный формат строки лога: " + logLine, e);
        }

    }

    public static class UserAgent{
        String agentType;
        String agentName;

        public UserAgent(String agentType,String agentName){
            this.agentType = agentType;
            this.agentName = agentName;
        }

        public static UserAgent parse(String userAgentString){
            String agentType = "unknown";
            String agentName = "unknown";

            List<String> substringsInBrackets = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\(([^)]+)\\)");//Pattern для поиска подстрок в скобках
            Matcher matcher = pattern.matcher(userAgentString);

            while (matcher.find()) {
                substringsInBrackets.add(matcher.group(1));
            }

            for (String substring : substringsInBrackets) {
                if (substring.toLowerCase().contains("bot")){
                    agentType = "Bot";
                    String[] parts = substring.split(";");
                    if (parts.length >= 2) {
                        String fragment = parts[1].replace(" ","");
                        agentName = fragment.substring(0,fragment.indexOf("/"));
                    }
                }
            }

        return new UserAgent(agentType,agentName);
        }
        @Override
        public String toString(){
            return String.format("Type: %s, Name: %s", agentType, agentName);
        }

    }
}
