package vjvm.interpreter.instruction.comparisons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.MethodInfo;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XCMPCOND<T> extends Instruction {
  private final int nanValue;
  private final String name;
  private final Function<OperandStack,T> popFunc;
  private final BiFunction<T,T,Integer> compareFunc;
  private final Predicate<T> nanFunc;
  public static XCMPCOND<Double> DCMPG(ProgramCounter pc, MethodInfo method){
    return new XCMPCOND<>(1,"dcmpg",OperandStack::popDouble,Double::compare,XCMPCOND::doubleIsNan);
  }
  public static XCMPCOND<Double> DCMPL(ProgramCounter pc, MethodInfo method){
    return new XCMPCOND<>(-1,"dcmpl",OperandStack::popDouble,Double::compare,XCMPCOND::doubleIsNan);
  }
  public static XCMPCOND<Float> FCMPG(ProgramCounter pc,MethodInfo method){
    return new XCMPCOND<>(1,"fcmpg",OperandStack::popFloat,Float::compare,XCMPCOND::floatIsNan);
  }
  public static XCMPCOND<Float> FCMPL(ProgramCounter pc,MethodInfo method){
    return new XCMPCOND<>(-1,"fcmpl",OperandStack::popFloat,Float::compare,XCMPCOND::floatIsNan);
  }
  private static boolean floatIsNan(float f){
    return Float.isNaN(f);
  }
  private static boolean doubleIsNan(double d){
    return Double.isNaN(d);
  }
  @Override
  public void run(JThread thread) {
    OperandStack stack = thread.top().stack();
    T right = popFunc.apply(stack);
    T left = popFunc.apply(stack);
    if (nanFunc.test(left)||nanFunc.test(right)){
      stack.pushInt(nanValue);
      return;
      //TODO:小心这里是不是有return
    }
    stack.pushInt(compareFunc.apply(left,right));
  }

  @Override
  public String toString() {
    return name;
  }
}
