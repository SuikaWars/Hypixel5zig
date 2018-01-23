package ga.hypixel5zig.Listener;

import com.mojang.authlib.GameProfile;
import eu.the5zig.mod.ModAPI;
import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.server.AbstractGameListener;
import eu.the5zig.mod.server.GameState;
import eu.the5zig.mod.server.IPatternResult;
import ga.hypixel5zig.games.BuildBattle;

public class BuildBattleListener
extends AbstractGameListener<BuildBattle>
{
	public Class<BuildBattle> getGameMode()
	{
		return BuildBattle.class;
	}

	public boolean matchLobby(String lobby)
	{
		return lobby.startsWith("bblobby") || (HypixelListener.Game != null && (HypixelListener.Game.equals("Build Battle") || HypixelListener.Game.equals("Guess the Build")));
	}

	public void onMatch(BuildBattle gameMode, String key, IPatternResult match)
	{
		if (key.equals("starting")) {
			gameMode.setTime(System.currentTimeMillis() + Integer.parseInt(match.get(0)) * 1000);
		}
		if (key.equals("canceled")) {
			gameMode.setTime(-1L);
		}
		if (key.startsWith("coin.")) {
			gameMode.setEarnedCoins(gameMode.getEarnedCoins() + Integer.parseInt(match.get(0)));
		}
		if (key.startsWith("BuildBattle.theme.")) {
			gameMode.setTheme(match.get(0));
		}
	}
	public void onServerConnect(BuildBattle gameMode)
	{
		gameMode.setKit(null);
		gameMode.setTime(-1L);
		gameMode.setState(GameState.LOBBY);
		gameMode.setEarnedCoins(0);
	}
	public void onTick(BuildBattle gameMode)
	{
		if ((gameMode.getState() == GameState.LOBBY) && 
			(gameMode.getTime() != -1L) && (gameMode.getTime() - System.currentTimeMillis() < 0L))
		{
			gameMode.setTime(-1L);
			gameMode.setState(GameState.GAME);
		}
	}
}
