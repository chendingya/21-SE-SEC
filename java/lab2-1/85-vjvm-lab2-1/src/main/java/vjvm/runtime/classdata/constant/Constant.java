package vjvm.runtime.classdata.constant;

import lombok.var;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.Pair;
import vjvm.runtime.JClass;

import java.io.DataInput;

import static vjvm.classfiledefs.ConstantTags.*;

public abstract class Constant {
  public abstract class MethodRefConstant extends Constant{
  }
  @SneakyThrows
  public static Pair<Constant, Integer> constructFromData(DataInput input, JClass jClass) {
    var tag = input.readByte();
    int count = 1;

    // TODO: construct Utf8, Float, Double Class, Fieldref, Methodref, InterfaceMethodref, String, and Long
    Constant result;
    switch (tag) {
      case CONSTANT_Integer:
        result = new IntegerConstant(input);
        break;
      case CONSTANT_NameAndType:
        result = new NameAndTypeConstant(input, jClass);
        break;
      case CONSTANT_Utf8: {
        result = new UTF8Constant(input);
        break;
      }
      case CONSTANT_Double:
        result = new DoubleConstant(input);
        count = 2;
        break;
      case CONSTANT_Long:
        result = new LongConstant(input);
        count = 2;
        break;
      case CONSTANT_MethodType:
      case CONSTANT_MethodHandle:
        result = new UnknownConstant(input, 3);
        break;
      case CONSTANT_String:
        result = new StringConstant(input, jClass);
        break;
      case CONSTANT_Class:
        result = new ClassRef(input,jClass);
        break;
      case CONSTANT_Float:
        result = new FloatConstant(input);
        break;
      case CONSTANT_Fieldref:
        result = new FieldRef(input,jClass);
        break;
      case CONSTANT_Methodref:
        result = new MethodRef(input, jClass);
        break;
      case CONSTANT_InterfaceMethodref:
        result = new InterfaceMethodRef(input,jClass);
        break;
      case CONSTANT_Dynamic:
      case CONSTANT_InvokeDynamic:
        result = new UnknownConstant(input, 4);
        break;
      default:
        throw new ClassFormatError();
    }

    return Pair.of(result, count);
  }
  public abstract String toString();
}
