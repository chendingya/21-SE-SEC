package vjvm.runtime.classdata.constant;

import lombok.SneakyThrows;
import org.apache.commons.text.StringEscapeUtils;
import vjvm.runtime.JClass;
import vjvm.runtime.classdata.MethodInfo;
import java.lang.String;
import java.io.DataInput;

public class MethodRef extends Constant {
  private final int classIndex;
  private final int nameAndTypeIndex;
  private final JClass self;
  private String classRef;
  private ClassRef ClassRef;
  private String nameAndType;
  private MethodInfo method;
  @SneakyThrows
  MethodRef(DataInput input, JClass self) {
    classIndex = input.readUnsignedShort();
    nameAndTypeIndex = input.readUnsignedShort();
    this.self = self;
  }
  public JClass jClass() {
    return ClassRef().value();
  }
  public ClassRef ClassRef() {
    if (ClassRef == null) {
      ClassRef = (ClassRef)self.constantPool().constant(classIndex);
    }
    return ClassRef;
  }
  public String className() {
    if (classRef == null) {
      classRef = ((ClassRef)self.constantPool().constant(classIndex)).name();
    }
    return classRef;
  }

  public String nameAndType() {
    if (nameAndType == null) {
      nameAndType = ((NameAndTypeConstant)(self.constantPool().constant(nameAndTypeIndex))).name()
      + ":" + ((NameAndTypeConstant)(self.constantPool().constant(nameAndTypeIndex))).type();
    }

    return nameAndType;
  }

  public MethodInfo value() {
    if (method != null) {
      return method;
    }
    method = jClass().findMethod(((NameAndTypeConstant) (self.constantPool().constant(nameAndTypeIndex)) ).name(),
      ((NameAndTypeConstant) (self.constantPool().constant(nameAndTypeIndex)) ).type());
    if (method == null) {
      throw new Error("No such method");
    }
    return method;
  }

  @Override
  public String toString() {
    return String.format("Methodref: %s:%s", StringEscapeUtils.escapeJava(className()), nameAndType());
  }

}
