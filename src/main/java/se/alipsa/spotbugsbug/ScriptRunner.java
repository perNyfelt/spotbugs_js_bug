package se.alipsa.spotbugsbug;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import jdk.nashorn.internal.objects.NativeArray;

import javax.script.*;

public class ScriptRunner {

  private ScriptEngine engine;

  public ScriptRunner() {
    NashornScriptEngineFactory nashornScriptEngineFactory = new NashornScriptEngineFactory();
    String[] options = new String[]{"--language=es6"};
    engine = nashornScriptEngineFactory.getScriptEngine(options);
  }

  public Object run(CompiledScript script, String function, Object... args) throws ScriptException, NoSuchMethodException {
    script.eval();
    Object result = ((Invocable) engine).invokeFunction(function, args);
    if (result instanceof NativeArray) {
      System.out.println("This instanceof check fails with spotbugs");
    }
    return result;
  }

  public CompiledScript compile(String script) throws ScriptException {
    return ((Compilable) (engine)).compile(script);
  }

}
