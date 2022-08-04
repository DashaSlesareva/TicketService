package ru.netology.domain;

import java.util.Arrays;

public class TicketManager {
    private TicketRepo repo;

    public TicketManager(TicketRepo repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getDepartureAirport().equals(from) && ticket.getArrivalAirport().equals(to)) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }


}
