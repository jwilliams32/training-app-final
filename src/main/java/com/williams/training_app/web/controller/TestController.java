package com.williams.training_app.web.controller;

import com.williams.training_app.web.model.Test;
import com.williams.training_app.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
public class TestController {
    @Autowired

    private TestDao testDao;

    @RequestMapping("test")
    public String index(Model model){
        model.addAttribute("tests", testDao.findAll());
        model.addAttribute("title", "Tests");


        return "test/index";

    }

    @RequestMapping(value="test/add", method = RequestMethod.GET)
    public String addTestForm(Model model){
        model.addAttribute("title", "Add Test");
        model.addAttribute(new Test());

        return "test/add";
    }

    @RequestMapping(value = "test/add", method = RequestMethod.POST)
    public String processAddTestForm(@ModelAttribute @Valid Test newTest,
                                     Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Test");
            return "test/add";
        }

        testDao.save(newTest);

        return "redirect:/test";

    }

    @RequestMapping(value = "test/edit/{testId}", method = RequestMethod.GET)
    public String displayEditTestForm(Model model, @PathVariable Integer testId){

        model.addAttribute("test", testDao.findOne(testId));

        return "test/edit";
    }

    @RequestMapping(value = "test/edit/{testId}", method = RequestMethod.POST)
    public String processEditTestForm(Integer testId, String name, String description, String instruction){

        Test newTest = testDao.findOne(testId);
        newTest.setName(name);
        newTest.setDescription(description);
        newTest.setInstruction(instruction);
        testDao.save(newTest);

        return "redirect:/test";
    }

    @RequestMapping(value = "test/remove", method = RequestMethod.GET)
    public String displayRemoveTestForm(Model model){
        model.addAttribute("tests", testDao.findAll());
        model.addAttribute("title", "Delete Test");
        return "test/remove";

    }
    @RequestMapping(value = "test/remove", method = RequestMethod.POST)
    public String processRemoveTestForm(@RequestParam int [] testIds){

        for (int testId : testIds){
            testDao.delete(testId);
        }

        return "redirect:/test";
    }

    @RequestMapping(value = "test/view/{testId}", method = RequestMethod.GET)
    public String viewSingleTest(Model model, @PathVariable int testId){
        Test test = testDao.findOne(testId);
        model.addAttribute("title", test.getName());
        model.addAttribute("description", test.getDescription());
        model.addAttribute("instruction", test.getInstruction());

        return "test/view";
    }

}
