package it.unibo.sap.ass02.demo.controller;

import it.unibo.sap.ass02.demo.domain.EBikeImpl;
import it.unibo.sap.ass02.demo.repositories.EBikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RequestMapping("/ebike")
public class EBikeController {
    private final EBikeRepository repository;
    public EBikeController(final EBikeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public Iterable<EBikeImpl> getAllEBikes() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EBikeImpl> getEBikeByID(@PathVariable String id) {
        if (Objects.nonNull(id)) {
            return this.repository.findById(id);
        }
        return Optional.empty();
    }

    @PostMapping("/create")
    public EBikeImpl postEBike(@RequestBody EBikeImpl ebike) {
        return this.repository.save(ebike);
    }

    @PutMapping("{id}")
    public ResponseEntity<EBikeImpl> putEBike(final @PathVariable String id, final @RequestBody EBikeImpl ebike) {
        return this.repository.existsById(id) ?
                new ResponseEntity<EBikeImpl>(this.repository.save(ebike), HttpStatus.OK) :
                new ResponseEntity<EBikeImpl>(this.postEBike(ebike), HttpStatus.CREATED);
    }

}
