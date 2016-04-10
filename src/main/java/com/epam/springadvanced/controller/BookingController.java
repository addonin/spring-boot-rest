package com.epam.springadvanced.controller;

import com.epam.springadvanced.domain.entity.Ticket;
import com.epam.springadvanced.service.BookingService;
import com.epam.springadvanced.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author dmytro_adonin
 * @since 3/22/2016.
 */
@RestController
@RequestMapping({"/booking"})
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/free-tickets/{eventId}", method = RequestMethod.GET)
    public Collection<Ticket> getFreeTickets(@PathVariable("eventId") long eventId) {
        return bookingService.getFreeTickets(eventId);
    }

    /*@RequestMapping(value = "/booked-tickets", params = "eventId", method = RequestMethod.GET)
    public ModelAndView getBookedTickets(@RequestParam("eventId") long eventId, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("/booked-tickets");
        model.addAttribute("tickets", bookingService.getBookedTickets(eventId));
        return modelAndView;
    }

    @RequestMapping(value = "/tickets", params = {"eventId", "ticketId"}, method = RequestMethod.GET)
    public ModelAndView getTicket(@RequestParam("ticketId") Integer ticketId,
                                  Principal principal) throws EventNotAssignedException {
        ModelAndView modelAndView = new ModelAndView("/ticket");
        Ticket ticket = bookingService.getTicket(ticketId);
        Event event = ticket.getEvent();
        ticket.setPrice(bookingService.getTicketPrice(
                event, event.getDateTime(),
                    Collections.singletonList(ticket.getSeat().getNumber()),
                        userService.getUserByEmail(principal.getName())));
        modelAndView.addObject("ticket", ticket);
        return modelAndView;
    }

    @RequestMapping(value = "/tickets", params = "ticketId", method = RequestMethod.POST)
    public String createEvent(@RequestParam("ticketId") long ticketId,
                              Principal principal)
            throws TicketAlreadyBookedException, TicketWithoutEventException, EventNotAssignedException {
        User user = userService.getUserByEmail(principal.getName());
        Ticket ticket = bookingService.getTicket(ticketId);
        Event event = ticket.getEvent();
        List<Integer> seatNumbers = Collections.singletonList(ticket.getSeat().getNumber());
        float price = bookingService.getTicketPrice(event, event.getDateTime(), seatNumbers, user);
        bookingService.bookTicket(user, ticket, price);
        return "redirect:/events";
    }*/

}


