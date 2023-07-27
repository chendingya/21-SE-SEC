package vjvm.runtime.classdata.constant;

import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.classfiledefs.Descriptors;
import vjvm.runtime.JClass;
import java.io.DataInput;

public class ClassRef extends Constant {
  @Getter
  private final int index;
  private final JClass self;
  private String name;
  private JClass ref;

   @SneakyThrows
   ClassRef(DataInput input, JClass thisClass) {
     index = input.readUnsignedShort();
     this.self = thisClass;
  }
  public ClassRef(String name, JClass thisClass) {
     this.name = name;
     this.self = thisClass;
     this.index = 0;
  }

  public String name() {
     if (name == null) {
       name = ((UTF8Constant) self.constantPool().constant(index)).value();
     }
     return name;
  }

public JClass value() {
    if (ref != null) {
      return ref;
    }

    //check whether the reference points to this class
    if (name().equals(self.thisClass().name())) {
      ref = self;
    } else {
      // if not, load the Class using the defining class loader of this class
      ref = self.classLoader().loadClass(Descriptors.of(name()));
    }

    return ref;
  }
  @Override
  public String toString() {
     return String.format("Classref: %s", name());
  }



}
