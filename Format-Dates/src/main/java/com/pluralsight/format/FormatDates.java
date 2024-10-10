package com.pluralsight.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDates {

        public static void main(String[] args) {
            // Current date and time
            LocalDateTime current = LocalDateTime.now();

            // MM/dd/yyyy
            DateTimeFormatter slashFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String format1 = current.format(slashFormat);

            // yyyy-MM-dd
            DateTimeFormatter dashFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String format2 = current.format(dashFormat);

            // MMMM d, yyyy
            DateTimeFormatter spaceFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            String format3 = current.format(spaceFormat);

            // EEEE, MMM d, yyyy HH:mm
            DateTimeFormatter commaFormat = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
            String format4 = current.format(commaFormat);

            // Print
            System.out.println(format1);
            System.out.println(format2);
            System.out.println(format3);
            System.out.println(format4);
        }
}
