package net.manmaed.petrock.jade;

import net.manmaed.petrock.entity.EntityPetRock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

/**
 * Made by manmaed on 25/10/2025
 */

@WailaPlugin
public class PRJadePlugin implements IWailaPlugin {

 @Override
 public void register(IWailaCommonRegistration reg) {
  reg.registerEntityDataProvider(PRComponentProvider.INSTANCE, EntityPetRock.class);
 }

 @Override
 public void registerClient(IWailaClientRegistration reg) {
  reg.registerEntityComponent(PRComponentProvider.INSTANCE, EntityPetRock.class);
 }
}
