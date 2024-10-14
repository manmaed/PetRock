package net.manmaed.petrock.datagen.lang;

import net.manmaed.petrock.PetRock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class PetRockENUS extends LanguageProvider {
    public PetRockENUS(PackOutput output) {
        super(output, PetRock.MOD_ID, "en_us");
    }

    String b = "block";
    String i = "item";
    String e = "entity";
    String a = "advancements";
    String c = "command";

    String mod = "petrock";

    private String getName(Integer integer, String name) {
        switch (integer) {
            case 1:
                return b + "." + mod + "." + name;
            case 2:
                return i + "." + mod + "." + name;
            case 3:
                return e + "." + mod + "." + name;
            case 4:
                return mod + "." + c + "." + name;
        }
        return name;
    }

    private String getAName(Boolean discription, String name) {
        if (discription) {
            return a + "." + mod + "." + name + ".description";
        }
        return a + "." + mod + "." + name + ".title";
    }

    @Override
    protected void addTranslations() {
        add("a.lang.file.name", "English US");
        add("a.lang.author.name", "manmaed");
        add("itemGroup." + PetRock.MOD_ID, "PetRock");

        //Blocks 1
        add(getName(1, "stoneium_ore"), "Stoneium Ore");
        add(getName(1, "deepslate_stoneium_ore"), "Deepslate Stoneium Ore");
        add(getName(1,"stoneium_block"), "Stoneium Block");

        //Items 2
        add(getName(2,"stoneium"), "Stoneium");
        add(getName(2,"kibble"), "Rock Kibble");
        add(getName(2,"orderform"), "Order Form");
        add(getName(2, "petrockbox"), "PetRock");
        add(getName(2, "petrockwithlegsbox"), "PetRock With Legs");
        add(getName(2, "stone_legs"), "Stone Legs");
        add(getName(2, "raw_stoneium"), "Raw Stoneium");

        //Item Tooltips 2
        add(getName(2, "stoneium.tooltip"), "Used to tame a PetRock and for crafting Rock kibble");
        add(getName(2, "kibble.tooltip"), "For PetRock consumption only!");
        add(getName(2, "stone_legs.tooltip"), "Used only for crafting");

        //Entity 3
        add(getName(3, "petrock"), "PetRock");
        add(getName(3, "petrockwithlegs"), "PetRock with Legs");

        //Command Feedback 4
        add(getName(4, "iamslowpoke101.feedback"), "Slowpoke101 Hat Enabled!");
        add(getName(4, "sethat.none.feedback"), "Hats cleared!");
        add(getName(4, "sethat.birthday.feedback"), "Birthday mode enabled!");
        add(getName(4, "sethat.christmas.feedback"), "Happy Christmas %1$s!");
        add(getName(4, "sethat.halloween.feedback"), "Happy Halloween %1$s!");
        add(getName(4, "sethat.tnt.feedback"), "TNT mode enabled!");
        add(getName(4, "sethat.easter.feedback"), "Happy Easter %1$s!");
        add(getName(4, "sethat.noslow.failure"), "No custom hat set with Slowpoke mode enabled");
        add(getName(4, "sethat.actuallybear.success"), "Happy Birthday ActuallyBear!");
        add(getName(4, "sethat.loneztar.success"), "Happy Birthday Loneztar!");
        add(getName(4, "sethat.reload.feedback"), "Hats Reloaded!");

        //Advancements getAName(true for descption false for title)
        add(getAName(false, "root"), "PetRock Advancements");
        add(getAName(true, "root"), "Install PetRock");
        add(getAName(false, "mine_stoneium"), "Mine Stoneium Ore");
        add(getAName(true, "mine_stoneium"), "Mine Stoneium Ore get Raw Stoneium");
        add(getAName(false, "cook_raw_stoneium"), "Cook Raw Stoneium");
        add(getAName(true, "cook_raw_stoneium"), "Cook Raw Stoneium to Stoneium so you can also tame a PetRock");


        add(getAName(false, "order_form"), "Order a PetRock");
        add(getAName(true, "order_form"), "Craft an Order Form so you can get a PetRock");
        add(getAName(false, "get_petrock"), "You Got Mail!");
        add(getAName(true, "get_petrock"), "You got a PetRock delivered");
        add(getAName(false, "warranty_void"), "Void the Warranty!");
        add(getAName(true, "warranty_void"), "You somehow damaged your PetRock this voids its warranty!");
        add(getAName(false, "heal_a_petrock"), "Petrock Healing!");
        add(getAName(true, "heal_a_petrock"), "Heal the PetRock! You monster!");
        add(getAName(false, "get_petrock_with_legs"), "It Has Legs");
        add(getAName(true, "get_petrock_with_legs"), "Get a petrock with legs!");
    }
}
