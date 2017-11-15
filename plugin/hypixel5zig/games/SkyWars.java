package plugin.hypixel5zig.games;

import eu.the5zig.mod.server.GameMode;

public class SkyWars extends GameMode {
	public static String Map;
	public static String Kit;
	public static long CageOpenTime;
	@Override
	public String getName() {
		return "SkyWars";
	}
	private long winTime;
	private String winMessage;
	public long getWinTime()
	{
		return this.winTime;
	}

	public void setWinTime(long winTime)
	{
		this.winTime = winTime;
	}

	public String getWinMessage()
	{
		return this.winMessage;
	}

	public void setWinMessage(String winMessage)
	{
		this.winMessage = winMessage;
	}
	public void setMap(String Map)
	{
		this.Map = Map;
	}
	public void setKit(String Kit)
	{
		this.Kit = Kit;
	}
	public void setCageOpenTime(long CageOpenTime)
	{
		this.CageOpenTime = CageOpenTime;
	}
	public long getCageOpenTime()
	{
		return this.CageOpenTime;
	}
}
