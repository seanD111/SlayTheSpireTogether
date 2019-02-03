package ststogether;
import basemod.ModLabel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.BaseMod;
import basemod.ModPanel;

import basemod.interfaces.PostInitializeSubscriber;
@SpireInitializer
public class SlayTheSpireTogether implements PostInitializeSubscriber{

    public static final Logger logger = LogManager.getLogger(SlayTheSpireTogether.class.getName()); // lets us log output

    public static final String MODNAME = "Slay The Spire Together"; // mod name
    public static final String AUTHOR = "Asshole and DipShit"; // your name
    public static final String DESCRIPTION = "v1.0.0 -Play with Friend"; // description (w/ version # if you want)

    public void receivePostInitialize() {
        // Mod badge
        Texture badgeTexture = new Texture("badge_img.png");
        ModPanel settingsPanel = new ModPanel();
        ModLabel label = new ModLabel("My mod does not have any settings (yet)!", 350.0f , 650.0f,  settingsPanel, (me) -> {});
        settingsPanel.addUIElement(label);
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel); // once the game has initialized we want to set up a **mod badge** which is a little icon on the main menu screen that tells users that our mod has been loaded
        logger.info("Completed Post Initialize");

    }



    public SlayTheSpireTogether(){
        logger.info("subscribing to postInitialize event");
        BaseMod.subscribe(this); // tell BaseMod that our mod wants to be notified once the game has finished initializing itself

    }
    public static void initialize(){
        logger.info("========================= STS TOGETHER =========================");
        new SlayTheSpireTogether();
        logger.info("================================================================");
    }




}
