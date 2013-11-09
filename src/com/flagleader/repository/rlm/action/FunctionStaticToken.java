package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.tree.Envionment;
import java.util.Iterator;

public class FunctionStaticToken extends MemberToken
  implements IStatementToken
{
  public FunctionStaticToken(FunctionStaticToken paramFunctionStaticToken)
  {
    super(paramFunctionStaticToken);
  }

  public FunctionStaticToken()
  {
  }

  public FunctionStaticToken(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new FunctionStaticToken(this);
  }

  protected Iterator e()
  {
    String str = getValueType();
    return getEnvionment().getAcceptElements(new p(this, str));
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    String str = getValueType();
    if ((paramObject instanceof IFunctionObject))
    {
      IFunctionObject localIFunctionObject = (IFunctionObject)paramObject;
      if (((localIFunctionObject instanceof IFunctionObject)) && ((str == null) || (str.length() == 0) || (localIFunctionObject.getJavaType().d(str))))
        return true;
    }
    return false;
  }

  public String getName()
  {
    return "FunctionStaticToken";
  }

  protected String i()
  {
    return getLocalString("selectStaticFunction.text");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.FunctionStaticToken
 * JD-Core Version:    0.6.0
 */