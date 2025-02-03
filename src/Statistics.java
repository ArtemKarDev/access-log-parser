import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

public class Statistics {
    long totalTraffic;
    LocalDateTime minTime;
    LocalDateTime maxTime;
    long countRequests;
    HashSet<String> websitePages;
    HashMap<String,Integer> visitorsOS;

    public Statistics(){
        this.websitePages = new HashSet<>();
        this.visitorsOS = new HashMap<>();
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
        if (logEntry.getResponseCode() == 200) {
            websitePages.add(logEntry.getRequestPath());
        }
        String os = logEntry.getUserAgent().osType;

        if (visitorsOS.containsKey(os)){
            visitorsOS.put(os,visitorsOS.get(os)+1);
        } else {
            visitorsOS.put(os,1);
        }
    }

    public HashMap<String, Double> getStatisticsVisitorsOs(){
        HashMap<String, Double> statOS = new HashMap<>();
        long sumAllOS = 0;
        for (int value : this.visitorsOS.values()) {
            sumAllOS += value;
        }
        for (var entry : this.visitorsOS.entrySet()) {
            //System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
            double precent = getPrecentage(entry.getValue(), sumAllOS);
            statOS.put(entry.getKey(),precent);
        }
        if (statOS == null){statOS.put("unknown", 1.0);}
    return statOS;
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
        return websitePages;
    }

    public double getPrecentage(long score, long total){
        return (double) (score * 100/ total);
    }

    @Override
    public String toString(){
        return "Средний трафик в час: " + getTrafficRateByte() + " байт. (" + (int)getTrafficRateByte()/1024/1024+ " Мбайт)";
    }

    public void printStatisticsOS() {
        System.out.println("\nВсего уникальных URL-адресов: " + getWebsitePagesURL().size());
        System.out.println("\nСтатистика по ОС:");
        for (String os : visitorsOS.keySet()) {
            System.out.println("OS: " + os + ", запросов: " + visitorsOS.get(os)+ ", доля : " + getStatisticsVisitorsOs().get(os));
        }
    }
}
