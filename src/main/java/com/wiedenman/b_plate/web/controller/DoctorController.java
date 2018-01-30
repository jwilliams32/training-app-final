package com.wiedenman.b_plate.web.controller;

import com.wiedenman.b_plate.web.model.Doctor;
import com.wiedenman.b_plate.dao.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;

    @RequestMapping(value = "doctor")
    public String index(Model model) {

        model.addAttribute("doctors", doctorDao.findAll());
        model.addAttribute("title", "Current Doctors");

        return "doctor/index";

    }

    @RequestMapping(value = "doctor/add", method = RequestMethod.GET)
    public String displayAddDoctorForm(Model model) {
        model.addAttribute("title", "Add New Doctor");
        model.addAttribute(new Doctor());
//        model.addAttribute("clinic", clinicDao.findAll());
        return "doctor/add";
    }

    @RequestMapping(value = "doctor/add", method = RequestMethod.POST)
    public String processAddDoctorForm(@ModelAttribute @Valid Doctor newDoctor,final BindingResult result,
                                       Errors errors, Model model, Principal principal) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Doctor");
            return "doctor/add";
        }
        doctorDao.save(newDoctor);

        return "redirect:/doctor";

    }

    @RequestMapping(value = "doctor/edit/{doctorId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable Integer doctorId){

        model.addAttribute("doctor", doctorDao.findOne(doctorId));

        return "doctor/edit";
    }

    @RequestMapping(value = "doctor/edit/{doctorId}", method = RequestMethod.POST)
    public String processEditForm(Integer doctorId, String name, String clinic, String description){

        Doctor newDoctor = doctorDao.findOne(doctorId);
        newDoctor.setName(name);
        newDoctor.setClinic(clinic);
        newDoctor.setDescription(description);
        doctorDao.save(newDoctor);

        return "redirect:/doctor";
    }

    @RequestMapping(value = "doctor/remove", method = RequestMethod.GET)
    public String displayRemoveForm(Model model){
        model.addAttribute("doctors", doctorDao.findAll());
        model.addAttribute("title", "Delete Doctor");
        return "doctor/remove";

    }
    @RequestMapping(value = "doctor/remove", method = RequestMethod.POST)
    public String processRemoveDoctorForm(@RequestParam int [] doctorIds){

        for (int doctorId : doctorIds){
            doctorDao.delete(doctorId);
        }

        return "redirect:/doctor";
    }

    @RequestMapping(value = "doctor/view/{doctorId}", method = RequestMethod.GET)
    public String viewSingleDoctor(Model model, @PathVariable int doctorId){
        Doctor doctor = doctorDao.findOne(doctorId);
        model.addAttribute("title", doctor.getName());
        model.addAttribute("clinic", doctor.getClinic());
        model.addAttribute("instruction", doctor.getDescription());

        return "doctor/view";
    }
}