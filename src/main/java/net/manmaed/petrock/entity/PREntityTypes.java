package net.manmaed.petrock.entity;


import net.manmaed.petrock.PetRock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PREntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, PetRock.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<EntityPetRock>> PETROCK = ENTITY_TYPES.register("petrock",
            () -> EntityType.Builder.of(EntityPetRock:: new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("petrock")
    );
    public static final DeferredHolder<EntityType<?>, EntityType<EntityPetRockWithLegs>> PETROCKWITHLEGS = ENTITY_TYPES.register("petrockwithlegs",
            () -> EntityType.Builder.of(EntityPetRockWithLegs:: new, MobCategory.MISC)
                    .sized(0.5f, 0.8f)
                    .build("petrockwithlegs")
    );
}
