package vjvm.runtime.classdata.constant;

import lombok.SneakyThrows;
import org.apache.commons.text.StringEscapeUtils;
import vjvm.runtime.JClass;

import java.io.DataInput;

public class InterfaceMethodRef extends Constant{
  private final int nameIndex;
  private final int descriptorIndex;
  private final JClass self;

  private String name;
  private String descriptor;

  @SneakyThrows
  InterfaceMethodRef(DataInput input, JClass jClass) {
    nameIndex = input.readUnsignedShort();
    descriptorIndex = input.readUnsignedShort();
    this.self = jClass;
  }

  public String name(){
    if(name == null){
      name = ((ClassRef)(self.constantPool().constant(nameIndex))).name();
    }
    return name;
  }

  public String type(){
    if(descriptor == null){
      descriptor = ((NameAndTypeConstant)(self.constantPool().constant(descriptorIndex))).name()
        + ":" + ((NameAndTypeConstant)(self.constantPool().constant(descriptorIndex))).type();
    }
    return descriptor;
  }

  @Override
  public String toString() {
    return String.format("InterfaceMethodref: %s:%s", StringEscapeUtils.escapeJava(name()),type());
  }
}

