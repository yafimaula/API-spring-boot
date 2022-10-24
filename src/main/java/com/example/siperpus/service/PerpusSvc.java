package com.example.siperpus.service;

import com.example.siperpus.form.PerpusForm;
import com.example.siperpus.model.PerpusModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PerpusSvc {
    PerpusModel create(PerpusForm form);

    List<PerpusModel> getAll();

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> updateById(PerpusForm form, Long id);

    ResponseEntity<Object> deleteById(Long id);
}
