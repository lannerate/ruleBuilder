package com.flagleader.repository.rom;

import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.Y;
import com.flagleader.a.aa;
import com.flagleader.a.ak;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BusinessObjectMethod extends BusinessObjectMember
  implements IMethodFunction, ISubFunction
{
  protected List a = new ArrayList(3);

  public BusinessObjectMethod(BusinessObjectMethod paramBusinessObjectMethod)
  {
    super(paramBusinessObjectMethod);
    Iterator localIterator = paramBusinessObjectMethod.getParams().iterator();
    while (localIterator.hasNext())
      this.a.add(new MethodParam((MethodParam)localIterator.next()));
  }

  public BusinessObjectMethod()
  {
  }

  public BusinessObjectMethod(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new BusinessObjectMethod(this);
  }

  public String getName()
  {
    return "BusinessObjectMethod";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitBusinessObjectMethod(this);
  }

  public void setMember(M paramM, int paramInt)
  {
    this.a.clear();
    aa localaa = ((P)paramM).g();
    int i = 0;
    int j = paramInt;
    while (i < localaa.size())
    {
      this.a.add(new MethodParam(localaa.a(i).e().K(), j++));
      i++;
    }
    super.setMember(paramM, paramInt);
  }

  public List getParams()
  {
    return this.a;
  }

  public int getParamCount()
  {
    return this.a.size();
  }

  public void addParam(MethodParam paramMethodParam)
  {
    this.a.add(paramMethodParam);
  }

  public IBusinessObject getParentObject()
  {
    if ((getParent() != null) && ((getParent() instanceof IBusinessObject)))
      return (IBusinessObject)getParent();
    return null;
  }

  public IBusinessObject getRootMember()
  {
    IBusinessObject localIBusinessObject = getParentObject();
    if ((localIBusinessObject instanceof ISubFunction))
      return ((ISubFunction)localIBusinessObject).getRootMember();
    if (localIBusinessObject != null)
      return localIBusinessObject;
    return this;
  }

  public String getFunctionName()
  {
    return getMemberName();
  }

  public String getShortFunctionName()
  {
    return getShortMemberName();
  }

  public void changeParams()
  {
    for (int i = 1; i <= this.a.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.a.get(i - 1);
      if (!localMethodParam.hasDefaultValue())
        continue;
      changeDisplayName(getDisplayName(), StringUtil.replace("{" + localMethodParam.getParamName() + "}", localMethodParam.getDefaultValue(), getDisplayName()));
    }
  }

  public String getVarValue()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    if (getClassObject() != null)
    {
      localStringBuffer.append(getClassObject().getVarValue()).append(".");
      j = localStringBuffer.indexOf("{arg");
      int k = 0;
      if (j >= 0)
        do
        {
          k = localStringBuffer.indexOf("}", j);
          if (k <= j)
            break;
          i++;
          j = localStringBuffer.indexOf("{arg", k);
        }
        while (j >= 0);
    }
    localStringBuffer.append(getShortMemberName());
    localStringBuffer.append("(");
    for (int j = 1; j <= this.a.size(); j++)
    {
      MethodParam localMethodParam = (MethodParam)this.a.get(j - 1);
      if (localMethodParam.hasDefaultValue())
        localStringBuffer.append(localMethodParam.getDefaultValue());
      else
        localStringBuffer.append("{arg" + i++ + "}");
      if (j == this.a.size())
        continue;
      localStringBuffer.append(",");
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }

  public String getValueName()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getShortMemberName());
    localStringBuffer.append("(");
    for (int i = 1; i <= this.a.size(); i++)
    {
      MethodParam localMethodParam = (MethodParam)this.a.get(i - 1);
      if (localMethodParam.hasDefaultValue())
        localStringBuffer.append(localMethodParam.getDefaultValue());
      else
        localStringBuffer.append(localMethodParam.getTypeName());
      if (i == this.a.size())
        continue;
      localStringBuffer.append(",");
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.BusinessObjectMethod
 * JD-Core Version:    0.6.0
 */