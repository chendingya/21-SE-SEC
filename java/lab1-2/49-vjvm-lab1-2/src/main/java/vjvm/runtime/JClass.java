package vjvm.runtime;

import vjvm.classloader.JClassLoader;
import vjvm.runtime.classdata.ConstantPool;
import vjvm.runtime.classdata.FieldInfo;
import vjvm.runtime.classdata.MethodInfo;
import vjvm.runtime.classdata.attribute.Attribute;
import vjvm.runtime.classdata.constant.ClassRef;
import vjvm.utils.UnimplementedError;
import java.io.DataInput;
import java.io.InvalidClassException;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.var;

import static vjvm.classfiledefs.ClassAccessFlags.*;

public class JClass {

  @Getter
  private final String name;
  @Getter
  private final JClassLoader classLoader;
  @Getter
  private final int minorVersion;
  @Getter
  private final int majorVersion;
  @Getter
  private final ConstantPool constantPool;
  @Getter
  private final int accessFlags;
  @Getter
  public final ClassRef thisClass;
  @Getter
  public final ClassRef superClass;
  public final ClassRef[] interfaces;
  public final FieldInfo[] fields;
  public final MethodInfo[] methods;
  public final Attribute[] attributes;
  public int fieldCount;
  public int methodCount;
  public int interfacesCount;
  @SneakyThrows
  public JClass(DataInput dataInput, JClassLoader classLoader) {
    this.classLoader = classLoader;

    // check magic number
    var magic = dataInput.readInt();
    if (magic != 0xcafebabe) {
      throw new InvalidClassException(String.format(
        "Wrong magic number, expected: 0xcafebabe, got: 0x%x", magic));
    }

    // parse data
    // skip class version check
    minorVersion = dataInput.readUnsignedShort();
    majorVersion = dataInput.readUnsignedShort();

    constantPool = new ConstantPool(dataInput, this);
    accessFlags = dataInput.readUnsignedShort();
    thisClass = (ClassRef) constantPool.constant(dataInput.readUnsignedShort());
    name = thisClass().name();

    var superIndex = dataInput.readUnsignedShort();
    superClass = superIndex == 0 ? null : (ClassRef) constantPool.constant(superIndex);

    interfacesCount = dataInput.readUnsignedShort();
    interfaces = new ClassRef[interfacesCount];
    for (int i = 0; i < interfacesCount; ++i) {
      var interfaceIndex = dataInput.readUnsignedShort();
      interfaces[i] = (ClassRef) constantPool.constant(interfaceIndex);
    }

    fieldCount = dataInput.readUnsignedShort();
    fields = new FieldInfo[fieldCount];
    for (int i = 0; i < fieldCount; ++i) {
      fields[i] = new FieldInfo(dataInput, this);
    }

    methodCount = dataInput.readUnsignedShort();
    methods = new MethodInfo[methodCount];
    for (int i = 0; i < methodCount; ++i) {
      methods[i] = new MethodInfo(dataInput, this);
    }

    var attributeCount = dataInput.readUnsignedShort();
    attributes = new Attribute[attributeCount];
    for (int i = 0; i < attributeCount; ++i) {
      attributes[i] = Attribute.constructFromData(dataInput, constantPool);
    }
//    throw new UnimplementedError(
//        "TODO: you need to construct thisClass, superClass, interfaces, fields, "
//        + "methods, and attributes from dataInput in lab 1.2; remove this for lab 1.1");
  }

  public boolean public_() {
    return (accessFlags & ACC_PUBLIC) != 0;
  }

  public boolean final_() {
    return (accessFlags & ACC_FINAL) != 0;
  }

  public boolean super_() {
    return (accessFlags & ACC_SUPER) != 0;
  }

  public boolean interface_() {
    return (accessFlags & ACC_INTERFACE) != 0;
  }

  public boolean abstract_() {
    return (accessFlags & ACC_ABSTRACT) != 0;
  }

  public boolean synthetic() {
    return (accessFlags & ACC_SYNTHETIC) != 0;
  }

  public boolean annotation() {
    return (accessFlags & ACC_ANNOTATION) != 0;
  }

  public boolean enum_() {
    return (accessFlags & ACC_ENUM) != 0;
  }

  public boolean module() {
    return (accessFlags & ACC_MODULE) != 0;
  }

//  public int fieldsCount() {
//    return fields.length;
//  }
//
//  public FieldInfo field(int index) {
//    return fields[index];
//  }
//
//  public int methodsCount() {
//    return methods.length;
//  }
//
//  public MethodInfo method(int index) {
//    return methods[index];
//  }

}
