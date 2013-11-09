package com.flagleader.repository.export;

import com.flagleader.repository.f;
import com.flagleader.util.TempID;
import java.io.Serializable;

public class Property
  implements f, Serializable
{
  private String key = "";
  private String property = "";
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public Property()
  {
  }

  public Property(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.property = paramString2;
  }

  public Property(Property paramProperty)
  {
    this.key = paramProperty.key;
    this.property = paramProperty.property;
  }

  public String getKey()
  {
    return this.key;
  }

  public String getProperty()
  {
    return this.property;
  }

  public void setKey(String paramString)
  {
    this.key = paramString;
  }

  public void setProperty(String paramString)
  {
    this.property = paramString;
  }

  public String toString()
  {
    return this.key + ":" + this.property;
  }

  protected Object clone()
  {
    return new Property(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.Property
 * JD-Core Version:    0.6.0
 */