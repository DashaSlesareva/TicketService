package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    Ticket ticket1 = new Ticket(101, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(102, 2199, "KZN", "SVO", 95);
    Ticket ticket3 = new Ticket(103, 35299, "MDE", "ICN", 830);

    //тестирую репозиторий

    @Test
    public void repoAddAndFindAllTest() {
        TicketRepo repo = new TicketRepo();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void repoRemoveByIdTest(){
        TicketRepo repo = new TicketRepo();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.removeById(102);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket3};
        assertArrayEquals(actual, expected);
    }

    //тестирую CompareTo
    @Test
    public void ticketComareToTest(){
        assertEquals(ticket1.compareTo(ticket2), -1);
        assertEquals(ticket3.compareTo(ticket2), 1);
        assertEquals(ticket1.compareTo(ticket1), 0);
    }



}
