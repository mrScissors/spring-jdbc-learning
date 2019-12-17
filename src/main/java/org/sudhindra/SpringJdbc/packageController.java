package org.sudhindra.SpringJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class packageController {
    @Autowired
    private eventDao eventDao1;

    @GetMapping("home")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<event> listEvent = eventDao1.list();
//            model.addAttribute("name","hello");
        model.addObject("listEvent", listEvent);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/addForm", method = RequestMethod.GET)
    public ModelAndView showForm(ModelMap model) {
//        model.addAttribute("eventType1", "Cricket");
//        model.addAttribute("eventType2", "Football");
//        model.addAttribute("eventType3", "Badminton");
        return new ModelAndView("addForm", "event", new event());
    }



    @RequestMapping(value = "/newEvent", method = RequestMethod.POST)
    public ModelAndView newContact(ModelMap model, @ModelAttribute("event")event event1) {
        eventDao1.saveOrUpdate(event1);
        model.addAttribute("eventTitle", event1.getEventTitle());
        model.addAttribute("city", event1.getCity());
        model.addAttribute("ticketPrice", event1.getTicketPrice());
        model.addAttribute("eventType", event1.getEventType());
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute event event1) {
        eventDao1.saveOrUpdate(event1);
        return new ModelAndView("redirect:/home");
    }

    @RequestMapping(value = "/deleteEvent/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable int id) {
        //int eventId = Integer.parseInt(request.getParameter("id"));
        eventDao1.delete(id);
        return ("redirect:/home");
    }

    @RequestMapping(value = "/editEvent", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int eventId = Integer.parseInt(request.getParameter("id"));
        event event1 = eventDao1.get(eventId);
        ModelAndView model = new ModelAndView("eventForm");
        model.addObject("event", eventId);

        return model;
    }
}
