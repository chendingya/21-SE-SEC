package vjvm.interpreter.instruction.constants;

import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

public class NOP extends Instruction {

  @Override
  public void run(JThread thread) {

  }

  public NOP(ProgramCounter pc, MethodInfo method) {
  }

  @Override
  public String toString() {
    return "nop";
  }
}
