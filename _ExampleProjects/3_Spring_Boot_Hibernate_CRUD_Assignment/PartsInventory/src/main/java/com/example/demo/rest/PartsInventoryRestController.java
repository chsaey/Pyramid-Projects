package com.example.demo.rest;


import com.example.demo.dao.DAO;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PartsInventoryRestController {

    private final DAO Dao;

    @Autowired
    public PartsInventoryRestController(DAO dao) {
        this.Dao = dao;
    }

    @GetMapping("/getAll/{table}")
    public List<Object> findAll(@PathVariable String table) {
        return Dao.findAll("from " + table);
    }


    @PostMapping("/add/CPU")
    public CPU addCPU(@RequestBody CPU cpu) {
        cpu.setId(0);
        Dao.save(cpu);
        return cpu;
    }

    @PostMapping("/add/GPU")
    public GPU addGPU(@RequestBody GPU gpu) {
        gpu.setId(0);
        Dao.save(gpu);
        return gpu;
    }

    @PostMapping("/add/Motherboard")
    public Motherboard addMotherboard(@RequestBody Motherboard motherboard) {
        motherboard.setId(0);
        Dao.save(motherboard);
        return motherboard;
    }

    @PostMapping("/add/RAM")
    public RAM addRAM(@RequestBody RAM ram) {
        ram.setId(0);
        Dao.save(ram);
        return ram;
    }

    @PutMapping("/update/CPU")
    public CPU updateCPU(@RequestBody CPU cpu) {
        Dao.save(cpu);
        return cpu;
    }

    @PutMapping("/update/GPU")
    public GPU updateCPU(@RequestBody GPU gpu) {
        Dao.save(gpu);
        return gpu;
    }

    @PutMapping("/update/Motherboard")
    public Motherboard updateCPU(@RequestBody Motherboard motherboard) {
        Dao.save(motherboard);
        return motherboard;
    }

    @PutMapping("/update/RAM")
    public RAM updateCPU(@RequestBody RAM ram) {
        Dao.save(ram);
        return ram;
    }

    //@GetMapping("/deletePart/{table}/{id}") -> can open in webpage
    @DeleteMapping("/deletePart/{table}/{id}")
    public String deleteCPU(@PathVariable String table, @PathVariable int id) {
        Dao.deleteById(table, id);
        return "Part deleted";
    }


}
