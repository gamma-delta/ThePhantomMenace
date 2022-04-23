package at.petrak.thephantommenance.datagen;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class ModDatagen {
    @SubscribeEvent
    public static void generateData(GatherDataEvent evt) {
        var gen = evt.getGenerator();
        var efh = evt.getExistingFileHelper();

        if (evt.includeServer()) {
            gen.addProvider(new ModAdvancementProvider(gen, efh));
        }
    }

}
