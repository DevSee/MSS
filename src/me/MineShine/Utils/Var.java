package me.MineShine.Utils;

public class Var 
{
	static Var var;
	public static Var getInstance()
	{
		return var;
	}
	
	// GlobalMute
	public boolean ChatMuted;
	// Checks if all Components work fine (SET ONLY WHEN A SEVERE HAPPENS)
	public boolean pluginWorksProperly;
	// Chat Restriction
	public int TimeToChat;
}
