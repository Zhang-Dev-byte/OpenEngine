package Game;

import OpenEngine.Core.CoreEngine;

public class Core {
	public static void main(String[] args)
	{
		CoreEngine engine = new CoreEngine(800, 600, 60, new TestGame());
		engine.CreateWindow("3D Game Engine");
		engine.Start();
	}
}
