package org.todoList.objects;

import java.util.HashMap;

public class Status implements Comparable<Status> {
    public static final String TODO = "To do";
    public static final String DOING = "Doing";
    public static final String DONE = "Done";

    private String statusTarefa;

    public Status(String status) {
        this.statusTarefa = "Not set";
        String[] flavors = {TODO, DOING, DONE};
        for (String flavor : flavors) {
            if (flavor.equalsIgnoreCase(status)) {
                this.statusTarefa = flavor;
            }
        }
    }

    public String getTodo(){
        return TextColor.ANSI_RED + TODO + TextColor.ANSI_RESET;
    }

    public String getDoing(){
        return TextColor.ANSI_YELLOW + DOING + TextColor.ANSI_RESET;
    }

    public String getDone(){
        return TextColor.ANSI_GREEN + DONE + TextColor.ANSI_RESET;
    }

    public Status(){

    }

    public String getStatusTarefa() {
        if (statusTarefa.equals(TODO)) {
            return this.getTodo();
        }else if(statusTarefa.equals(DOING)) {
            return this.getDoing();
        }
        return this.getDone();
    }

    @Override
    public int compareTo(Status otherStatus){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("TODO", 2);
        map.put("DOING", 1);
        map.put("DONE", 0);

        int myStatusNumber = map.get(this.statusTarefa);
        int otherStatusNumber = map.get(otherStatus.getStatusTarefa());

        return Integer.compare(myStatusNumber, otherStatusNumber);
    }
}
