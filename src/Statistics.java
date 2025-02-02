import java.time.Duration;
import java.time.LocalDateTime;

public class Statistics {

    static long totalTraffic;
    static LocalDateTime minTime;
    static LocalDateTime maxTime;
    static long countRequests;

    public Statistics(){
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
        if (this.getMinTime() == null){return 0;}
        Duration duration = Duration.between(this.getMinTime(),this.getMaxTime());
        long durationInHours = duration.toHours();
        if (durationInHours==0){durationInHours=1;}
        return this.getTotalTraffic()/durationInHours;
    }

//    public double getStatisticBot(){
//        double precentYandexBot = 0;
//        double precentGooglebot = 0;
//        if (countRequests > 0) {
//            precentYandexBot = getPrecentage(yandexBotCount, countLines);
//            precentGooglebot = getPrecentage(googleBotCount, countLines);
//        }
//        return
//    }
//
//    public static double getPrecentage(int score, int total){
//        return (double) (score * 100/ total);
//    }
    public String toString(){
        return "Средний трафик в час: " + getTrafficRateByte() + " байт.  (" + (int)getTrafficRateByte()/1024/1024+ " Мбайт)";
    }

}
