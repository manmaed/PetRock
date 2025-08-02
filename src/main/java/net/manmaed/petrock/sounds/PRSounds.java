package net.manmaed.petrock.sounds;

import net.manmaed.petrock.PetRock;
import net.manmaed.petrock.libs.RLHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PRSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, PetRock.MOD_ID);



    public static final DeferredHolder<SoundEvent, ?> PETROCK_TAME = SOUNDS.register("sounds.entity.petrock.tamed", () -> SoundEvent.createVariableRangeEvent(RLHelper.location("sounds.entity.petrock.tamed")));
    public static final DeferredHolder<SoundEvent, ?> PETROCK_MATE = SOUNDS.register("sounds.entity.petrock.mating", () -> SoundEvent.createVariableRangeEvent(RLHelper.location("sounds.entity.petrock.mating")));

}
