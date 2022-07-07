package at.petrak.thephantommenance.datagen;

import at.petrak.paucal.api.datagen.PaucalAdvancementProvider;
import at.petrak.thephantommenance.ThePhantomMenaceMod;
import at.petrak.thephantommenance.advancement.StaveOffPhantomsTrigger;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModAdvancementProvider extends PaucalAdvancementProvider {
    public ModAdvancementProvider(DataGenerator generatorIn) {
        super(generatorIn, ThePhantomMenaceMod.MOD_ID);
    }

    @Override
    protected void makeAdvancements(Consumer<Advancement> consumer) {
        Advancement.Builder.advancement()
            .display(simpleDisplay(Items.PHANTOM_MEMBRANE, "root", FrameType.TASK))
            .parent(new ResourceLocation("adventure/sleep_in_bed"))
            .addCriterion("stave_off_phantom", new StaveOffPhantomsTrigger.Instance(EntityPredicate.Composite.ANY))
            .save(consumer, modLoc("root"), fileHelper);
    }
}
