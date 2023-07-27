package vjvm.interpreter.instruction.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.classdata.ConstantPool;
import vjvm.runtime.classdata.MethodInfo;
import vjvm.runtime.classdata.constant.*;

import javax.tools.Diagnostic;
import java.time.chrono.MinguoDate;
import java.util.function.BiConsumer;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LDCX extends Instruction {
  private final int index;
  private final ConstantPool cp;
  private String name;

  public static LDCX LDC(ProgramCounter pc, MethodInfo method) {
    return new LDCX(pc.ubyte(),method.jClass().constantPool(),"ldc");
  }
  public static LDCX LDCW(ProgramCounter pc,MethodInfo method){
    return new LDCX(pc.ushort(),method.jClass().constantPool(),"ldcw");
  }
  public static LDCX LDC2W(ProgramCounter pc,MethodInfo method){
    return new LDCX(pc.ushort(),method.jClass().constantPool(),"ldc2w");
  }
  @Override
  public void run(JThread thread) {
    OperandStack stack = thread.top().stack();
    switch (cp.constant(index).getClass().getSimpleName()){
      case "IntegerConstant":
        int value1 = ((IntegerConstant) (cp.constant(index))).value();
        stack.pushInt(value1);
        break;
      case "FloatConstant":
        float value2 = ((FloatConstant) (cp.constant(index))).value();
        stack.pushFloat(value2);
        break;
      case "DoubleConstant":
        double value3 = ((DoubleConstant) (cp.constant(index))).value();
        stack.pushDouble(value3);
        break;
      case "LongConstant":
        long value4 = ((LongConstant) (cp.constant(index))).value();
        stack.pushLong(value4);
        break;
    }
  }

  @Override
  public String toString() {
    return name;
  }
}
