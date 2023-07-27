package vjvm.runtime.classdata.constant;

import lombok.SneakyThrows;
import org.apache.commons.text.StringEscapeUtils;
import vjvm.runtime.JClass;

import lombok.Getter;
import java.io.DataInput;

public class MethodRef extends Constant {
  private final int classIndex;
  private final int nameAndTypeIndex;
  private final JClass self;

  private String className;
  private String nameAndType;

  @SneakyThrows
  MethodRef(DataInput input, JClass self) {
    classIndex = input.readUnsignedShort();
    nameAndTypeIndex = input.readUnsignedShort();
    this.self = self;
  }

  public String className() {
    if (className == null) {
      className = ((ClassRef)self.constantPool().constant(classIndex)).name();
    }
    return className;
  }

  public String nameAndType() {
    if (nameAndType == null) {
      nameAndType = ((NameAndTypeConstant)(self.constantPool().constant(nameAndTypeIndex))).name()
      + ":" + ((NameAndTypeConstant)(self.constantPool().constant(nameAndTypeIndex))).type();
    }

    return nameAndType;
  }

  @Override
  public String toString() {
    return String.format("Methodref: %s:%s", StringEscapeUtils.escapeJava(className()), nameAndType());
  }
}
