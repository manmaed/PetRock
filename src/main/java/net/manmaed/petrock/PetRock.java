package net.manmaed.petrock;

import net.manmaed.petrock.block.PRBlocks;
import net.manmaed.petrock.entity.EntityPetRock;
import net.manmaed.petrock.entity.EntityPetRockWithLegs;
import net.manmaed.petrock.entity.PREntityTypes;
import net.manmaed.petrock.item.PRItems;
import net.manmaed.petrock.tab.PRTab;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

/**
 * Created by manmaed on 25/11/2019.
 */
@Mod(PetRock.MOD_ID)
public class PetRock {

    public static final String MOD_ID = "petrock";

    public PetRock(IEventBus event) {
        PRItems.ITEMS.register(event);
        PRBlocks.BLOCKS.register(event);
        PREntityTypes.ENTITY_TYPES.register(event);
        PRTab.CREATIVE_TABS.register(event);
        event.addListener(this::AttributeCreation);
        event.addListener(PetRockClient::doEntityRendering);
        event.addListener(PetRockClient::registerLayerDefinitions);
        event.addListener(PetRockClient::doClientStuff);
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGH, PetRockClient::registerClientCommands);
    }

    private void AttributeCreation(EntityAttributeCreationEvent event) {
        event.put(PREntityTypes.PETROCK.get(), EntityPetRock.createAttributes().build());
        event.put(PREntityTypes.PETROCKWITHLEGS.get(), EntityPetRockWithLegs.createAttributes().build());
    }
}