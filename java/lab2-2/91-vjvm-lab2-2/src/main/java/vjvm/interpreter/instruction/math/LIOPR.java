package vjvm.interpreter.instruction.math;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

import java.util.function.BiFunction;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LIOPR extends Instruction {
  private final BiFunction<Long, Integer, Long> opr;
  private final String name;

  public static LIOPR LSHR(ProgramCounter pc, MethodInfo method){
    return new LIOPR((x,y)-> x >> y,"lshr");
  }
  public static LIOPR LUSHR(ProgramCounter pc,MethodInfo method){
    return new LIOPR((x,y)-> x >>> y,"lushr");
  }
  public static LIOPR LSHL(ProgramCounter pc,MethodInfo method){
    return new LIOPR((x,y)-> x << y,"lshl");
  }
  @Override
  public void run(JThread thread) {
    OperandStack stack = thread.top().stack();
    int right = stack.popInt();
    long left = stack.popLong();
    stack.pushLong(opr.apply(left,right));
  }

  @Override
  public String toString() {
    return name;
  }
}

