package ga.hypixel5zig;

import eu.the5zig.mod.server.ServerInstance;
import eu.the5zig.mod.The5zigAPI;
import ga.hypixel5zig.Listener.*;
import ga.hypixel5zig.Listener.Arcade.*;
import ga.hypixel5zig.Listener.Classic.*;

public class HypixelInstance extends ServerInstance {
	public static boolean IsHypixel(String host) {
        return host.toLowerCase().equals("hypixel.net") || host.toLowerCase().equals("hypixel.net.") || host.toLowerCase().endsWith(".hypixel.net") || host.toLowerCase().endsWith(".hypixel.net.");
    }
	@Override
	public void registerListeners() {
		getGameListener().registerListener(new HypixelListener());
		getGameListener().registerListener(new SkyWarsListener());
		getGameListener().registerListener(new SpeedUHCListener());
		getGameListener().registerListener(new BuildBattleListener());
		getGameListener().registerListener(new TNTGamesListener());
		getGameListener().registerListener(new ArcadeGamesListener());
		getGameListener().registerListener(new MiniWallsListener());
		getGameListener().registerListener(new QuakecraftListener());
		getGameListener().registerListener(new PaintballListener());
	}

	@Override
	public String getName() {
		return "Hypixel Network";
	}

	@Override
	public String getConfigName() {
		return "hypixel.net";
	}

	@Override
	public boolean handleServer(String host, int port) {
		return IsHypixel(host);
	}

}
