package at.petrak.thephantommenance;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Unit;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ThePhantomMenaceConfig {
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> caffeinatedPotionIDs;

    public static Unit init(ForgeConfigSpec.Builder builder) {
        caffeinatedPotionIDs = builder.comment("Potion effects that reset the sleep timer when applied")
            .defineList("caffeinatedPotionIDs", List.of("minecraft:speed"),
                o -> o instanceof String s && ResourceLocation.isValidResourceLocation(s));

        // must return unit because forge bad
        return Unit.INSTANCE;
    }
}
