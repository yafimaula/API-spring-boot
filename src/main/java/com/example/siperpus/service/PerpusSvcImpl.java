package com.example.siperpus.service;

import com.example.siperpus.common.ResponseUtil;
import com.example.siperpus.constant.MessageConstant;
import com.example.siperpus.form.PerpusForm;
import com.example.siperpus.model.PerpusModel;
import com.example.siperpus.repository.PerpusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerpusSvcImpl implements PerpusSvc{

    @Autowired
    private PerpusRepository perpusRepo;

    @Override
    public PerpusModel create(PerpusForm form){
        return perpusRepo.save(perpus(form));
    }

    @Override
    public List<PerpusModel> getAll() {
        return perpusRepo.findAll();
    }


    @Override
    public ResponseEntity<Object> findById(Long id) {
        try {
            Optional<PerpusModel> getById = perpusRepo.findById(id);
            return getById.map(perpusModel -> ResponseUtil.build(MessageConstant.SUCCESS, perpusModel, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(PerpusForm form, Long id) {
        try {
            Optional<PerpusModel> getById = perpusRepo.findById(id);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            PerpusModel perpus = getById.get();
            perpus.setJudul(form.getJudul());
            perpus.setKategori(form.getKategori());
            perpus.setPenerbit(form.getPenerbit());
            perpus.setPengarang(form.getPengarang());
            perpus.setTahun(form.getTahun());
            perpusRepo.save(perpus);
            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, perpusRepo.save(perpus), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id) {
        try {
            Optional<PerpusModel> data = perpusRepo.findById(id);
            if (!data.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            perpusRepo.deleteOne(true, data.get().getId());
//            perpusRepo.deleteById(id);
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, null, HttpStatus.OK);
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private PerpusModel perpus(PerpusForm form){
        PerpusModel perpus = new PerpusModel();
        perpus.setJudul(form.getJudul());
        perpus.setKategori(form.getJudul());
        perpus.setPenerbit(form.getPenerbit());
        perpus.setPengarang(form.getPengarang());
        perpus.setTahun(form.getTahun());

        return perpus;
    }
}
