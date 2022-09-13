package net.manmaed.petrock.entitys;

import net.manmaed.petrock.PetRock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PREntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PetRock.MOD_ID);

    //Entity Types
    /*@ObjectHolder(Refs.Register + "petrock")*/
    /*public static EntityType<EntityPetRock> PETROCK;*/

    public static final RegistryObject<EntityType<EntityPetRock>> PETROCK = ENTITY_TYPES.register("petrock",
            () -> EntityType.Builder.of(EntityPetRock:: new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build("petrock")
    );
    public static final RegistryObject<EntityType<EntityPetRockWithLegs>> PETROCKWITHLEGS = ENTITY_TYPES.register("petrockwithlegs",
            () -> EntityType.Builder.of(EntityPetRockWithLegs:: new, MobCategory.MISC)
                    .sized(0.5f, 0.8f)
                    .build("petrockwithlegs")
    );
}
