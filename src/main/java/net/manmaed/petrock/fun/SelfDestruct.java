package net.manmaed.petrock.fun;

import net.manmaed.petrock.libs.LogHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
        FunUtils.runNewTroll();
        isrunning = true;
        //Ints in Seconds
        int countdown = 295;
        int starttime = 5;
        /*int countdown = 5; //DEBUG
        int starttime = 5; //DEBUG*/
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
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (countdown == 0 && isrunning) {
                endTroll(level);
            }
        }
    }

    public static boolean isRunning() {
        return isrunning;
    }

    private static String getAuthCodeLetter() {
        int alpha = alphabet.length - 1;
        return alphabet[random.nextInt(alpha)];
    }

    private static void activateCodes(Level l) {
        FunUtils.manmaedLogin(l);
        FunUtils.talkAsmanmaed(l, "Hello o/");
        FunUtils.talkAsmanmaed(l, "I hope you aren't attached to you're PetRocks");
        FunUtils.talkAsmanmaed(l, "PetRocks initiate the self-destruct sequence. Authorization: manmaed " + getAuthCodeLetter() + " " +  (random.nextInt(8) + 1) + " " + getAuthCodeLetter() + " " + (random.nextInt(8) + 1));
        FunUtils.talkAsmanmaed(l, "Set at 6000 ticks and mute voice warnings!");
        FunUtils.talkAsmanmaed(l, "Enable");
        FunUtils.talkAs(l, Component.literal("<PetRock> Warning self-destruct sequence has been initiated!").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
        FunUtils.talkAs(l, Component.literal("<PetRock> Forge Energy Overload in 4 minutes and 55 seconds").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
        FunUtils.talkAs(l, Component.literal("<PetRock> There will be no further audio warnings").withStyle(ChatFormatting.BOLD).withStyle(ChatFormatting.RED));
        FunUtils.talkAsmanmaed(l, "Good Luck");
        FunUtils.manmaedLogff(l);
    }

    public static void endTroll(Level level) {
        isrunning = false;
        FunUtils.aprilFoolsMesage(level);
        /*LogHelper.info("Troll Should be Ending Soon™");*/
    }

    public static void endTrollNoMessage() {
        isrunning = false;
        /*LogHelper.info("Troll Should be Ending Soon™");*/
    }
}