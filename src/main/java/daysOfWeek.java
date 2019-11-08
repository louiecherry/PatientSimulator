public class daysOfWeek {
    static String[] daysOfWeek = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};

    public static String getDayOfWeek(int d, int m, int y)
    {
        // Check if the month is January or February
        // If the month is January or February, convert to 13 or 14
        // and reduce the year by one (go to previous year).
        if (m == 1 || m == 2) {
            m += 12;
            y--;
        }
        int h = (d + (int)((26 * (m + 1)) / 10.0) + y + (int)(y / 4.0) +
                6 * (int)(y / 100.0) + (int)(y / 400.0)) % 7;
        return daysOfWeek[h];
    }
}
