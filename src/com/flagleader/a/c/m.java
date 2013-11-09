package com.flagleader.a.c;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

public final class m
  implements Serializable
{
  private Vector a;
  private Hashtable b;
  private transient ClassLoader c;

  public m()
  {
    this(true);
  }

  public m(m paramm)
  {
    this.a = ((Vector)paramm.a.clone());
    this.b = ((Hashtable)paramm.b.clone());
    this.c = paramm.c;
  }

  public m(Reader paramReader)
  {
    this.a = new Vector();
    this.b = new Hashtable();
    this.a.addElement("defaults");
  }

  public m(boolean paramBoolean)
  {
    this.a = new Vector();
    this.b = new Hashtable();
  }

  public void a()
  {
    this.a.clear();
    this.b.clear();
  }

  public void b()
  {
    a();
  }

  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }

  public boolean b(String paramString)
  {
    return this.a.contains(paramString);
  }

  public Set c()
  {
    return this.b.entrySet();
  }

  public Object a(String paramString, Object paramObject)
  {
    Object localObject = this.b.get(paramString);
    return localObject != null ? localObject : paramObject;
  }

  public Object[] a(String paramString, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject1 = (Object[])this.b.get(paramString);
    if (arrayOfObject1 == null)
      return paramArrayOfObject;
    int i = arrayOfObject1.length;
    Object[] arrayOfObject2 = new Object[i];
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, i);
    return arrayOfObject2;
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    Boolean localBoolean = (Boolean)this.b.get(paramString);
    if (localBoolean == null)
      return paramBoolean;
    return localBoolean.booleanValue();
  }

  public boolean[] a(String paramString, boolean[] paramArrayOfBoolean)
  {
    Object[] arrayOfObject = (Object[])this.b.get(paramString);
    if (arrayOfObject == null)
      return paramArrayOfBoolean;
    int i = arrayOfObject.length;
    boolean[] arrayOfBoolean = new boolean[i];
    for (int j = 0; j < i; j++)
      arrayOfBoolean[j] = (arrayOfObject[j] == Boolean.TRUE ? 1 : false);
    return arrayOfBoolean;
  }

  public char a(String paramString, char paramChar)
  {
    Character localCharacter = (Character)this.b.get(paramString);
    return localCharacter == null ? paramChar : localCharacter.charValue();
  }

  public char[] a(String paramString, char[] paramArrayOfChar)
  {
    Object[] arrayOfObject = (Object[])this.b.get(paramString);
    if (arrayOfObject == null)
      return paramArrayOfChar;
    int i = arrayOfObject.length;
    char[] arrayOfChar = new char[i];
    for (int j = 0; j < i; j++)
      arrayOfChar[j] = ((Character)arrayOfObject[j]).charValue();
    return arrayOfChar;
  }

  public ClassLoader d()
  {
    return this.c;
  }

  public double a(String paramString, double paramDouble)
  {
    Number localNumber = (Number)this.b.get(paramString);
    return localNumber == null ? paramDouble : localNumber.doubleValue();
  }

  public double[] a(String paramString, double[] paramArrayOfDouble)
  {
    Object[] arrayOfObject = (Object[])this.b.get(paramString);
    if (arrayOfObject == null)
      return paramArrayOfDouble;
    int i = arrayOfObject.length;
    double[] arrayOfDouble = new double[i];
    for (int j = 0; j < i; j++)
      arrayOfDouble[j] = ((Number)arrayOfObject[j]).doubleValue();
    return arrayOfDouble;
  }

  public float a(String paramString, float paramFloat)
  {
    Number localNumber = (Number)this.b.get(paramString);
    return localNumber == null ? paramFloat : localNumber.floatValue();
  }

  public float[] a(String paramString, float[] paramArrayOfFloat)
  {
    Object[] arrayOfObject = (Object[])this.b.get(paramString);
    if (arrayOfObject == null)
      return paramArrayOfFloat;
    int i = arrayOfObject.length;
    float[] arrayOfFloat = new float[i];
    for (int j = 0; j < i; j++)
      arrayOfFloat[j] = ((Number)arrayOfObject[j]).floatValue();
    return arrayOfFloat;
  }

  public int a(String paramString, int paramInt)
  {
    Number localNumber = (Number)this.b.get(paramString);
    return localNumber == null ? paramInt : localNumber.intValue();
  }

  public int[] a(String paramString, int[] paramArrayOfInt)
  {
    Object[] arrayOfObject = (Object[])this.b.get(paramString);
    if (arrayOfObject == null)
      return paramArrayOfInt;
    int i = arrayOfObject.length;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = ((Number)arrayOfObject[j]).intValue();
    return arrayOfInt;
  }

  public long a(String paramString, long paramLong)
  {
    Number localNumber = (Number)this.b.get(paramString);
    return localNumber == null ? paramLong : localNumber.longValue();
  }

  public long[] a(String paramString, long[] paramArrayOfLong)
  {
    Object[] arrayOfObject = (Object[])this.b.get(paramString);
    if (arrayOfObject == null)
      return paramArrayOfLong;
    int i = arrayOfObject.length;
    long[] arrayOfLong = new long[i];
    for (int j = 0; j < i; j++)
      arrayOfLong[j] = ((Number)arrayOfObject[j]).longValue();
    return arrayOfLong;
  }

  public String e()
  {
    int i = this.a.size();
    return i != 0 ? (String)this.a.elementAt(i - 1) : null;
  }

  public String[] f()
  {
    int i = this.a.size();
    String[] arrayOfString = new String[i];
    this.a.copyInto(arrayOfString);
    return arrayOfString;
  }

  private InputStream d(String paramString)
  {
    if (this.c != null)
      return this.c.getResourceAsStream(paramString);
    return getClass().getResourceAsStream(paramString);
  }

  public String a(String paramString1, String paramString2)
  {
    String str = (String)this.b.get(paramString1);
    return str == null ? paramString2 : str;
  }

  public String[] a(String paramString, String[] paramArrayOfString)
  {
    Object[] arrayOfObject = (Object[])this.b.get(paramString);
    if (arrayOfObject == null)
      return paramArrayOfString;
    int i = arrayOfObject.length;
    String[] arrayOfString = new String[i];
    System.arraycopy(arrayOfObject, 0, arrayOfString, 0, i);
    return arrayOfString;
  }

  public void b(String paramString, Object paramObject)
  {
    this.b.put(paramString, paramObject);
  }

  public void a(m paramm)
  {
    int i = paramm.a.size();
    for (int j = 0; j < i; j++)
    {
      String str = (String)paramm.a.elementAt(j);
      if (this.a.contains(str))
        continue;
      this.a.addElement(str);
    }
    this.b.putAll(paramm.b);
  }

  public void b(String paramString, boolean paramBoolean)
  {
    this.b.put(paramString, paramBoolean ? Boolean.TRUE : Boolean.FALSE);
  }

  public void b(String paramString, char paramChar)
  {
    this.b.put(paramString, new Character(paramChar));
  }

  public void b(String paramString, double paramDouble)
  {
    this.b.put(paramString, new Double(paramDouble));
  }

  public void b(String paramString, float paramFloat)
  {
    this.b.put(paramString, new Float(paramFloat));
  }

  public void b(String paramString, int paramInt)
  {
    this.b.put(paramString, new Integer(paramInt));
  }

  public void b(String paramString, long paramLong)
  {
    this.b.put(paramString, new Long(paramLong));
  }

  public void b(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }

  public Object c(String paramString)
  {
    return this.b.remove(paramString);
  }

  public void a(ClassLoader paramClassLoader)
  {
    this.c = paramClassLoader;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.c.m
 * JD-Core Version:    0.6.0
 */