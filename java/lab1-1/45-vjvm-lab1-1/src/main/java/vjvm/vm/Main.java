package vjvm.vm;

import com.sun.javafx.binding.LongConstant;
import lombok.var;
import picocli.CommandLine;
import vjvm.classfiledefs.Descriptors;
import vjvm.runtime.JClass;
import vjvm.utils.UnimplementedError;

import java.util.concurrent.Callable;

import static picocli.CommandLine.*;

@Command(name = "vjvm", mixinStandardHelpOptions = true, version = "vjvm 0.0.1", description = "A toy JVM written in java", subcommands = {
  Run.class, Dump.class})
public class Main implements Callable<Integer> {
  @Option(names = {"-cp",
    "--classpath"}, paramLabel = "CLASSPATH", description = "the class path to search, multiple paths should be separated by ':'")
  String userClassPath = ".";

  public static void main(String[] args) {
    System.exit(new CommandLine(new Main()).execute(args));
  }

  @Override
  public Integer call() {
    CommandLine.usage(this, System.err);
    return -1;
  }
}

@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
@Command(name = "run", description = "Execute java program")
class Run implements Callable<Integer> {
  @ParentCommand
  private Main parent;

  @Parameters(index = "0", description = "Class to run, e.g. vjvm.vm.Main")
  private String entryClass = "";

  @Parameters(index = "1..*", description = "Arguments passed to java program")
  private String[] args = {};

  @Override
  public Integer call() {
    throw new UnimplementedError("You will implement this in lab 2");
  }

}

@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
@Command(name = "dump", description = "Dump class file")
class Dump implements Callable<Integer> {
  @ParentCommand
  private Main parent;

  @Parameters(index = "0", description = "Class to dump, e.g. java.lang.String")
  private String className = "";

  @Override
  public Integer call() {
    var ctx = new VMContext(parent.userClassPath);

    // the package vjvm.classfiledefs contains some constants and utility
    // functions that we provided for your convenience
    // please check the individual files for more information
    var descriptor = Descriptors.of(className);

    var clazz = ctx.userLoader().loadClass(descriptor);
    if (clazz == null) {
      // you can print anything to System.err; we won't check it
      System.err.printf("Can not find class %s\n", className);
      return -1;
    }

    dump(clazz);
    return 0;
  }

  private void dump(JClass c) {
    //throw new UnimplementedError("TODO: dump clazz in lab 1.2; remove this for 1.1");
    var out = System.out;
    out.printf("\nclass name: %s\nminor version: %d\nmajor version: %d\nflags: 0x%x\nthis class: %s\nsuoer class: %s\n\n",
      c.name(), c.minorVersion, c.majorVersion(), c.accessFlags(), c.thisClass().name(), c.superClass().name());

    out.printf("\nconstant pool:\n");
    var p = c.constantPool();
    for (int i = 1; i < p.size();) {
      var v = p.constant(i);
      out.printf("#%d = %s\n", i, v);

      int size = 1;
      if (v instanceof LongConstant || v instanceof DoubleConstant) {
         size = 2;
      }
      i += size;
    }
    out.printf("\nnterfaces:\n");
    for (int i = 0; i < c.superInterfacesCount(); i++) {
      var s = c.superInterface(i);
      out.printf("%s\n", s.name());
    }

  }
}
