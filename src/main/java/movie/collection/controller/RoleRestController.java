package movie.collection.controller;


import jakarta.validation.Valid;

import movie.collection.dto.RoleDTO;
import movie.collection.entity.Actor;
import movie.collection.entity.Movie;
import movie.collection.entity.Role;
import movie.collection.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {
    @Autowired
    private RoleService service;

    @GetMapping("")
    public List<RoleDTO> getAllRoles(){
        List<Role> roles = service.getAll();

        List<RoleDTO> roleDTO = roles.stream().map(RoleDTO::new).toList();

        return roleDTO;
    }

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable("id") int id){
        Role role = service.get(id);

        return new RoleDTO(role);
    }

    @PostMapping("")
    public void addNewRole(@RequestBody @Valid Role role){
        Actor actor = role.getActor();
        actor.getRoles().add(role);

        Movie movie = role.getMovie();
        movie.getRoles().add(role);

        service.save(role);
    }

    @PutMapping("")
    public void updateRole(@RequestBody @Valid Role role){
        service.save(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id")int id){
        Role role = service.get(id);

        role.getActor().getRoles().remove(role);
        role.getMovie().getRoles().remove(role);

        service.delete(id);
    }
}
