package com.flagleader.repository.db;

import com.flagleader.engine.Property;
import com.flagleader.repository.f;
import com.flagleader.repository.lang.g;
import com.flagleader.util.DateUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TempID;
import java.io.Serializable;

public class SheetValue
  implements f, Serializable
{
  private String value = "";
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public SheetValue()
  {
  }

  public SheetValue(String paramString)
  {
    this.value = paramString;
  }

  public SheetValue(Object[] paramArrayOfObject, g[] paramArrayOfg)
  {
    setValues(paramArrayOfObject, paramArrayOfg);
  }

  public SheetValue(SheetValue paramSheetValue)
  {
    this.value = paramSheetValue.value;
  }

  public String getValue()
  {
    return this.value;
  }

  public String getParsedValue()
  {
    return StringUtil.replace("\n", "\\n", StringUtil.replace("\"", "\\\"", StringUtil.replace("\\", "\\\\", this.value)));
  }

  public void setValues(Object[] paramArrayOfObject, g[] paramArrayOfg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfObject.length; i++)
    {
      if (paramArrayOfObject[i] != null)
        if (paramArrayOfg[i].v())
        {
          localStringBuilder.append(Property.getInstance().formatDate(DateUtil.getDate(paramArrayOfObject[i])));
        }
        else if (paramArrayOfg[i].x())
        {
          localStringBuilder.append(Property.getInstance().formatDatetime(DateUtil.getDateTime(paramArrayOfObject[i])));
        }
        else if (paramArrayOfg[i].w())
        {
          localStringBuilder.append(Property.getInstance().formatTime(DateUtil.getTime(paramArrayOfObject[i])));
        }
        else
        {
          String str = paramArrayOfObject[i].toString();
          if (str.indexOf(",") >= 0)
            str = str.replace(',', '`');
          else if (str.indexOf("`") >= 0)
            throw new RuntimeException("can not include the char '`' , the error value is " + str);
          localStringBuilder.append(str);
        }
      if (i == paramArrayOfObject.length - 1)
        continue;
      localStringBuilder.append(",");
    }
    this.value = localStringBuilder.toString();
  }

  public Object[] getValues(g[] paramArrayOfg)
  {
    Object[] arrayOfObject = new Object[paramArrayOfg.length];
    String[] arrayOfString = StringUtil.split(this.value, ",");
    for (int i = 0; i < arrayOfObject.length; i++)
    {
      if (arrayOfString.length <= i)
        continue;
      arrayOfObject[i] = paramArrayOfg[i].f(arrayOfString[i]);
    }
    return arrayOfObject;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public String toString()
  {
    return this.value;
  }

  protected Object clone()
  {
    return new SheetValue(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.SheetValue
 * JD-Core Version:    0.6.0
 */