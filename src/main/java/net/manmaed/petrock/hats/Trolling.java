package net.manmaed.petrock.hats;

import net.manmaed.petrock.libs.LogHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jline.utils.Log;

import java.util.Random;

public class Trolling {

    public static Random random = new Random();

    static String[] PHONETIC_ALPHABET = {
            "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel",
            "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa",
            "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray",
            "Yankee", "Zulu"};
    private static boolean isrunning = false;
    private static boolean chancecubes = false;

    public static boolean flashingmode = false;

    public static void startTroll(PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) throws InterruptedException {
        isrunning = true;
        int countdown = 250;
        Random random = new Random();
        int starttime = random.nextInt(120) + 60;
        Player player = playerLoggedInEvent.getEntity();
        while (starttime > 0 && isrunning) {
            LogHelper.info("Stating Troll in: " + starttime);
            starttime--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (starttime == 0 && isrunning) {
            LogHelper.info("Starting");
            if (chancecubes) {
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed joined the game").withStyle(ChatFormatting.YELLOW));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> It seems you have Chance Cubes installed :)"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("[@: Gave 1 [Compact Giant Chance Cube] to manmaed]").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
                sendMessageToAllPlayersNames(playerLoggedInEvent.getEntity().level());
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("Who Dat is!?"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("I hope this isn't near your base, because you have 400 ticks before stuff goes bye bye. Kappa"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> Good Luck"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed left the game").withStyle(ChatFormatting.YELLOW));
                countdown = 20;
                while (countdown > 0 && isrunning) {
                    /*LogHelper.info("Big Explosion in " + countdown);*/
                    countdown--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (countdown == 0 && isrunning) {
                    sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed joined the game").withStyle(ChatFormatting.YELLOW));
                    sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> April Fools!"));
                    sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed left the game").withStyle(ChatFormatting.YELLOW));
                }

            } else {
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed joined the game").withStyle(ChatFormatting.YELLOW));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> It seems you don't have Chance Cubes installed :( I will just have to do it myself"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> PetRocks initiate the self-destruct sequence. Authorization: manmaed " + getSelfDestructCode()));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> Set at 6000 ticks and mute voice warnings!"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> Enable"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<PetRock> Warning self-destruct sequence has been initiated!").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<PetRock> Forge Energy Overload in 4 minutes and 55 seconds").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<PetRock> There will be no further audio warnings").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> Good Luck"));
                sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed left the game").withStyle(ChatFormatting.YELLOW));
                countdown = 600;
                while (countdown > 0 && isrunning) {
                    boolean moveon = false;
                    /*LogHelper.info("Warning Forge Energy Overload in " + countdown);*/
                    if (!flashingmode && !moveon) {
                        flashingmode = true;
                        moveon = true;
                    }
                    if (flashingmode && !moveon) {
                        flashingmode = false;
                        moveon = true;
                    }
                    countdown--;
                    moveon = false;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (countdown == 0 && isrunning) {
                    sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed joined the game").withStyle(ChatFormatting.YELLOW));
                    sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("<manmaed> April Fools!"));
                    sendMessageToAllPlayers(playerLoggedInEvent.getEntity().level(), Component.literal("manmaed left the game").withStyle(ChatFormatting.YELLOW));
                }
            }
        }
        endTrollInternal();
    }

    public static String getSelfDestructCode() {
        return getRandomLetter() + " " + getRandomNumber() + " " + getRandomLetter() + " " + getRandomNumber();
    }

    public static int getRandomNumber() {
        return random.nextInt(8) + 1;
    }

    public static String getRandomLetter() {
        int i = random.nextInt(PHONETIC_ALPHABET.length);
        return PHONETIC_ALPHABET[i];
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

    public static void sendMessageToAllPlayersNames(Level level) {
        for (int i = 0; i < level.players().size(); ++i) {
            Player entityplayer = level.players().get(i);
            entityplayer.sendSystemMessage(Component.literal("[manmaed: Forced " + entityplayer.getDisplayName().getString() + " to open [Compact Giant Chance Cube]").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isRunning() {
        return isrunning;
    }

    public static void endTroll() {
        isrunning = false;
        flashingmode = false;
        /*LogHelper.info("Troll Should be Ending Soon™");*/
    }

    private static void endTrollInternal() {
        isrunning = false;
        flashingmode = false;
        /*LogHelper.info("End of Troll");*/
    }

    public static void CCEnable() {
        chancecubes = true;
    }
}
