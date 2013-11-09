package com.flagleader.repository.lang.info;

import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.Y;
import com.flagleader.a.aa;
import com.flagleader.a.ak;
import com.flagleader.repository.IElement;
import java.util.Iterator;

public class InfoMethod extends InfoMember
{
  public InfoMethod()
  {
  }

  public InfoMethod(InfoMethod paramInfoMethod)
  {
    super(paramInfoMethod);
  }

  public InfoMethod(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new InfoMethod(this);
  }

  public String getName()
  {
    return "InfoMethod";
  }

  public void setMember(M paramM)
  {
    clearAllChildren();
    aa localaa = ((P)paramM).g();
    for (int i = 0; i < localaa.size(); i++)
      addChildElement(new InfoParameter(localaa.a(i).I(), localaa.a(i).L(), localaa.a(i).e().K()));
    super.setMember(paramM);
  }

  public String getParameterInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof InfoParameter))
        continue;
      localStringBuffer.append("{").append(((InfoParameter)localObject).getDisplayName()).append(":");
      localStringBuffer.append(((InfoParameter)localObject).getTypeName()).append("}");
    }
    return localStringBuffer.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.InfoMethod
 * JD-Core Version:    0.6.0
 */