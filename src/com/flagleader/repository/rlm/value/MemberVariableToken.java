package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rom.FunctionClass;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IClassObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class MemberVariableToken extends MemberToken
  implements IStatementToken
{
  public MemberVariableToken(MemberVariableToken paramMemberVariableToken)
  {
    super(paramMemberVariableToken);
  }

  public MemberVariableToken()
  {
  }

  public MemberVariableToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new MemberVariableToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new o(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IBusinessObjectEditen))
    {
      IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)paramObject;
      if ((localIBusinessObjectEditen instanceof IVariableObject))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IClassObject)) && (!(localIBusinessObjectEditen instanceof FunctionClass)))
      {
        if ((str == null) || (str.length() == 0) || (localIBusinessObjectEditen.getJavaType().d(str)))
          return true;
      }
      else if (((localIBusinessObjectEditen instanceof IFunctionObject)) && (((str != null) && (str.length() != 0)) || ((!localIBusinessObjectEditen.getJavaType().l()) || (localIBusinessObjectEditen.getJavaType().d(str)))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "MemberVariableToken";
  }

  protected String i()
  {
    return getLocalString("selectVariableMember.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.MemberVariableToken
 * JD-Core Version:    0.6.0
 */