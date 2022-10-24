package com.example.siperpus.controller;

import com.example.siperpus.form.PerpusForm;
import com.example.siperpus.model.PerpusModel;
import com.example.siperpus.service.PerpusSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/si_perpus")
public class PerpusController {
    private final PerpusSvc perpusSvc;

    @Autowired
    public PerpusController(PerpusSvc perpusSvc){
        this.perpusSvc = perpusSvc;
    }

    @PostMapping
    public PerpusModel create(@RequestBody PerpusForm form){
        return perpusSvc.create(form);
    }

    @GetMapping
    public List<PerpusModel> getAll(){
        return perpusSvc.getAll();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return perpusSvc.findById(id);
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<Object> update(@RequestBody PerpusForm form, @PathVariable Long id){
        return perpusSvc.updateById(form, id);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return perpusSvc.deleteById(id);
    }
}
