package OpenEngine.Lua;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

import OpenEngine.Core.Game;

public class LuaCompiler {
	public static void Compile(String path,Game game) {
		Globals globals = JsePlatform.standardGlobals();
		LuaValue chunk = globals.loadfile("res/scripts/"+path);
		LuaValue test = CoerceJavaToLua.coerce(game);
		globals.set("game", test);

		chunk.call();
	}
}
