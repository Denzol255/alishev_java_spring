package ru.denzol.springproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.denzol.springproject.dao.PersonDAO;

@Controller
@RequestMapping("/batch")
public class BatchController {
    private final PersonDAO personDAO;

    @Autowired
    public BatchController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index() {
        return "batch/index";
    }

    @GetMapping("batchInsert")
    public String batchInsert() {
        personDAO.batchInsert();
        return "redirect:/people";
    }
}
