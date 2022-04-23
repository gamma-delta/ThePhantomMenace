package at.petrak.thephantommenance;

import at.petrak.thephantommenance.advancement.ModAdvancementTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static at.petrak.thephantommenance.ThePhantomMenaceMod.modLoc;

public class StaveOffPhantoms {
    public static final TagKey<Item> PHANTOM_BANISHER = ItemTags.create(modLoc("phantom_banisher"));

    @SubscribeEvent
    public static void onPotion(PotionEvent.PotionAddedEvent evt) {
        if (evt.getEntity() instanceof ServerPlayer player && ThePhantomMenaceConfig.caffeinatedPotionIDs.get()
            .contains(evt.getPotionEffect().getEffect().getRegistryName().toString())) {
            player.getStats().setValue(player, Stats.CUSTOM.get(Stats.TIME_SINCE_REST), 0);
            ModAdvancementTriggers.STAVE_OFF_PHANTOMS.trigger(player);
        }
    }

    // or not strictly just eating. make it fire when you finish with a bow for all i care
    @SubscribeEvent
    public static void onEat(LivingEntityUseItemEvent.Finish evt) {
        if (!(evt.getEntity() instanceof ServerPlayer player)) {
            return;
        }

        var usedItem = evt.getItem();
        if (usedItem.is(PHANTOM_BANISHER)) {
            player.getStats().setValue(player, Stats.CUSTOM.get(Stats.TIME_SINCE_REST), 0);
            ModAdvancementTriggers.STAVE_OFF_PHANTOMS.trigger(player);
        }
    }
}
