package net.manmaed.petrock.fun;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ChanceCubes {

    private static boolean isrunning = false;
    private static Random random = new Random();
    public static void start(ServerLevel level, Boolean cc) throws InterruptedException {
        FunUtils.runNewTroll();
        isrunning = true;
        int countdown = 20;
        int starttime = random.nextInt(120) + 60;
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
            if (cc) {
                ccInstalled(level);
            } else ccNotInstalled(level);
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

    public static void ccNotInstalled(Level level){
        FunUtils.manmaedLogin(level);
        FunUtils.talkAsmanmaed(level,"It seems you have don't Chance Cubes installed :(");
        FunUtils.talkAsmanmaed(level,"Guess i'll have to use a PetRock");
        summonPetrocks(level);
        FunUtils.talkAsmanmaed(level,"Petrocks Active Chance Cube Mode");
        FunUtils.talkAsmanmaed(level, "Open!");
        FunUtils.talkAs(level, Component.literal("<PetRock> Who Dat is!?").withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.BOLD));
        FunUtils.talkAs(level, Component.literal("<PetRock> I hope this isn't near your base, because you have 400 ticks before stuff and all you're PetRocks goes bye bye. Kappa").withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.BOLD));
        FunUtils.talkAsmanmaed(level, "Good Luck");
        FunUtils.manmaedLogff(level);
    }
    public static void ccInstalled(Level level){
        FunUtils.manmaedLogin(level);
        FunUtils.talkAsmanmaed(level,"It seems you have Chance Cubes installed :)");
        FunUtils.talkAsmanmaed(level, "I hope you aren't any PetRocks around you that you're attached to");
        FunUtils.talkAs(level, Component.literal("[@: Gave 1 [Compact Giant Chance Cube] to manmaed]").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        forceOpens(level);
        FunUtils.talkAs(level, Component.literal("Who Dat is!?"));
        FunUtils.talkAs(level, Component.literal("I hope this isn't near your base, because you have 400 ticks before stuff goes bye bye. Kappa"));
        FunUtils.talkAsmanmaed(level, "Good Luck");
        FunUtils.manmaedLogff(level);
    }

    private static void forceOpens(Level level) {
        for (int i = 0; i < level.players().size(); ++i) {
            Player entityplayer = level.players().get(i);
            FunUtils.talkAs(level, Component.literal("[manmaed: Forced " + entityplayer.getDisplayName().getString() + " to open [Compact Giant Chance Cube]").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void summonPetrocks(Level level) {
        for (int i = 0; i < level.players().size(); ++i) {
            Player entityplayer = level.players().get(i);
            FunUtils.talkAs(level, Component.literal("[manmaed: Summond an invisible PetRock at " + entityplayer.getDisplayName().getString() + "'s location").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public static boolean isRunning() {
        return isrunning;
    }
}
