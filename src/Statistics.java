import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

public class Statistics {
    long totalTraffic;
    LocalDateTime minTime;
    LocalDateTime maxTime;
    long countRequests;
    HashSet<String> websitePagesURL;
    HashSet<String> websiteNoPagesURL;
    HashMap<String,Integer> visitorsOS;
    HashMap<String,Integer> visitorsBrowser;
    long countUserAgentNotBot;

    public Statistics(){
        this.websitePagesURL = new HashSet<>();
        this.websiteNoPagesURL = new HashSet<>();
        this.visitorsOS = new HashMap<>();
        this.visitorsBrowser = new HashMap<>();
    }

    public void addEntry(LogEntry logEntry){
        totalTraffic += logEntry.getBytesTransferred();
        countRequests += 1;
        LocalDateTime currentTime = logEntry.getDateTime();
        if (minTime == null || minTime.isAfter(currentTime)){
            minTime = currentTime;
        }
        if (maxTime == null || maxTime.isBefore(currentTime)){
            maxTime = currentTime;
        }

        int statusCode = logEntry.getResponseCode();
        String url = logEntry.getRequestPath();
        if (statusCode == 200) {
            websitePagesURL.add(url);
        } else if (statusCode == 404) {
            websiteNoPagesURL.add(url);
        }

        String os = logEntry.getUserAgent().osType;
        if (visitorsOS.containsKey(os)){
            visitorsOS.put(os,visitorsOS.get(os)+1);
        } else {
            visitorsOS.put(os,1);
        }
        //countUserAgentNotBot =0;
        countUserAgentNotBot += logEntry.getUserAgent().botName.equals("none") ? 1 : 0;

        String browser = logEntry.getUserAgent().browserName;
        if (visitorsBrowser.containsKey(browser)){
            visitorsBrowser.put(browser,visitorsBrowser.get(browser)+1);
        } else {
            visitorsBrowser.put(browser,1);
        }

    }
    public HashMap<String, Double> getStatisticsVisitorOs(){
        return calculateStatistic(visitorsOS);
    }
    public HashMap<String, Double> getStatisticsVisitorBrowser(){
        return calculateStatistic(visitorsBrowser);
    }

    private static HashMap<String, Double> calculateStatistic(HashMap<String,Integer> data){
        HashMap<String,Double> statistics = new HashMap<>();
        long totalVisitors = data.values().stream().mapToLong(Integer::intValue).sum();
        if (totalVisitors == 0) {
            statistics.put("unknown",1.0);
            return statistics;
        }
        for (var entry : data.entrySet()){
            double percentage = getPercentage(entry.getValue() ,totalVisitors);
            statistics.put(entry.getKey(), percentage);
        }
        return statistics;
    }

    private LocalDateTime getMinTime(){
        return minTime;
    }
    private LocalDateTime getMaxTime(){
        return maxTime;
    }
    public double getTotalTraffic(){
        return totalTraffic;
    }
    public long getCountRequests(){
        return countRequests;
    }
    public double getTrafficRateByte(){
        if (getMinTime() == null){return 0;}
        Duration duration = Duration.between(getMinTime(),getMaxTime());
        long durationInHours = duration.toHours();
        if (durationInHours==0){durationInHours=1;}
        return getTotalTraffic()/durationInHours;
    }

    public double avgVisitorsForHour(){
        long duration = getDuration();
        return (double) countUserAgentNotBot/duration;
    }
    private Long getDuration(){
        if (getMinTime() == null){return 0L;}
        Duration duration = Duration.between(getMinTime(),getMaxTime());
        long durationInHours = duration.toHours();
        if (durationInHours==0){durationInHours=1;}
        return durationInHours;
    }
    public HashSet<String> getWebsitePagesURL() {
        return websitePagesURL;
    }
    public HashSet<String> getWebsiteNoPagesURL() {
        return websiteNoPagesURL;
    }

    private static double getPercentage(long score, long total){
        return (double) (score * 100/ total);
    }

    @Override
    public String toString(){           //TODO передалеть вывод статистики по трафику
        return "Средний трафик в час: " + getTrafficRateByte() + " байт. (" + (int)getTrafficRateByte()/1024/1024+ " Мбайт)";
    }

    public void printStatisticsUrl() {
        System.out.println("\nВсего уникальных URL-адресов: " + getWebsitePagesURL().size());
        System.out.println("\nВсего запрошенных не существующих URL-адресов: " + getWebsiteNoPagesURL().size());
    }

    private static void printStatistics(HashMap<String,Double> statistics, String str) {
        statistics.forEach((key, value) -> System.out.println(str + key + ", Доля: " + value));
    }

    public void printStatisticsOS() {
        printStatistics(getStatisticsVisitorOs(),"Статистика по ОС: ");
    }

    public void printStatisticsBrowser() {
        printStatistics(getStatisticsVisitorBrowser(),"Статистика по браузеру: ");
    }

}
