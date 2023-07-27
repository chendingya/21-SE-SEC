package vjvm.interpreter.instruction.stores;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.var;
import vjvm.interpreter.instruction.Instruction;
import vjvm.runtime.JThread;
import vjvm.runtime.OperandStack;
import vjvm.runtime.ProgramCounter;
import vjvm.runtime.Slots;
import vjvm.runtime.classdata.MethodInfo;

import java.util.function.Function;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XSTORE<T> extends Instruction {
  private final Function<OperandStack, T> popFunc;
  private final TriConsumer<Slots, Integer, T> putFunc;
  private final int index;
  private final String name;

  public static XSTORE<Integer> ISTORE(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popInt, Slots::int_, pc.ubyte(), "istore");
  }
  public static XSTORE<Integer> ISTORE_0(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popInt, Slots::int_, 0, "istore");
  }
  public static XSTORE<Integer> ISTORE_1(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popInt, Slots::int_, 1, "istore");
  }
  public static XSTORE<Integer> ISTORE_2(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popInt, Slots::int_, 2, "istore");
  }
  public static XSTORE<Integer> ISTORE_3(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popInt, Slots::int_, 3, "istore");
  }
  public static XSTORE<Long> LSTORE(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popLong, Slots::long_, pc.ubyte(), "lstore");
  }
  public static XSTORE<Long> LSTORE_0(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popLong, Slots::long_, 0, "lstore");
  }
  public static XSTORE<Long> LSTORE_1(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popLong, Slots::long_, 1, "lstore");
  }
  public static XSTORE<Long> LSTORE_2(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popLong, Slots::long_, 2, "lstore");
  }
  public static XSTORE<Long> LSTORE_3(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popLong, Slots::long_, 3, "lstore");
  }
  public static XSTORE<Float> FSTORE(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popFloat, Slots::float_, pc.ubyte(), "fstore");
  }
  public static XSTORE<Float> FSTORE_0(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popFloat, Slots::float_, 0, "fstore");
  }
  public static XSTORE<Float> FSTORE_1(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popFloat, Slots::float_, 1, "fstore");
  }
  public static XSTORE<Float> FSTORE_2(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popFloat, Slots::float_, 2, "fstore");
  }
  public static XSTORE<Float> FSTORE_3(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popFloat, Slots::float_, 3, "fstore");
  }
  public static XSTORE<Double> DSTORE(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popDouble, Slots::double_, pc.ubyte(), "dstore");
  }
  public static XSTORE<Double> DSTORE_0(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popDouble, Slots::double_, 0, "dstore");
  }
  public static XSTORE<Double> DSTORE_1(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popDouble, Slots::double_, 1, "dstore");
  }
  public static XSTORE<Double> DSTORE_2(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popDouble, Slots::double_, 2, "dstore");
  }
  public static XSTORE<Double> DSTORE_3(ProgramCounter pc, MethodInfo method) {
    return new XSTORE<>(OperandStack::popDouble, Slots::double_, 3, "dstore");
  }

  @Override
  public void run(JThread thread) {
    var frame = thread.top();
    var var = popFunc.apply(frame.stack());
    putFunc.accept(frame.vars(), index, var);
  }

  @Override
  public String toString() {
    return String.format("%s %d", name, index);
  }
}
