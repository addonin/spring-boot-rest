package com.epam.springadvanced.controller;

import com.epam.springadvanced.domain.entity.Event;
import com.epam.springadvanced.domain.entity.User;
import com.epam.springadvanced.service.EventService;
import com.epam.springadvanced.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author dmytro_adonin
 * @since 3/23/2016.
 */
@RestController
@RequestMapping("/uploads")
public class UploadController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUploadsPage() {
        return new ModelAndView("uploads");
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void uploadUsersFileAndShowUsersPage(@RequestBody List<User> users)
            throws IOException {
        users.stream().forEach(userService::register);
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void uploadEventsFileAndShowEventsPage(@RequestBody List<Event> events)
            throws IOException {
        events.stream().forEach(event ->
                eventService.create(event.getName(), event.getDateTime(), event.getTicketPrice(), event.getRating()));
    }

}
