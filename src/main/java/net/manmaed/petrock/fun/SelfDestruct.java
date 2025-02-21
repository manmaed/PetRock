package net.manmaed.petrock.fun;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;

//The Old April Fools
public class SelfDestruct {

    private static boolean isrunning = false;
    private static String[] alphabet = {
            "Alpha",
            "Bravo",
            "Charlie",
            "Delta",
            "Echo",
            "Foxtrot",
            "Golf",
            "Hotel",
            "India",
            "Juliett",
            "Kilo",
            "Lima",
            "Mike",
            "November",
            "Oscar",
            "Papa",
            "Quebec",
            "Romeo",
            "Sierra",
            "Tango",
            "Uniform",
            "Victor",
            "Whiskey",
            "X-ray",
            "Yankee",
            "Zulu"
    };



    private static Random random = new Random();

    public static void start(ServerLevel level) throws InterruptedException {
        isrunning = true;
        int countdown = 600;
        int starttime = random.nextInt(120) + 60;
        /*int countdown = 100; //DEBUG
        int starttime = 15; //DEBUG*/
        while (starttime > 0 && isrunning) {
            /*LogHelper.info("Stating Troll in: " + starttime);*/
            starttime--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (starttime == 0 && isrunning) {
            /*LogHelper.info("Starting");*/
            activateCodes(level);
            while (countdown > 0 && isrunning) {
                /*LogHelper.info("Warning Forge Energy Overload in " + countdown);*/
                countdown--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (countdown == 0 && isrunning) {
                endTroll(level);
            }
        }
    }

    public static void sendMessageToAllPlayers(Level level, Component message) {
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


    public static boolean isRunning() {
        System.out.println("retuens: " + isrunning);
        return isrunning;
    }

    private static String getAuthCodeLetter() {
        int alpha = alphabet.length - 1;
        return alphabet[random.nextInt(alpha)];
    }

    private static void activateCodes(Level level) {
        sendMessageToAllPlayers(level, Component.literal("manmaed joined the game").withStyle(ChatFormatting.YELLOW));
        sendMessageToAllPlayers(level, Component.literal("<manmaed> Hello o/"));
        sendMessageToAllPlayers(level, Component.literal("<manmaed> I hope you aren't attached to you're petrocks"));
        sendMessageToAllPlayers(level, Component.literal("<manmaed> PetRocks initiate the self-destruct sequence. Authorization: manmaed " + getAuthCodeLetter() + " " +  (random.nextInt(8) + 1) + " " + getAuthCodeLetter() + " " + (random.nextInt(8) + 1)));
        sendMessageToAllPlayers(level, Component.literal("<manmaed> Set at 6000 ticks and mute voice warnings!"));
        sendMessageToAllPlayers(level, Component.literal("<manmaed> Enable"));
        sendMessageToAllPlayers(level, Component.literal("<PetRock> Warning self-destruct sequence has been initiated!").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
        sendMessageToAllPlayers(level, Component.literal("<PetRock> Forge Energy Overload in 4 minutes and 55 seconds").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
        sendMessageToAllPlayers(level, Component.literal("<PetRock> There will be no further audio warnings").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
        sendMessageToAllPlayers(level, Component.literal("<manmaed> Good Luck"));
        sendMessageToAllPlayers(level, Component.literal("manmaed left the game").withStyle(ChatFormatting.YELLOW));
    }

    public static void endTroll(Level level) {
        isrunning = false;
        sendMessageToAllPlayers(level, Component.literal("manmaed joined the game").withStyle(ChatFormatting.YELLOW));
        sendMessageToAllPlayers(level, Component.literal("<manmaed> April Fools!"));
        sendMessageToAllPlayers(level, Component.literal("manmaed left the game").withStyle(ChatFormatting.YELLOW));
        /*LogHelper.info("Troll Should be Ending Soon™");*/
    }
}