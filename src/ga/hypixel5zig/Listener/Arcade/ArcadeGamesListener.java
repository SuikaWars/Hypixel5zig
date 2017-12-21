package ga.hypixel5zig.Listener.Arcade;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import ga.hypixel5zig.games.Arcade.ArcadeGames;

public class ArcadeGamesListener
extends AbstractGameListener<ArcadeGames>
{
	public Class<ArcadeGames> getGameMode()
	{
		return ArcadeGames.class;
	}

	public boolean matchLobby(String lobby)
	{
		return lobby.startsWith("arcadelobby");
	}
}
