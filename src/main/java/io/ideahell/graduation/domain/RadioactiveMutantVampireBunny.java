package io.ideahell.graduation.domain;

public class RadioactiveMutantVampireBunny extends Bunny {

    public RadioactiveMutantVampireBunny() {
        super();
        this.title = "Radioactive Mutant Vampire Bunny";
    }

    @Override
    public boolean canBreed() {
        return false;
    }

    @Override
    public int getLifespan() {
        return 50;
    }

}
