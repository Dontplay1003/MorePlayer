package top.dontplay.moreplayer.mixin;

import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.*;
import top.dontplay.moreplayer.common.core.base.IMixinPlayerList;

@Mixin(PlayerList.class)
public abstract class MixinPlayerList implements IMixinPlayerList {
    @Final
    @Mutable
    @Shadow
    protected int maxPlayers;

    @Override
    @Unique
    public void moreplayer$setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
