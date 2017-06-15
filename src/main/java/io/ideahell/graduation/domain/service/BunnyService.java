package io.ideahell.graduation.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ideahell.graduation.domain.Bunny;
import io.ideahell.graduation.domain.RadioactiveMutantVampireBunny;
import io.ideahell.graduation.domain.persistence.BunnyRepository;
import io.ideahell.graduation.util.Randomizations;

@Service
public class BunnyService {

    private final BunnyRepository bunnyRepository;

    @Autowired
    public BunnyService(BunnyRepository bunnyRepository) {
        this.bunnyRepository = bunnyRepository;
    }

    public Bunny create() {
        return Randomizations.rollPercent(2) ? new RadioactiveMutantVampireBunny() : new Bunny();
    }

    public Bunny create(Bunny mother) {
        Bunny bunny = create();
        bunny.setColor(mother.getColor());

        return bunny;
    }

    public Iterable<Bunny> findAll() {
        return bunnyRepository.findAll();
    }

    public Bunny findOne(Long id) {
        return bunnyRepository.findOne(id);
    }

    public Iterable<Bunny> save(Iterable<Bunny> bunnies) {
        return bunnyRepository.save(bunnies);
    }

    public Bunny save(Bunny bunny) {
        return bunnyRepository.save(bunny);
    }

    public void delete(Iterable<Bunny> bunnies) {
        bunnyRepository.delete(bunnies);
    }

    public void delete(Long id) {
        bunnyRepository.delete(id);
    }

}
