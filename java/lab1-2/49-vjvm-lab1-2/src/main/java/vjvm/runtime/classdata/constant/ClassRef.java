package vjvm.runtime.classdata.constant;

import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.runtime.JClass;
import java.io.DataInput;

public class ClassRef extends Constant {
  @Getter
  private final int index;
  private final JClass self;
  private String name;


   @SneakyThrows
   ClassRef(DataInput input, JClass thisClass) {
     index = input.readUnsignedShort();
     this.self = thisClass;
  }

  public String name() {
     if (name == null) {
       name = ((UTF8Constant) self.constantPool().constant(index)).value();
     }
     return name;
  }

  @Override
  public String toString() {
     return String.format("Classref: %s", name());
  }


}
