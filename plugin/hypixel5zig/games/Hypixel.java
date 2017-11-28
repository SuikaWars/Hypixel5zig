package plugin.hypixel5zig.games;

import eu.the5zig.mod.server.GameMode;

public abstract class Hypixel extends GameMode {
	private String Kit;
	private long CageOpenTime;
	public void setKit(String Kit1)
	{
		Kit = Kit1;
	}
	public String getKit()
	{
		return Kit;
	}
	public void setCageOpenTime(long CageOpenTime1)
	{
		CageOpenTime = CageOpenTime1;
	}
	public long getCageOpenTime()
	{
		return CageOpenTime;
	}
}
