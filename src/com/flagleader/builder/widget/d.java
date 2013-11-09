package com.flagleader.builder.widget;

import com.flagleader.repository.IElement;
import com.flagleader.sql.SerializationUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

public class d extends ByteArrayTransfer
{
  private static final String a = "RuleElement";
  private static final int b = registerType("RuleElement");
  private static d c = new d();

  public static d a()
  {
    return c;
  }

  public void javaToNative(Object paramObject, TransferData paramTransferData)
  {
    if ((paramObject == null) || (!(paramObject instanceof IElement)))
      return;
    if (isSupportedType(paramTransferData))
    {
      IElement localIElement = (IElement)paramObject;
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localByteArrayOutputStream.write(SerializationUtils.serialize(localIElement));
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
    return new String[] { "RuleElement" };
  }

  protected int[] getTypeIds()
  {
    return new int[] { b };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.d
 * JD-Core Version:    0.6.0
 */