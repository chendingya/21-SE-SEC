package vjvm.interpreter.instruction.comparisons;

import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

import java.util.function.Function;
import java.util.function.Predicate;


public class IFCOND extends Instruction {
  private final Function<OperandStack,Integer> popFunc;
  private final Predicate<Integer> pred;
  private final int offset;
  private final String name;
  private IFCOND(Function<OperandStack,Integer> popFunc,Predicate<Integer> pred,ProgramCounter pc,String name){
    this.popFunc=popFunc;
    this.pred=pred;
    this.offset=pc.short_()-3;
    this.name=name;
  }
  public static IFCOND IFEQ(ProgramCounter pc, MethodInfo method){
    return new IFCOND(OperandStack::popInt,x->x==0,pc,"ifeq");
  }
  public static IFCOND IFNE(ProgramCounter pc, MethodInfo method){
    return new IFCOND(OperandStack::popInt,x->x!=0,pc,"ifne");
  }
  public static IFCOND IFLT(ProgramCounter pc, MethodInfo method){
    return new IFCOND(OperandStack::popInt,x->x<0,pc,"iflt");
  }
  public static IFCOND IFLE(ProgramCounter pc, MethodInfo method){
    return new IFCOND(OperandStack::popInt,x->x<=0,pc,"ifle");
  }
  public static IFCOND IFGT(ProgramCounter pc, MethodInfo method){
    return new IFCOND(OperandStack::popInt,x->x>0,pc,"ifgt");
  }
  public static IFCOND IFGE(ProgramCounter pc, MethodInfo method){
    return new IFCOND(OperandStack::popInt,x->x>=0,pc,"ifge");
  }
  @Override
  public void run(JThread thread) {
    OperandStack stack = thread.top().stack();
    int value = popFunc.apply(stack);
    ProgramCounter pc = thread.pc();
    if (pred.test(value)){
      pc.move(offset);
    }
  }

  @Override
  public String toString() {
    return name;
  }
}
