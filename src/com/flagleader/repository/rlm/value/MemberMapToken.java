package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.db.SheetMap;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class MemberMapToken extends MemberToken
  implements IStatementToken
{
  public MemberMapToken(MemberMapToken paramMemberMapToken)
  {
    super(paramMemberMapToken);
  }

  public MemberMapToken()
  {
  }

  public MemberMapToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new MemberMapToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new d(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObject))
    {
      IBusinessObject localIBusinessObject = (IBusinessObject)paramObject;
      if ((localIBusinessObject instanceof IVariableObject))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObject.getJavaType().d(str)))
          return true;
      }
      else if ((localIBusinessObject instanceof IFunctionObject))
      {
        if (((str != null) && (str.length() != 0)) || ((!localIBusinessObject.getJavaType().l()) || (localIBusinessObject.getJavaType().d(str))))
          return true;
      }
      else if (((localIBusinessObject instanceof SheetMap)) && (str != null) && (str.length() > 0) && (!localIBusinessObject.getJavaType().l()) && (localIBusinessObject.getJavaType().d(str)))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MemberMapToken";
  }

  protected String i()
  {
    return getLocalString("selectMapMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberMapToken
 * JD-Core Version:    0.6.0
 */