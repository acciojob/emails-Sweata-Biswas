package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.*;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
    super(emailId,Integer.MAX_VALUE);
     this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
            calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        Collections.sort(calendar,(o1, o2) -> {
            return o1.getStartTime() == o2.getStartTime() ? o1.getStartTime().compareTo(o2.getStartTime()) : o1.getEndTime().compareTo(o2.getEndTime());
        });
//        Queue<LocalTime> addTime = new LinkedList<>();
           int maxMeeting = 1;
            for(int i = 0; i< calendar.size()-1 ;i++) {
//                System.out.println("start  : " + calendar.get(i).getStartTime());
//                System.out.println("End  :" + calendar.get(i).getEndTime());

//                for (int j = i+1; j < calendar.size() - 1; j++) {
                    Meeting index_i = calendar.get(i);
                    Meeting index_next = calendar.get(i+1);
                    int startval = index_next.getStartTime().compareTo(index_i.getEndTime());
//                int endval = index_i.getEndTime().compareTo(index_next.getEndTime());
//                    System.out.println("Startval  " + startval);
//                System.out.println("endval  "+ endval);
                    if (startval < 0)
                        maxMeeting++;
                }
//            }
            return maxMeeting;


    }
}
