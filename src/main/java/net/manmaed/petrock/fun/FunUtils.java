package net.manmaed.petrock.fun;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class FunUtils {

    private static Boolean isATrollRunning = false;

    //Add Stuff that gets used alot

    private static void sendMessageToAllPlayers(Level level, Component message) {
        for (int i = 0; i < level.players().size(); ++i) {
            Player entityplayer = level.players().get(i);
            entityplayer.sendSystemMessage(message);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isATrollRunning() {
        return isATrollRunning;
    }

    public static void runNewTroll() {
        isATrollRunning = true;
    }




    //Log On message
    public static void manmaedLogin(Level l) {
        sendMessageToAllPlayers(l, Component.translatable("multiplayer.player.joined", "manmaed").withStyle(ChatFormatting.YELLOW));
    }

    //Log Off message
    public static void manmaedLogff(Level l) {
        sendMessageToAllPlayers(l, Component.translatable("multiplayer.player.left", "manmaed").withStyle(ChatFormatting.YELLOW));
    }

    public static void talkAsmanmaed(Level l, String msg) {
        sendMessageToAllPlayers(l, Component.literal("<manmaed> " + msg));
    }

    //Allows you to mimic Chat so <User> Message or as custom input
    public static void talkAs(Level l, String username, String msg) {
        sendMessageToAllPlayers(l, Component.literal("<" + username + "> " + msg));
    }
    public static void talkAs(Level l, Component component) {
        sendMessageToAllPlayers(l, component);
    }

    public static void aprilFoolsMesage(Level l) {
        manmaedLogin(l);
        talkAsmanmaed(l, "April Fools!");
        manmaedLogff(l);
        isATrollRunning = false;
    }
}
