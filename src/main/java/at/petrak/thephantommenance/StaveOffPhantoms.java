package at.petrak.thephantommenance;

import at.petrak.thephantommenance.advancement.ModAdvancementTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class StaveOffPhantoms {

    @SubscribeEvent
    public static void onPotion(MobEffectEvent.Added evt) {
        var effect = evt.getEffectInstance().getEffect();
        if (evt.getEntity() instanceof ServerPlayer player &&
            ForgeRegistries.MOB_EFFECTS.tags().getTag(ThePhantomMenaceMod.PHANTOM_BANISHER_EFFECT).contains(effect)) {
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
        if (usedItem.is(ThePhantomMenaceMod.PHANTOM_BANISHER_ITEM)) {
            player.getStats().setValue(player, Stats.CUSTOM.get(Stats.TIME_SINCE_REST), 0);
            ModAdvancementTriggers.STAVE_OFF_PHANTOMS.trigger(player);
        }
    }
}
