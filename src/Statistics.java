import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class Statistics {
    long countRequests;
    long totalTraffic;
    long countUserAgentNotBot;
    long countErrorRequest;
    LocalDateTime minTime;
    LocalDateTime maxTime;
    HashSet<String> websitePagesURL;
    HashSet<String> websiteNoPagesURL;
    HashMap<String,Integer> visitorsOS;
    HashMap<String,Integer> visitorsBrowser;
    HashMap<String,Integer> visitorsIpNotBot;

    HashMap<Integer,Integer> visitsPerSeconds;

    public Statistics(){
        this.websitePagesURL = new HashSet<>();
        this.websiteNoPagesURL = new HashSet<>();
        this.visitorsOS = new HashMap<>();
        this.visitorsBrowser = new HashMap<>();
        this.visitorsIpNotBot = new HashMap<>();
        this.visitsPerSeconds = new HashMap<>();
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

        if(!logEntry.isBot()){
            countUserAgentNotBot += 1;
            addItemInHashMap(visitorsIpNotBot,logEntry.getIpAddress());
            int seconds = (int) logEntry.getDateTime().toInstant(ZoneOffset.ofHours(3)).getEpochSecond();
            addItemInHashMap(visitsPerSeconds, seconds);
        }
        countErrorRequest += logEntry.getResponseCode() >= 400 ? 1 : 0;
        addItemInHashMap(visitorsOS,logEntry.getUserAgent().browserName);
        addItemInHashMap(visitorsBrowser,logEntry.getUserAgent().getName());
    }

    private <K,V extends Number> void addItemInHashMap(HashMap<K,Integer> data, K increment){
        data.put(increment, data.getOrDefault(increment,0)+1);
    }
    private void addItemInHashMap3(HashMap<String,Integer> data, String item){
        data.put(item, data.getOrDefault(item,0)+1);
    }

    public HashMap<String, Double> getStatisticsVisitorOs(){
        return calculateStatistic(visitorsOS);
    }
    public HashMap<String, Double> getStatisticsVisitorBrowser(){
        return calculateStatistic(visitorsBrowser);
    }
    public String getSecondWithPeakVisitors(){
        int secondWithMaxVisitors = visitsPerSeconds.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return Instant.ofEpochSecond(secondWithMaxVisitors).atZone(ZoneId.of("Europe/Moscow")).format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
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
    public double getAvgAttendance(){
        int totalCountVisitNotBot = visitorsIpNotBot.values().stream().reduce(0, Integer::sum);
        return (double) (totalCountVisitNotBot/visitorsIpNotBot.size());
    }
    public double getTrafficRateBytePerHour(){
        return getTotalTraffic()/getDuration();
    }
    public double avgErrorRequestPerHour(){
        return (double) countErrorRequest/getDuration();
    }

    public double avgVisitorsPerHour(){
        return (double) countUserAgentNotBot/getDuration();
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
        return "Средний трафик в час: " + getTrafficRateBytePerHour() + " байт. (" + (int) getTrafficRateBytePerHour()/1024/1024+ " Мбайт)";
    }

    public void printStatisticsUrl() {
        System.out.println("\nВсего уникальных URL-адресов: " + getWebsitePagesURL().size());
        System.out.println("\nВсего запрошенных несуществующих URL-адресов: " + getWebsiteNoPagesURL().size());
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
