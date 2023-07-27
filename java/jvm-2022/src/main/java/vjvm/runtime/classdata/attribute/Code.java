package vjvm.runtime.classdata.attribute;

import lombok.var;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.runtime.JClass;
import vjvm.runtime.classdata.ConstantPool;
import vjvm.utils.UnimplementedError;

import java.io.DataInput;

@Getter
public class Code extends Attribute {
  private final int maxStack;
  private final int maxLocals;
  private final byte[] code; // the bytecode represented as raw bytes
  private final Attribute[] attributes;

  @SneakyThrows
  Code(DataInput input, ConstantPool constantPool) {
    // TODO: construct code
    maxStack = input.readUnsignedShort();
    maxLocals = input.readUnsignedShort();

    int codeLength = input.readInt();
    code = new byte[codeLength];
    input.readFully(code);

    int expectionTableLength = input.readUnsignedShort();
    byte[] ignore = new byte[8];
    for (int i = 0; i < expectionTableLength; ++i) {
      input.readFully(ignore);
    }

    int attributeCount = input.readUnsignedShort();
    attributes = new Attribute[attributeCount];
    for (int i = 0; i < attributeCount; ++i) {
      attributes[i] = constructFromData(input, constantPool);
    }
  }
}
