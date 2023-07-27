package vjvm.runtime.classdata.constant;

import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.runtime.JClass;

import java.io.DataInput;

public class FieldRef extends Constant{
  @Getter
  private final int nameIndex;
  @Getter
  private final int descriptorIndex;
  private final JClass self;
  private String name;
  private String descriptor;

  @SneakyThrows
  FieldRef(DataInput input, JClass self) {
    nameIndex = input.readUnsignedShort();
    descriptorIndex = input.readUnsignedShort();
    this.self = self;
  }

  public String name() {
    if (name == null) {
      name = ((ClassRef) (self.constantPool().constant(nameIndex))).name();
    }
    return name;
  }

  public String type() {
    if (descriptor == null) {
      descriptor = ((NameAndTypeConstant)(self.constantPool().constant(descriptorIndex))).name()
        + ":" + ((NameAndTypeConstant)(self.constantPool().constant(descriptorIndex))).type();
    }
    return descriptor;
  }

  @Override
  public String toString() {
    return String.format("Fieldref: %s:%s",name(),type());
  }
}
