package vjvm.runtime.classdata.constant;

import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.text.StringEscapeUtils;
import vjvm.runtime.JClass;

import java.io.DataInput;
import java.io.InputStream;

public class StringConstant extends Constant{
  @Getter
  private final int stringIndex;
  private final JClass thisClass;

  @SneakyThrows
  StringConstant(DataInput input, JClass thisClass) {
    stringIndex = input.readUnsignedShort();
    this.thisClass = thisClass;
  }

  private String utf8Constant(){
    return ((UTF8Constant) thisClass.constantPool().constant(stringIndex)).value();
  }

  @Override
  public String toString() {
    return String.format("String: \"%s\"", StringEscapeUtils.escapeJava(utf8Constant()));
  }
}
