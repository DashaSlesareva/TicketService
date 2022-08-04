package ru.netology.domain;

public class TicketRepo {

    private Ticket[] ticket = new Ticket[0];

    //добавление нового билета
    public void add(Ticket newTicket) {
        Ticket[] tmp = new Ticket[ticket.length + 1];
        for (int i = 0; i < ticket.length; i++) {
            tmp[i] = ticket[i];
        }
        tmp[tmp.length - 1] = newTicket;
        ticket = tmp;
    }

    //врзвращение массива всех билетов
    public Ticket[] findAll() {
        return ticket;
    }

    //удаляет билет по id
    public void removeById(int id) {
        Ticket[] tmp = new Ticket[ticket.length - 1];
        int index = 0;
        for (Ticket ticket1 : ticket) {
            if (ticket1.getId() != id) {
                tmp[index] = ticket1;
                index++;
            }
        }
        ticket = tmp;
    }
}
