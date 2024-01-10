public class DurationFormatter {

    private static final int SECONDS_IN_A_MINUTE = 60;
    private static final int SECONDS_IN_AN_HOUR = 3600;
    private static final int SECONDS_IN_A_DAY = 86400;
    private static final int SECONDS_IN_A_YEAR = 31536000;

    private static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        int years = seconds / SECONDS_IN_A_YEAR;
        seconds %= SECONDS_IN_A_YEAR;

        int days = seconds / SECONDS_IN_A_DAY;
        seconds %= SECONDS_IN_A_DAY;

        int hours = seconds / SECONDS_IN_AN_HOUR;
        seconds %= SECONDS_IN_AN_HOUR;

        int minutes = seconds / SECONDS_IN_A_MINUTE;
        seconds %= SECONDS_IN_A_MINUTE;

        return buildDateFormatValue(years, days, hours, minutes, seconds);
    }

    private static String buildDateFormatValue(int years, int days, int hours, int minutes, int seconds) {
        StringBuilder sb = new StringBuilder();

        if (years > 0) {
            sb.append(years).append(" year").append(years > 1 ? "s" : "");
        }

        appendTime(sb, days, "day");
        appendTime(sb, hours, "hour");
        appendTime(sb, minutes, "minute");
        appendTime(sb, seconds, "second");

        return sb.toString().replaceAll(", $", "").replaceAll(", ([^,]+)$", " and $1");
    }

    private static void appendTime(StringBuilder sb, int time, String unit) {
        if (time > 0) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(time).append(" ").append(unit).append(time > 1 ? "s" : "");
        }
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(62));         // "1 minute and 2 seconds"
        System.out.println(formatDuration(3662));       // "1 hour, 1 minute and 2 seconds"
        System.out.println(formatDuration(0));          // "now"
    }
}
