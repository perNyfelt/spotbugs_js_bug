package se.alipsa.spotbugsbug;

import org.junit.jupiter.api.Test;

import javax.script.CompiledScript;
import javax.script.ScriptException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScriptRunnerTest {

  @Test
  public void testScriptRunner() throws ScriptException, NoSuchMethodException {
    ScriptRunner scriptRunner = new ScriptRunner();
    CompiledScript function = scriptRunner.compile("function meaningOfLife() { return 42 }");
    Object result = scriptRunner.run(function, "meaningOfLife");
    assertEquals(42, result);
  }
}
