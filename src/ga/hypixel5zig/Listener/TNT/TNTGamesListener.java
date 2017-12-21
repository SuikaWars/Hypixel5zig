package ga.hypixel5zig.Listener.TNT;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import ga.hypixel5zig.games.TNT.TNTGames;

public class TNTGamesListener
extends AbstractGameListener<TNTGames>
{
	public Class<TNTGames> getGameMode()
	{
		return TNTGames.class;
	}

	public boolean matchLobby(String lobby)
	{
		return lobby.startsWith("tntlobby");
	}
}
