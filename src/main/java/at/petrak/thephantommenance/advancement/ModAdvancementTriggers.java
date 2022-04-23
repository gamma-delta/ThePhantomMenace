package at.petrak.thephantommenance.advancement;

import net.minecraft.advancements.CriteriaTriggers;

public class ModAdvancementTriggers {
    public static final StaveOffPhantomsTrigger STAVE_OFF_PHANTOMS = new StaveOffPhantomsTrigger();

    public static void register() {
        CriteriaTriggers.register(STAVE_OFF_PHANTOMS);
    }
}
