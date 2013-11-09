package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.b.a;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.GlobalFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomFunctionSelectToken extends MemberToken
  implements IStatementToken
{
  public static final String DISPLAYNAME = getLocalString("setCustomMethod.edit");

  public CustomFunctionSelectToken(CustomFunctionSelectToken paramCustomFunctionSelectToken)
  {
    super(paramCustomFunctionSelectToken);
  }

  public CustomFunctionSelectToken()
  {
  }

  public CustomFunctionSelectToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new CustomFunctionSelectToken(this);
  }

  protected Iterator e()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a.d().e();
    for (int i = 0; (localList != null) && (i < localList.size()); i++)
    {
      if (acceptBusinessObject((GlobalFunction)localList.get(i)));
      localArrayList.add(localList.get(i));
    }
    return localArrayList.iterator();
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    return ((paramObject instanceof GlobalFunction)) && ((str == null) || (str.length() == 0) || (((GlobalFunction)paramObject).getJavaType().b(str)));
  }

  public GlobalFunction getConstantMember()
  {
    IElement localIElement = getMemberElement();
    if ((localIElement instanceof GlobalFunction))
      return (GlobalFunction)getMemberElement();
    return null;
  }

  public String getName()
  {
    return "CustomFunctionSelectToken";
  }

  public String getDisplayName()
  {
    String str = super.getDisplayName();
    if ((str != null) && (str.length() > 0))
      return str;
    return DISPLAYNAME;
  }

  protected IElement d()
  {
    List localList = a.d().e();
    for (int i = 0; (localList != null) && (i < localList.size()); i++)
      if ((((GlobalFunction)localList.get(i)).getUuid().equals(getElementUuid())) || (((GlobalFunction)localList.get(i)).getUniqueName().equals(getUniqueName())))
        return (GlobalFunction)localList.get(i);
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.CustomFunctionSelectToken
 * JD-Core Version:    0.6.0
 */