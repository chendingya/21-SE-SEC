package vjvm.interpreter.instruction.control;

import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

public class GOTO extends Instruction {
  private final int offset;
  public GOTO(ProgramCounter pc, MethodInfo method){
    offset = pc.short_() - 3;
  }
  @Override
  public void run(JThread thread) {
    ProgramCounter pc = thread.pc();
    pc.move(offset);
  }

  @Override
  public String toString() {
    return String.format("goto %d",offset);
  }
}
