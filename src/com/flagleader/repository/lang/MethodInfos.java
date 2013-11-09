package com.flagleader.repository.lang;

import com.flagleader.repository.f;
import com.flagleader.util.TempID;
import java.util.ArrayList;
import java.util.List;

public class MethodInfos
  implements f
{
  List a = new ArrayList();
  List b = new ArrayList();
  String c = "";
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public void addGlobalMethod(GlobalMethod paramGlobalMethod)
  {
    this.a.add(paramGlobalMethod);
  }

  public List getGlobalMethods()
  {
    return this.a;
  }

  public void romoveMethod(GlobalMethod paramGlobalMethod)
  {
    this.a.remove(paramGlobalMethod);
  }

  public void romoveMethod(TypeMethod paramTypeMethod)
  {
    this.a.remove(paramTypeMethod);
  }

  public void addTypeMethod(TypeMethod paramTypeMethod)
  {
    this.b.add(paramTypeMethod);
  }

  public List getTypeMethods()
  {
    return this.b;
  }

  public String getDisplayName()
  {
    return this.c;
  }

  public void setDisplayName(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.MethodInfos
 * JD-Core Version:    0.6.0
 */