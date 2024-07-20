package top.dontplay.moreplayer.mixin;

import net.minecraft.client.server.IntegratedPlayerList;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.RegistryLayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.level.storage.PlayerDataStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.dontplay.moreplayer.common.core.base.IMixinPlayerList;

@Mixin(IntegratedPlayerList.class)
public abstract class MixinIntegratedPlayerList extends PlayerList {
    public MixinIntegratedPlayerList(IntegratedServer p_251269_, LayeredRegistryAccess<RegistryLayer> p_250644_, PlayerDataStorage p_249022_, MinecraftServer server) {
        super(p_251269_, p_250644_, p_249022_, 8);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstructed(IntegratedServer p_251269_, LayeredRegistryAccess p_250644_, PlayerDataStorage p_249022_, CallbackInfo ci) {
        System.out.println("Max players(before): " + this.getMaxPlayers());
        ((IMixinPlayerList)this).moreplayer$setMaxPlayers(32);
        System.out.println("Max players(now): " + this.getMaxPlayers());
    }
}
