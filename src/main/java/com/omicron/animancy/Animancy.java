package com.omicron.animancy;

import com.omicron.animancy.init.CommonInitialization;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Animancy.MODID)
public class Animancy
{

    public static final String MODID = "animancy";

    public Animancy()
    {
        CommonInitialization.init();

    }
}
