package net.manmaed.petrock.datagen;

import net.manmaed.petrock.datagen.lang.PetRockENUS;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;

public class PRLanguageProvider {

    public static void addTranslations(DataGenerator generator) {
        PackOutput output = generator.getPackOutput();
        /**
         * To Add a new LanguageProvider make a new fine in the net.manmaed.petrock.datagen.lang called PetRocklocale (eg PetRockENPT for Pirate Speak)
         * then make that extend LanguageProvider make it only need a PackOutput and define the modID as PetRock.MOD_ID and the locale in the super
         * Example:
         * public PetRockENPT(PackOutput output) { super(output, PetRock.MOD_ID, "en_pt") }
         * --
         * please add the fist 2 lines to the new Language for Language Name, Translator Name
         * Example:
         * add("a.lang.file.name", "Pirate Speak");
         * add("a.lang.author.name", "manmaed");
         */
        generator.addProvider(true, new PetRockENUS(output));
    }
}
