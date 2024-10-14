package net.manmaed.petrock.datagen.lang;

import net.manmaed.petrock.PetRock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class PetRockENUS extends LanguageProvider {
    public PetRockENUS(PackOutput output) {
        super(output, PetRock.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("a.lang.file.name", "English US");
        add("a.lang.author.name", "manmaed");
        add("itemGroup." + PetRock.MOD_ID, "PetRock");
        //TODO: Make this
    }
}
