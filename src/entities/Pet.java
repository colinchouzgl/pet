package entities;

import common.Constants;
import common.Utils;
import enums.PetActionState;
import lombok.Data;

import static common.Utils.safeAdd;
import static common.Utils.safeSub;

/**
 * @author Zhou Guanliang
 * @since 2017/8/9
 */
@Data
public class Pet {
    private String name;

    private int hunger;
    private int thirst;
    private int cleanliness;
    private int wetness;
    private int energy;
    private int mood;
    private int liking;
    private int health;

    private PetActionState actionState;
    private int eatingCountDown;
    private int drinkingCountDown;
    private int eatingSnackCountDown;
    private int bathingCountDown;
    private int dryingCountDown;
    private int sleepingCountDown;
    private int entertainingCountDown;
    private int communicatingCountDown;
    private int playingCountDown;
    private int curingCountDown;
    private int inHospitalCountDown;


    Pet() {
    }

    Pet(String name) {
        this.name = name;
        hunger = Constants.MAX_VALUE;
        thirst = Constants.MAX_VALUE;
        cleanliness = Constants.MAX_VALUE;
        wetness = Constants.MIN_VALUE;
        energy = Constants.MAX_VALUE;
        mood = Constants.STABLE_MOOD;
        liking = Constants.MIN_VALUE;
        health = Constants.MAX_VALUE;
        actionState = PetActionState.NONE;
        eatingCountDown=0;
        drinkingCountDown=0;
        eatingSnackCountDown=0;
        bathingCountDown=0;
        dryingCountDown=0;
        sleepingCountDown=0;
        entertainingCountDown=0;
        communicatingCountDown=0;
        playingCountDown=0;
        curingCountDown=0;
        inHospitalCountDown=0;
    }

    /**
     * 全局碎片动作
     */
    public void globalPiece() {
        if (isDead()) {
            return;
        }
        if (isHappy()) {
            liking = safeAdd(liking, 1);
        }
        if (isSad()) {
            liking = safeSub(liking, 1);
        }
        if (isHungry()) {
            mood = safeSub(mood, 1);
        }
        if (isExtremeHungry()) {
            mood = safeSub(mood, 2);
            health = safeSub(health, 1);
        }
        if (isThirsty()) {
            mood = safeSub(mood, 1);
        }
        if (isExtremeThirsty()) {
            mood = safeSub(mood, 2);
            health = safeSub(health, 1);
        }
        if (isWet()) {
            if (Utils.tossCoin(Constants.SICK_CHANCE_WHILE_WET)) {
                health = safeSub(health, 1);
            }
        }
        if (isSick()) {
            mood = safeSub(mood, 1);
        }
        if (isDieing()) {
            mood = safeSub(mood, 2);
        }

        hunger = safeSub(hunger, 1);
        thirst = safeSub(thirst, 1);
        cleanliness = safeSub(cleanliness, 1);
        wetness = wetness < 100 ? safeSub(energy, 2) : wetness;
        energy = safeSub(energy, 1);
        if (mood > Constants.STABLE_MOOD) {
            mood -= 1;
        } else if (mood < Constants.STABLE_MOOD) {
            mood += 1;
        }
    }

    /**
     * 进食期间碎片动作
     */
    public void eatPiece(int hungerEffect, int sickChance, int sickEffect) {
        hunger = safeAdd(hunger, hungerEffect);
        if (Utils.tossCoin(sickChance)) {
            health = safeSub(health, sickEffect);
        }
    }

    /**
     * 饮水期间碎片动作
     */
    public void drinkPiece(int thirstEffect, int sickChance, int sickEffect) {
        thirst = safeAdd(thirst, thirstEffect);
        if (Utils.tossCoin(sickChance)) {
            health = safeSub(health, sickEffect);
        }
    }

    /**
     * 喂零食期间碎片动作
     */
    public void snackPiece(int hungerEffect, int moodEffect) {
        hunger = safeAdd(hunger, hungerEffect);
        mood = safeAdd(mood, moodEffect);
    }

    /**
     * 清洁期间碎片动作
     */
    public void bathPiece(int cleanlinessEffect, int moodEffect) {
        cleanliness = safeAdd(cleanliness, cleanlinessEffect);
        mood = safeSub(mood, moodEffect);
        wetness = Constants.MAX_VALUE;
    }

    /**
     * 吹干期间碎片动作
     */
    public void dryPiece(int wetnessEffect, int moodEffect) {
        wetness = safeSub(wetness, wetnessEffect);
        mood = safeSub(mood, moodEffect);
    }

    /**
     * 睡眠期间碎片动作
     */
    public void sleepPiece(int energyEffect, int sickChance, int sickEffect) {
        energy = safeSub(energy, energyEffect);
        if (Utils.tossCoin(sickChance)) {
            health = safeSub(health, sickEffect);
        }
    }

    /**
     * 自娱期间碎片动作
     */
    public void entertainPiece(int moodEffect) {
        mood = safeAdd(mood, moodEffect);
        energy = safeSub(energy, Constants.ENTERTAIN_ENERGY_EFFECT);
    }


    public void communicatePiece(int moodEffect) {
        mood = safeAdd(mood, moodEffect);
    }

    /**
     * 玩乐期间碎片动作
     */
    public void playPiece(int moodEffect) {
        mood = safeAdd(mood, moodEffect);
        energy = safeSub(energy, Constants.PLAY_ENERGY_EFFECT);
    }

    /**
     * 治疗期间碎片动作
     */
    public void curePiece(int healthEffect, int moodEffect) {
        health = safeAdd(health, healthEffect);
        mood = safeSub(mood, moodEffect);
    }

    public boolean isHappy() {
        return mood >= Constants.HAPPY_MOOD;
    }

    public boolean isSad() {
        return mood < Constants.SAD_MOOD;
    }

    public boolean isHungry() {
        return hunger >= Constants.EXTREME_HUNGRY_HUNGER && hunger < Constants.HUNGRY_HUNGER;
    }

    public boolean isExtremeHungry() {
        return hunger < Constants.EXTREME_HUNGRY_HUNGER;
    }

    public boolean isThirsty() {
        return thirst >= Constants.EXTREME_THIRSTY_THIRST && thirst < Constants.THIRSTY_THIRST;
    }

    public boolean isExtremeThirsty() {
        return thirst < Constants.EXTREME_THIRSTY_THIRST;
    }

    public boolean isWet() {
        return wetness > 0;
    }

    public boolean isSick() {
        return health >= Constants.DIEING_HEALTH && health < Constants.SICK_HEALTH;
    }

    public boolean isDieing() {
        return health < Constants.DIEING_HEALTH;
    }

    public boolean isDead() {
        return health <= 0;
    }
}
