package github.pitbox46.graaljs;

import com.oracle.truffle.js.scriptengine.GraalJSScriptEngine;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Mod("graaljs")
public class MinecraftMod {
    public static final GraalJSScriptEngine GRAAL_JS = ((GraalJSScriptEngine) new ScriptEngineManager().getEngineByName("Graal.js"));

//    Testing Only
//
//    public MinecraftMod() {
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//    @SubscribeEvent
//    public void onClientStart(TickEvent.ClientTickEvent event) {
//        String script =
//                """
//                function func() {
//                    var q = 1;
//                    for(var i = 1; i < 10; i++) {
//                        q *= i;
//                        q += i;
//                    }
//                    return q;
//                }
//                """;
//        try {
//            GRAAL_JS.eval(script);
//            System.out.println(GRAAL_JS.invokeFunction("func"));
//        } catch (ScriptException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//    }
}
