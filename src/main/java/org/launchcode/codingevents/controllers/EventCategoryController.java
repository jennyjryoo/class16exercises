package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    private String displayAllEvents(Model model) {
        model.addAttribute("title","All Categories");
        model.addAttribute("categories",eventCategoryRepository.findAll();
        return "eventCategories/index";
    }

    @GetMapping("create")
    private String renderCreateEventCategoryForm(Model model, EventCategory newEventCategory) {
        model.addAttribute("title","Create Category");
        model.addAttribute(new EventCategory());
        return "eventCategories/create";
    }

    @PostMapping("create")
    private String processCreateEventCategoryForm (Model model, EventCategory newEventCategory, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title","Create Category");
            model.addAttribute(new EventCategory());
            return "eventCategories/create";
        }

        model.addAttribute("title","Create Category");
        eventCategoryRepository.save(newEventCategory);
        return "redirect:";
    }
}
