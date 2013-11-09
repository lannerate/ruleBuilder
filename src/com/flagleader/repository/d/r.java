package com.flagleader.repository.d;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class r
{
  public static String a(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getType().getName();
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static Object b(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).get(paramObject);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        return PropertyUtils.getProperty(paramObject, paramString);
      }
      catch (Exception localException2)
      {
        return a(paramObject, "get" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1), null);
      }
    }
    catch (Exception localException1)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException1);
  }

  public static int c(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getInt(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static float d(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getFloat(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static double e(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getDouble(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static short f(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getShort(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static long g(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getLong(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static byte h(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getByte(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static char i(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getChar(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static String j(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).get(paramObject).toString();
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static boolean k(Object paramObject, String paramString)
  {
    try
    {
      return paramObject.getClass().getField(paramString).getBoolean(paramObject);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }

  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    String str;
    try
    {
      return MethodUtils.invokeMethod(paramObject, paramString, paramArrayOfObject);
    }
    catch (Exception localException)
    {
      str = paramString + " method, ";
      for (int i = 0; i < paramArrayOfObject.length; i++)
        str = str + "the param[" + i + "]  value is " + paramArrayOfObject[i].toString();
    }
    throw new s(paramObject.getClass().getName(), str, localException);
  }

  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      paramObject1.getClass().getField(paramString).set(paramObject1, paramObject2);
    }
    catch (Exception localException1)
    {
      try
      {
        PropertyUtils.setProperty(paramObject1, paramString, paramObject2);
      }
      catch (Exception localException2)
      {
        throw new s(paramObject1.getClass().getName(), paramString, localException1);
      }
    }
  }

  public static Integer l(Object paramObject, String paramString)
  {
    try
    {
      Object localObject = PropertyUtils.getProperty(paramObject, paramString);
      if ((localObject != null) && (localObject.getClass().isArray()))
        return new Integer(Array.getLength(localObject));
      return new Integer(-1);
    }
    catch (Exception localException)
    {
    }
    throw new s(paramObject.getClass().getName(), paramString, localException);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.r
 * JD-Core Version:    0.6.0
 */