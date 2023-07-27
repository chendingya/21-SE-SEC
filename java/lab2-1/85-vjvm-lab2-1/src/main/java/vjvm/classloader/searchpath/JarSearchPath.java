package vjvm.classloader.searchpath;

import lombok.var;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.jar.JarFile;

public class JarSearchPath extends ClassSearchPath {
  // might be null if the file doesn't exist.
  private JarFile jarFile;

  @SneakyThrows
  public JarSearchPath(String name) {
    try {
      jarFile = new JarFile(name);
    } catch (FileNotFoundException e) {
      jarFile = null;
    }
  }

  @Override
  @SneakyThrows
  public InputStream findClass(String name) {
    if (jarFile == null)
      return null;

    var entry = jarFile.getEntry(name + ".class");
    return entry == null ? null : jarFile.getInputStream(entry);
  }

  @Override
  @SneakyThrows
  public void close() {
    if (jarFile != null)
      jarFile.close();
  }

}

