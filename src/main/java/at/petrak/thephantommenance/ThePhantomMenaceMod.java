package at.petrak.thephantommenance;

import at.petrak.thephantommenance.advancement.ModAdvancementTriggers;
import at.petrak.thephantommenance.datagen.ModDatagen;
import com.mojang.logging.LogUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ThePhantomMenaceMod.MOD_ID)
public class ThePhantomMenaceMod {
    public static final String MOD_ID = "thephantommenace";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final TagKey<Item> PHANTOM_BANISHER_ITEM = ItemTags.create(modLoc("phantom_banisher"));
    public static final TagKey<MobEffect> PHANTOM_BANISHER_EFFECT = TagKey.create(Registry.MOB_EFFECT_REGISTRY,
        modLoc("phantom_banisher"));

    public ThePhantomMenaceMod() {
        // For things that happen in initialization
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        // For everything else
        var evBus = MinecraftForge.EVENT_BUS;

        modBus.register(ModDatagen.class);
        evBus.register(StaveOffPhantoms.class);

        ModAdvancementTriggers.register();

//        var configSpec = new ForgeConfigSpec.Builder().configure(ThePhantomMenaceConfig::init).getRight();
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configSpec);
    }

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
