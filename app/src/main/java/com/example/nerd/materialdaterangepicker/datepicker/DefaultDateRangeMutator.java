package com.example.nerd.materialdaterangepicker.datepicker;

import com.example.nerd.materialdaterangepicker.util.CalendarUtils;

import java.util.Calendar;

public class DefaultDateRangeMutator implements DateRangeView.DateRangeMutator {
    @Override
    public void mutateRangeWithDay(DateRange dateRange, Calendar day) {
        if (CalendarUtils.isSameDay(day, dateRange.getFrom())) {
            dateRange.setTo(dateRange.getFrom());
        }
        else if (CalendarUtils.isSameDay(day, dateRange.getTo())) {
            dateRange.setFrom(dateRange.getTo());
        }
        else {
            long fromDiff = Math.abs(day.getTimeInMillis() - dateRange.getFrom().getTimeInMillis());
            long toDiff = Math.abs(day.getTimeInMillis() - dateRange.getTo().getTimeInMillis());
            if (fromDiff < toDiff) {
                dateRange.setFrom(day);
            }
            else {
                dateRange.setTo(day);
            }
        }
    }
}
