package com.flagleader.builder.widget;

import com.flagleader.sql.SerializationUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

public class c extends ByteArrayTransfer
{
  private static final String a = "RuleProperties";
  private static final int b = registerType("RuleProperties");
  private static c c = new c();

  public static c a()
  {
    return c;
  }

  public void javaToNative(Object paramObject, TransferData paramTransferData)
  {
    if ((paramObject == null) || (!(paramObject instanceof ArrayList)))
      return;
    if (isSupportedType(paramTransferData))
    {
      ArrayList localArrayList = (ArrayList)paramObject;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localByteArrayOutputStream.write(SerializationUtils.serialize(localArrayList));
        localByteArrayOutputStream.close();
        byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
        super.javaToNative(arrayOfByte, paramTransferData);
      }
      catch (IOException localIOException)
      {
      }
    }
  }

  public Object nativeToJava(TransferData paramTransferData)
  {
    try
    {
      if (isSupportedType(paramTransferData))
      {
        byte[] arrayOfByte = (byte[])super.nativeToJava(paramTransferData);
        if (arrayOfByte == null)
          return null;
        return SerializationUtils.deserialize(arrayOfByte);
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  protected String[] getTypeNames()
  {
    return new String[] { "RuleProperties" };
  }

  protected int[] getTypeIds()
  {
    return new int[] { b };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.c
 * JD-Core Version:    0.6.0
 */