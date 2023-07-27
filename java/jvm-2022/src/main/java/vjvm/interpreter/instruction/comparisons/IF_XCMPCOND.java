package vjvm.interpreter.instruction.comparisons;

import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

import java.util.Objects;
import java.util.function.BiPredicate;

public class IF_XCMPCOND extends Instruction {
  private final BiPredicate<Integer, Integer> pred;
  private final String name;
  private final int offset;
  private IF_XCMPCOND(BiPredicate<Integer,Integer> pred,String name,ProgramCounter pc){
    this.pred=pred;
    this.name=name;
    this.offset=pc.short_()-3;
  }
  public static IF_XCMPCOND IF_ACMPEQ(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND(Objects::equals,"if_acmpeq",pc);
  }
  public static IF_XCMPCOND IF_ACMPNE(ProgramCounter pc, MethodInfo method){
    return new IF_XCMPCOND((x,y)-> !Objects.equals(x, y),"if_acmpne",pc);
  }
  public static IF_XCMPCOND IF_ICMPEQ(ProgramCounter pc,MethodInfo method){
    return new IF_XCMPCOND(Objects::equals,"if_icmpeq",pc);
  }
  public static IF_XCMPCOND IF_ICMPNE(ProgramCounter pc,MethodInfo method){
    return new IF_XCMPCOND((x,y)-> !Objects.equals(x, y),"if_icmpne",pc);
  }
  public static IF_XCMPCOND IF_ICMPLT(ProgramCounter pc,MethodInfo method){
    return new IF_XCMPCOND((x,y)->x<y,"if_icmplt",pc);
  }
  public static IF_XCMPCOND IF_ICMPLE(ProgramCounter pc,MethodInfo method){
    return new IF_XCMPCOND((x,y)->x<=y,"if_icmple",pc);
  }
  public static IF_XCMPCOND IF_ICMPGE(ProgramCounter pc,MethodInfo method){
    return new IF_XCMPCOND((x,y)->x>=y,"if_icmpge",pc);
  }
  public static IF_XCMPCOND IF_ICMPGT(ProgramCounter pc,MethodInfo method){
    return new IF_XCMPCOND((x,y)->x>y,"if_icmpgt",pc);
  }
  @Override

  public void run(JThread thread) {
    OperandStack stack = thread.top().stack();
    int right = stack.popInt();
    int left = stack.popInt();
    ProgramCounter pc = thread.pc();
    if (pred.test(left,right)){
      pc.move(offset);
    }
  }

  @Override
  public String toString() {
    return name;
  }
}
