package vjvm.interpreter.instruction.comparisons;

import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

public class LCMP extends Instruction {
  public LCMP(ProgramCounter pc, MethodInfo method) {

  }

  @Override
  public void run(JThread thread) {
    OperandStack stack = thread.top().stack();
    long right = stack.popLong();
    long left = stack.popLong();
    if (left < right) {
      stack.pushInt(-1);
    } else if (left == right) {
      stack.pushInt(0);
    } else {
      stack.pushInt(1);
    }
  }

  @Override
  public String toString() {
    return "lcmp";
  }
}
