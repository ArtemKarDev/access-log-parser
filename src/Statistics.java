import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

public class Statistics {
    long totalTraffic;
    LocalDateTime minTime;
    LocalDateTime maxTime;
    long countRequests;
    HashSet<String> websitePagesURL;
    HashSet<String> websiteNoPagesURL;
    HashMap<String,Integer> visitorsOS;
    HashMap<String,Integer> visitorsBrowser;

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

        String browser = logEntry.getUserAgent().browserName;
        if (visitorsBrowser.containsKey(browser)){
            visitorsBrowser.put(browser,visitorsBrowser.get(browser)+1);
        } else {
            visitorsBrowser.put(browser,1);
        }

    }

    public HashMap<String, Double> getStatisticsVisitorsOs(){
        HashMap<String, Double> statOS = new HashMap<>();
        long sumAllOS = 0;
        for (int value : this.visitorsOS.values()) {
            sumAllOS += value;
        }
        for (var entry : this.visitorsOS.entrySet()) {
            double precent = getPrecentage(entry.getValue(), sumAllOS);
            statOS.put(entry.getKey(),precent);
        }
        if (statOS == null){statOS.put("unknown", 1.0);}
    return statOS;
    }

    public HashMap<String, Double> getStatisticsVisitorsBrowser(){
        HashMap<String, Double> statBrowser = new HashMap<>();
        long sumAllBrowser = 0;
        for (int value : this.visitorsBrowser.values()) {
            sumAllBrowser += value;
        }
        for (var entry : this.visitorsBrowser.entrySet()) {
            double precent = getPrecentage(entry.getValue(), sumAllBrowser);
            statBrowser.put(entry.getKey(),precent);
        }
        if (statBrowser == null){statBrowser.put("unknown", 1.0);}
        return statBrowser;
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

    public HashSet<String> getWebsitePagesURL() {
        return websitePagesURL;
    }
    public HashSet<String> getWebsiteNoPagesURL() {
        return websiteNoPagesURL;
    }

    public double getPrecentage(long score, long total){
        return (double) (score * 100/ total);
    }

    @Override
    public String toString(){
        return "Средний трафик в час: " + getTrafficRateByte() + " байт. (" + (int)getTrafficRateByte()/1024/1024+ " Мбайт)";
    }

    public void printStatisticsUrl() {
        System.out.println("\nВсего уникальных URL-адресов: " + getWebsitePagesURL().size());
        System.out.println("\nВсего запрошенных не существующих URL-адресов: " + getWebsiteNoPagesURL().size());
    }

    public void printStatisticsOS() {
        System.out.println("\nСтатистика по ОС:");
        for (String os : visitorsOS.keySet()) {
            System.out.println("OS: " + os + ", запросов: " + visitorsOS.get(os)+ ", доля : " + getStatisticsVisitorsOs().get(os));
        }
    }

    public void printStatisticsBrowser() {
        System.out.println("\nСтатистика по браузерам:");
        for (String browser : visitorsBrowser.keySet()) {
            System.out.println("Browser: " + browser + ", запросов: " + visitorsBrowser.get(browser)+ ", доля : " + getStatisticsVisitorsBrowser().get(browser));
        }
    }

}
