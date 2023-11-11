package net.tanmay.tutorialmod.block;
package net.tanmay.tutorialmod.TutorialMod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tanmay.tutorialmod.TutorialMod;
import net.tanmay.tutorialmod.item.ModItems;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK =
            registerBlock("Sapphire_Block",
                    ()-> new Block (BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    private static <T extends Block> RegistryObject<T> registerBlockItem(String name ,
                                                                            Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name ,
                                                                    RegistryObject<T> block)
  {
      return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
  }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
