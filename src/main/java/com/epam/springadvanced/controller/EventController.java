package com.epam.springadvanced.controller;

import com.epam.springadvanced.domain.entity.Auditorium;
import com.epam.springadvanced.domain.entity.Event;
import com.epam.springadvanced.service.EventService;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @author dmytro_adonin
 * @since 3/22/2016.
 */
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private List<Auditorium> auditoriums;

    @Autowired
    private EventService eventService;

    @Autowired
    private PropertyEditorRegistrar customPropertyEditorRegistrar;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        customPropertyEditorRegistrar.registerCustomEditors(binder);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Event> getEventsPage() {
        return eventService.getAll();
    }

    /*@RequestMapping(value= "/create-form", method=RequestMethod.GET)
    public ModelAndView createEventForm(ModelMap model) {
        model.addAttribute(new Event());
        model.addAttribute("rating", Rating.values());
        model.addAttribute("auditorium", auditoriums);
        return new ModelAndView("event-form", model);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createEvent(@ModelAttribute("event") Event event,
                              //@ModelAttribute("rating") Rating rating,
                              //@ModelAttribute("dateTime") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateTime,
                              BindingResult bindingResult) throws AuditoriumAlreadyAssignedException {
        eventService.create(event.getName(), event.getDateTime(), event.getTicketPrice(), event.getRating());
        return "redirect:/events";
    }

    @RequestMapping(value = "/auditorium", params = {"eventId"}, method = RequestMethod.GET)
    public ModelAndView assignEventAuditoriumForm(@RequestParam("eventId") Integer eventId, ModelMap model) {
        model.addAttribute("event", eventService.getById(eventId));
        model.addAttribute("auditoriums", auditoriums);
        return new ModelAndView("event-auditorium", model);
    }

    @RequestMapping(value = "/auditorium", method = RequestMethod.POST)
    public String assignEventAuditorium(@ModelAttribute("event") Event event,
                                        @RequestParam("auditorium") Integer auditoriumId)
            throws AuditoriumAlreadyAssignedException {
        eventService.assignAuditorium(
                eventService.getById(event.getId()),
                    auditoriums.stream().filter(current -> current.getId() == auditoriumId).findFirst().get(),
                        event.getDateTime());
        return "redirect:/events";
    }*/

}
