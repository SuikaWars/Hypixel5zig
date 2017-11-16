package plugin.hypixel5zig;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.event.LoadEvent;
import eu.the5zig.mod.event.EventHandler;
import eu.the5zig.mod.plugin.Plugin;
import java.util.HashMap;
import plugin.hypixel5zig.modules.*;

@Plugin(name = "Hypixel5zig Beta", version = "1.0.1")
public class Main{
	@EventHandler(priority = EventHandler.Priority.LOW)
	public void onLoad(LoadEvent event) {
		The5zigAPI.getAPI().registerServerInstance(this, HypixelInstance.class);
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelServer", ServerItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelMap", MapItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelswKit", swKitItem.class, "Hypixel5zig");
		The5zigAPI.getAPI().registerModuleItem(this, "HypixelswCageOpen", swCageOpenItem.class, "Hypixel5zig");
	}
}