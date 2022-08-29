package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    Ticket ticket1 = new Ticket(101, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(102, 2199, "KZN", "SVO", 95);
    Ticket ticket3 = new Ticket(103, 35299, "MDE", "ICN", 830);
    Ticket ticket4 = new Ticket(104, 1000, "SVO", "KZN", 100);
    Ticket ticket5 = new Ticket(105, 3299, "SVO", "KZN", 75);

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
    public void repoRemoveByIdTest() {
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
    public void ticketComareToTest() {
        assertEquals(ticket1.compareTo(ticket2), -1);
        assertEquals(ticket3.compareTo(ticket2), 1);
        assertEquals(ticket1.compareTo(ticket1), 0);
    }

    //Тестирую менеждер
    //Тестрирую метод поиска, когда находится несколько товаров
    @Test
    public void managerFindSeveralTicketsTest() {
        TicketRepo repo = new TicketRepo();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Ticket[] actual = manager.findAll("SVO", "KZN");
        Ticket[] expected = {ticket4, ticket1, ticket5};
        assertArrayEquals(actual, expected);
    }

    //Тестрирую метод поиска, когда находится один товар
    @Test
    public void managerFindSingleTicketTest() {
        TicketRepo repo = new TicketRepo();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Ticket[] actual = manager.findAll("MDE", "ICN");
        Ticket[] expected = {ticket3};
        assertArrayEquals(actual, expected);
    }

    //Тестрирую метод поиска, когда находится 0 товаров
    @Test
    public void managerFindZeroTicketsTest() {
        TicketRepo repo = new TicketRepo();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Ticket[] actual = manager.findAll("MDE", "KZN");
        Ticket[] expected = {};
        assertArrayEquals(actual, expected);
    }


}
