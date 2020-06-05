package com.vishvam.KaiburrRestSwagger.KaiburrRestApplication.controller;
import com.vishvam.KaiburrRestSwagger.KaiburrRestApplication.model.Server;
import com.vishvam.KaiburrRestSwagger.KaiburrRestApplication.service.ServerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
@RequestMapping("rest/user/")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Server> getServerById(@PathVariable("id") String id){
        System.out.println("Fetching by id");
        Optional<Server> s = serverService.findById(id);
        return s.map(server -> new ResponseEntity<>(server, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Server>> getServerByName(@PathVariable("name") String name){
        System.out.println("Fetching by name");
        List<Server> servers = serverService.findByName(name);
        if(!servers.isEmpty()){
            return new ResponseEntity<>(servers, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<Server>> getServers(){
        System.out.println("Fetching all servers");
        List<Server> s = serverService.findAll();
        if(!s.isEmpty()){
            return new ResponseEntity<>(s,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<String> putServer(@RequestBody Server server){
        serverService.save(server);
        return new ResponseEntity<>("Saved",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServer(@PathVariable("id") String id){
        if(serverService.findById(id).isPresent()){
            serverService.deleteById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }

        return new ResponseEntity<>("Id not found: "+id,HttpStatus.NOT_FOUND);
    }

}
