package vjvm.classloader;

import lombok.var;
import lombok.Getter;
import lombok.SneakyThrows;
import vjvm.classloader.searchpath.ClassSearchPath;
import vjvm.runtime.JClass;
import vjvm.vm.VMContext;
import vjvm.utils.UnimplementedError;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class JClassLoader implements Closeable {
  private final JClassLoader parent;
  private final ClassSearchPath[] searchPaths;
  private final HashMap<String, JClass> definedClass = new HashMap<>();
  @Getter
  private final VMContext context;

  public JClassLoader(JClassLoader parent, ClassSearchPath[] searchPaths, VMContext context) {
    this.context = context;
    this.parent = parent;
    this.searchPaths = searchPaths;
  }

  /**
   * Load class
   *
   * If a class is found, construct it using the data returned by ClassSearchPath.findClass and return it.
   *
   * Otherwise, return null.
   */
  public JClass loadClass(String descriptor) {
    // ordinary class
    assert descriptor.charAt(descriptor.length() - 1) == ';';
    var name = descriptor.substring(1,descriptor.length() - 1);
    if(parent != null && (parent.loadClass(descriptor)) != null){
      return parent.loadClass(descriptor);
    }
    if(definedClass.containsKey(name)){
      return definedClass.get(name);
    }
    for(var p : searchPaths){
      var iStream = p.findClass(name);
      if(iStream != null){
        JClass jClass = new JClass(new DataInputStream(iStream),this);
        definedClass.put(name,jClass);
        return jClass;
      }
    }
    return null;
  }


  // To construct a JClass, use the following constructor
  // return new JClass(new DataInputStream(istream_from_file), this);

  @Override
  @SneakyThrows
  public void close() {
    for (var s : searchPaths)
      s.close();
  }





}

