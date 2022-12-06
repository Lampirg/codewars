public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        final int maxValue = 359999;
        final int minValue = 0;
        if (seconds > maxValue || seconds < minValue)
            throw new java.lang.IllegalArgumentException("illegal number");
        final int secondsPerMinute = 60;
        int minutes = Math.floorDiv(seconds, secondsPerMinute);
        seconds -= minutes * secondsPerMinute;
        final int minutesPerHour = 60;
        int hours = Math.floorDiv(minutes, minutesPerHour);
        minutes -= hours * minutesPerHour;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}