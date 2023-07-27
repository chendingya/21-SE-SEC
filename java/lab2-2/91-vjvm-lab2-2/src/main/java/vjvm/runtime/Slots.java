package vjvm.runtime;

import java.nio.ByteBuffer;
import java.util.Optional;

/**
 * Slots represents an array of JVM slots as defined in the specification. It
 * supports getting and putting primitive data types, including address.
 */
public class Slots {
  public final ByteBuffer buf;
  public final Class<?>[] types;

  public Slots(int slotSize) {
    buf = ByteBuffer.allocate(slotSize * 4);
    types = new Class[slotSize];
  }

  public int int_(int index) {
    if (types[index] != Integer.class) {
      throw new ClassCastException(String.format("slot %d is not a %s", index, types[index]));
    }
    return buf.getInt(index * 4);
  }

  public void int_(int index, int value) {
    types[index] = Integer.class;
    buf.putInt(index * 4, value);
  }

  public long long_(int index) {
    if (types[index] != Long.class) {
      throw new ClassCastException(String.format("slot %d is not a %s", index, types[index]));
    }
    return buf.getLong(index * 4);
  }

  public void long_(int index, long value) {
    types[index] = Long.class;
    types[index + 1] = null;
    buf.putLong(index * 4, value);
  }

  public float float_(int index) {
    if (types[index] != Float.class) {
      throw new ClassCastException(String.format("slot %d is not a %s", index, types[index]));
    }
    return buf.getFloat(index * 4);
  }

  public void float_(int index, float value) {
    types[index] = Float.class;
    buf.putFloat(index * 4, value);
  }

  public double double_(int index) {
    if (types[index] != Double.class) {
      throw new ClassCastException(String.format("slot %d is not a %s", index, types[index]));
    }
    return buf.getDouble(index * 4);
  }

  public void double_(int index, double value) {
    types[index] = Double.class;
    types[index + 1] = null;
    buf.putDouble(index * 4, value);
  }

  public byte byte_(int index) {
    return (byte) int_(index);
  }

  public void byte_(int index, byte value) {
    int_(index, value);
  }

  public char char_(int index) {
    return (char) int_(index);
  }

  public void char_(int index, char value) {
    int_(index, value);
  }

  public short short_(int index) {
    return (short) int_(index);
  }

  public void short_(int index, short value) {
    int_(index, value);
  }

  public Optional<Object> value(int index) {
    if (types[index] == null) {
      return Optional.empty();
    }

    switch (types[index].getSimpleName()) {
      case "Integer" :
        return Optional.of(int_(index));
      case "Long" :
        return Optional.of(long_(index));
      case "Float" :
        return Optional.of(float_(index));
      case "Double" :
        return Optional.of(double_(index));
      case "Byte" :
        return Optional.of(byte_(index));
      case "Character" :
        return Optional.of(char_(index));
      case "Short" :
        return Optional.of(short_(index));
      default:
        throw new ClassCastException(String.format("unexpected type %s", types[index]));

    }
  }

  public int size() {
    return buf.limit() / 4;
  }

  public void copyTo(int begin, int length, Slots dest, int destBegin) {
    // TODO: copy from this:[begin, begin+length) to dest:[destBegin,destBegin+length)
    if (dest == this && destBegin > begin) {
      for (int i = length - 1; i >= 0; i--) {
        types[destBegin + i] = types[begin + i];
        buf.putInt(4 * (destBegin + i), buf.getInt(4 * (begin + i)));
      }
    } else {
      for (int i = 0; i < length; i++) {
        dest.types[destBegin + i] = types[begin + i];
        dest.buf.putInt(4 * (destBegin + i), buf.getInt(4 * (begin + i)));
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder bu = new StringBuilder("[");
    for (int i = 0; i < size(); i++) {
      bu.append(int_(i));
      if (i != size() - 1) {
        bu.append(", ");
      }
    }
    bu.append(']');
    return bu.toString();
  }
}
