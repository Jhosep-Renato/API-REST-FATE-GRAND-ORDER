package com.japrova.fategrandorder.restcontroller;

import com.japrova.fategrandorder.entity.Servant;
import com.japrova.fategrandorder.service.ServantServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServantRestController {

    private final ServantServiceImpl servantService;

    public ServantRestController(ServantServiceImpl servantService) {
        this.servantService = servantService;
    }

    @GetMapping("/servants")
    public List<Servant> findAll() {

        return servantService.findAll();
    }

    @GetMapping("/servant/{name}")
    public Servant findName(@PathVariable String name) {

        return servantService.findByName(name);
    }
}