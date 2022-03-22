package ru.telda.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.telda.demo.entity.Region;
import ru.telda.demo.serivce.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/region/")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping("{id}")
    public Region getById(@PathVariable Long id) {
        return regionService.getById(id);
    }

    @GetMapping("{name}/byName")
    public Region getByName(@PathVariable String name) {
        return regionService.getByName(name);
    }

    @GetMapping("{nameSimple}/byNameSimple")
    public List<Region> getByNameSimple(@PathVariable String nameSimple) {
        return regionService.getByNameSimple(nameSimple);
    }

    @PostMapping
    public Region create(@RequestBody Region region) {
        return regionService.createAndGet(region);
    }

    @PutMapping
    public Region update(@RequestBody Region region) {
        return regionService.updateAndGet(region);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        regionService.delete(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Region region) {
        regionService.delete(region);
    }
}
